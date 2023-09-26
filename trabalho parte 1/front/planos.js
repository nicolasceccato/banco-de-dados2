document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnPlanos').addEventListener('click', listarPlanos);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnBuscarPlano').addEventListener('click', criarFormularioBuscaPorPlano);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnAdicionar').addEventListener('click', adicionarPlano);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnEditar').addEventListener('click', buscarParaEditar);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnSalvarEdicao').addEventListener('click', salvarEdicao);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnExcluir').addEventListener('click', deletarPlano);
});

function listarPlanos() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    axios.get(`${baseURL}/planos`)
        .then(response => {
            const listaDePlanos = response.data;

            const resultadosAnteriores = document.querySelectorAll('.resultado-plano');
            resultadosAnteriores.forEach(resultado => resultado.remove());

            if (listaDePlanos.length > 0) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-plano';
                container.appendChild(ul);

                listaDePlanos.forEach(plano => {
                    const li = document.createElement('li');
                    li.textContent = `ID do Plano: ${plano.idPlano}, Nome: ${plano.nomeDoPlano}`;
                    li.className = 'list-group-item';
                    ul.appendChild(li);
                });
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum plano encontrado.';
                noResults.className = 'resultado-plano';
                container.appendChild(noResults);
            }
        })
        .catch(error => console.error('Erro ao listar planos:', error));
}

function criarFormularioBuscaPorPlano() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const idPlanoInput = document.createElement('input');
    idPlanoInput.setAttribute('type', 'text');
    idPlanoInput.setAttribute('id', 'inputIdPlano');
    idPlanoInput.setAttribute('placeholder', 'Digite o ID do Plano');

    const searchButton = document.createElement('button');
    searchButton.textContent = 'Buscar';
    searchButton.className = 'btn btn-primary btn-lg btn-large';
    searchButton.addEventListener('click', function () {
        const idPlano = document.getElementById('inputIdPlano').value;
        buscarPorPlano(idPlano);
    });

    container.appendChild(idPlanoInput);
    container.appendChild(searchButton);
}

function buscarPorPlano(idPlano) {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    const ul = document.querySelector('.resultado-plano');

    if (ul) {
        ul.remove();
    }

    container.appendChild(reloadButton);

    axios.get(`${baseURL}/planos/${idPlano}`)
        .then(response => {
            const plano = response.data;
            if (plano) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-plano';
                container.appendChild(ul);

                const li = document.createElement('li');
                li.textContent = `ID do Plano: ${plano.idPlano}, Nome: ${plano.nomeDoPlano}`;
                li.className = 'list-group-item';
                ul.appendChild(li);
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum plano encontrado para o ID informado.';
                noResults.className = 'resultado-plano';
                container.appendChild(noResults);
            }
        })
        .catch(error => alert('Erro ao buscar plano por ID: ' + `${idPlano}`, error));
}

function adicionarPlano() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const adicionarForm = document.createElement('form');
    adicionarForm.id = 'adicionar-form';

    const nomePlanoInput = criarInput('Nome do Plano', 'inputNomePlano', '');
    const descricaoInput = criarInput('Descrição', 'inputDescricao', '');

    const submitButton = document.createElement('button');
    submitButton.textContent = 'Adicionar Plano';
    submitButton.className = 'btn btn-primary';
    submitButton.addEventListener('click', function (event) {
        event.preventDefault();
        const formData = new FormData(adicionarForm);
        const nomeDoPlano = document.getElementById('inputNomePlano').value;
        const descricao = document.getElementById('inputDescricao').value;

        const plano = {
            nomeDoPlano: nomeDoPlano,
            descricao: descricao
        };

        axios.post(`${baseURL}/planos`, plano)
            .then(response => {
                alert('Plano adicionado com sucesso:', response.data);
            })
            .catch(error => alert('Erro ao adicionar plano:', error));
    });

    adicionarForm.appendChild(nomePlanoInput);
    adicionarForm.appendChild(descricaoInput);
    adicionarForm.appendChild(submitButton);

    container.appendChild(adicionarForm);
}

function deletarPlano() {
    const idPlanoParaExcluir = prompt('Digite o ID do plano para confirmar a exclusão:');

    axios.delete(`${baseURL}/planos/${idPlanoParaExcluir}`)
        .then(response => {
            alert('Plano excluído com sucesso.');
        })
        .catch(error => console.error('Erro ao excluir plano:', error));
}

function buscarParaEditar() {
    const id = prompt('Digite o ID do plano que deseja editar:');
    if (id) {
        axios.get(`${baseURL}/planos/${id}`)
            .then(response => {
                const plano = response.data;
                console.log('Plano encontrado para edição:', plano);
                if (plano) {
                    preencherCamposParaEdicao(plano);
                } else {
                    alert('Nenhum plano encontrado para o ID informado.');
                }
            })
            .catch(error => alert('Erro ao buscar plano para edição:', error));
    }
}

function preencherCamposParaEdicao(plano) {
    const container = document.querySelector('.container');
    container.innerHTML = '';

    const form = document.createElement('form');
    form.id = 'editar-form';

    const nomePlanoInput = criarInput('Nome do Plano', 'inputNomePlano', plano.nomeDoPlano);
    const descricaoInput = criarInput('Descrição', 'inputDescricao', plano.descricao);

    const salvarButton = document.createElement('button');
    salvarButton.textContent = 'Salvar Edição';
    salvarButton.className = 'btn btn-primary btn-lg btn-large';
    salvarButton.addEventListener('click', function () {
        salvarEdicao(plano.idPlano);
    });

    form.appendChild(nomePlanoInput);
    form.appendChild(descricaoInput);
    form.appendChild(salvarButton);

    container.appendChild(form);
}

function salvarEdicao(idPlano) {
    const plano = {
        nomeDoPlano: document.getElementById('inputNomePlano').value,
        descricao: document.getElementById('inputDescricao').value
    };

    axios.put(`${baseURL}/planos/${idPlano}`, plano)
        .then(response => {
            console.log('Plano editado com sucesso:', response.data);
            limparCamposEdicao();
            listarPlanos();
        })
        .catch(error => console.error('Erro ao editar plano:', error));
}

function limparCamposEdicao() {
    document.getElementById('inputNomePlano').value = '';
    document.getElementById('inputDescricao').value = '';
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
