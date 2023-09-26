
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnInstrutores').addEventListener('click', listarInstrutores);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnBuscarMatricula').addEventListener('click', criarFormularioBuscaPorMatricula);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnAdicionar').addEventListener('click', adicionarInstrutor);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnEditar').addEventListener('click', buscarParaEditar);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnSalvarEdicao').addEventListener('click', salvarEdicao);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnExcluir').addEventListener('click', deletarInstrutor);
});

function listarInstrutores() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    axios.get(`${baseURL}/instrutores`)
        .then(response => {
            const listaDeInstrutores = response.data;

            const resultadosAnteriores = document.querySelectorAll('.resultado-instrutor');
            resultadosAnteriores.forEach(resultado => resultado.remove());

            if (listaDeInstrutores.length > 0) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-instrutor';
                container.appendChild(ul);

                listaDeInstrutores.forEach(instrutor => {
                    const li = document.createElement('li');
                    li.textContent = `Matrícula: ${instrutor.matricula}, Nome: ${instrutor.nome}`;
                    li.className = 'list-group-item';
                    ul.appendChild(li);
                });
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum instrutor encontrado.';
                noResults.className = 'resultado-instrutor';
                container.appendChild(noResults);
            }
        })
        .catch(error => console.error('Erro ao listar instrutores:', error));
}

function criarFormularioBuscaPorMatricula() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const matriculaInput = document.createElement('input');
    matriculaInput.setAttribute('type', 'text');
    matriculaInput.setAttribute('id', 'inputMatricula');
    matriculaInput.setAttribute('placeholder', 'Digite a Matrícula');

    const searchButton = document.createElement('button');
    searchButton.textContent = 'Buscar';
    searchButton.className = 'btn btn-primary btn-lg btn-large';
    searchButton.addEventListener('click', function () {
        const matricula = document.getElementById('inputMatricula').value;
        buscarPorMatricula(matricula);
    });

    container.appendChild(matriculaInput);
    container.appendChild(searchButton);
}

function buscarPorMatricula(matricula) {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    const ul = document.querySelector('.resultado-instrutor');

    if (ul) {
        ul.remove();
    }

    container.appendChild(reloadButton);

    axios.get(`${baseURL}/instrutores/${matricula}`)
        .then(response => {
            const instrutor = response.data;
            if (instrutor) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-instrutor';
                container.appendChild(ul);

                const li = document.createElement('li');
                li.textContent = `Matrícula: ${instrutor.matricula}, Nome: ${instrutor.nome}`;
                li.className = 'list-group-item';
                ul.appendChild(li);
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum instrutor encontrado para a Matrícula informada.';
                noResults.className = 'resultado-instrutor';
                container.appendChild(noResults);
            }
        })
        .catch(error => alert('Erro ao buscar instrutor por Matrícula: ' + `${matricula}`, error));
}

function adicionarInstrutor() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const adicionarForm = document.createElement('form');
    adicionarForm.id = 'adicionar-form';

    const nomeInput = criarInput('Nome', 'inputNome', '');
    const emailInput = criarInput('Email', 'inputEmail', '');
    const telefoneInput = criarInput('Telefone', 'inputTelefone', '');

    const submitButton = document.createElement('button');
    submitButton.textContent = 'Adicionar Instrutor';
    submitButton.className = 'btn btn-primary';
    submitButton.addEventListener('click', function (event) {
        event.preventDefault();
        const formData = new FormData(adicionarForm);
        const nome = document.getElementById('inputNome').value;
        const email = document.getElementById('inputEmail').value;
        const telefone = document.getElementById('inputTelefone').value;

        const instrutor = {
            nome: nome,
            email: email,
            telefone: telefone
        };

        axios.post(`${baseURL}/instrutores`, instrutor)
            .then(response => {
                alert('Instrutor adicionado com sucesso:', response.data);
            })
            .catch(error => alert('Erro ao adicionar instrutor:', error));
    });


    adicionarForm.appendChild(nomeInput);
    adicionarForm.appendChild(emailInput);
    adicionarForm.appendChild(telefoneInput);
    adicionarForm.appendChild(submitButton);

    container.appendChild(adicionarForm);
}

function deletarInstrutor() {
    const matriculaParaExcluir = prompt('Digite a Matrícula do instrutor para confirmar a exclusão:');

    axios.delete(`${baseURL}/instrutores/${matriculaParaExcluir}`)
        .then(response => {
            alert('Instrutor excluído com sucesso.');
        })
        .catch(error => console.error('Erro ao excluir instrutor:', error));
}

function buscarParaEditar() {
    const mat = prompt('Digite a matricula do instrutor que deseja editar:');
    if (mat) {
        axios.get(`${baseURL}/instrutores/${mat}`)
            .then(response => {
                const instrutor = response.data;
                console.log('Instrutor encontrado para edição:', instrutor);
                if (instrutor) {
                    preencherCamposParaEdicao(instrutor);
                } else {
                    alert('Nenhum instrutor encontrado para a matricula informada.');
                }
            })
            .catch(error => alert('Erro ao buscar instrutor para edição:', error));
    }
}

function preencherCamposParaEdicao(instrutor) {
    const container = document.querySelector('.container');
    container.innerHTML = '';

    const form = document.createElement('form');
    form.id = 'editar-form';

    const nomeInput = criarInput('Nome', 'inputNome', instrutor.nome);
    const emailInput = criarInput('Email', 'inputEmail', instrutor.email);
    const telefoneInput = criarInput('Telefone', 'inputTelefone', instrutor.telefone);

    const salvarButton = document.createElement('button');
    salvarButton.textContent = 'Salvar Edição';
    salvarButton.className = 'btn btn-primary btn-lg btn-large';
    salvarButton.addEventListener('click', function () {
        salvarEdicao(instrutor.matricula);
    });

    form.appendChild(nomeInput);
    form.appendChild(emailInput);
    form.appendChild(telefoneInput);
    form.appendChild(salvarButton);

    container.appendChild(form);
}

function salvarEdicao(matricula) {
    const instrutor = {
        nome: document.getElementById('inputNome').value,
        email: document.getElementById('inputEmail').value,
        telefone: document.getElementById('inputTelefone').value
    };

    axios.put(`${baseURL}/instrutores/${matricula}`, instrutor)
        .then(response => {
            console.log('Instrutor editado com sucesso:', response.data);
            limparCamposEdicao();
            listarInstrutores();
        })
        .catch(error => console.error('Erro ao editar instrutor:', error));
}

function limparCamposEdicao() {
    document.getElementById('inputNome').value = '';
    document.getElementById('inputEmail').value = '';
    document.getElementById('inputTelefone').value = '';
}

function criarBotaoRecarregarPagina() {
    const reloadButton = document.createElement('button');
    reloadButton.textContent = 'Voltar';
    reloadButton.className = 'btn btn-secondary';
    reloadButton.addEventListener('click', function () {
        location.reload();
    });
    return reloadButton;
}
function criarInput(label, id, valor) {
    const divFormGroup = document.createElement('div');
    divFormGroup.className = 'form-group';

    const labelElement = document.createElement('label');
    labelElement.setAttribute('for', id);
    labelElement.textContent = label;

    const inputElement = document.createElement('input');
    inputElement.setAttribute('type', 'text');
    inputElement.setAttribute('id', id);
    inputElement.setAttribute('value', valor);
    inputElement.className = 'form-control';

    divFormGroup.appendChild(labelElement);
    divFormGroup.appendChild(inputElement);

    return divFormGroup;
}
