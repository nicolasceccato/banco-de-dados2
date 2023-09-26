const baseURL = 'http://localhost:8080';

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnAlunos').addEventListener('click', listarAlunos);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnBuscarCpf').addEventListener('click', criarFormularioBuscaPorCpf);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnAdicionar').addEventListener('click', adicionarAluno);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnEditar').addEventListener('click', buscarParaEditar);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnSalvarEdicao').addEventListener('click', salvarEdicao);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnExcluir').addEventListener('click', deletarAluno);
});

function listarAlunos() {
    // Adiciona um botão para recarregar a página
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    axios.get(`${baseURL}/alunos`)
        .then(response => {
            const listaDeAlunos = response.data;

            const resultadosAnteriores = document.querySelectorAll('.resultado-aluno');
            resultadosAnteriores.forEach(resultado => resultado.remove());

            if (listaDeAlunos.length > 0) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-aluno';
                container.appendChild(ul);

                listaDeAlunos.forEach(aluno => {
                    const li = document.createElement('li');
                    li.textContent = `CPF: ${aluno.cpf}, Nome: ${aluno.nome}`;
                    li.className = 'list-group-item';
                    ul.appendChild(li);
                });
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum aluno encontrado.';
                noResults.className = 'resultado-aluno';
                container.appendChild(noResults);
            }
        })
        .catch(error => console.error('Erro ao listar alunos:', error));
}

function criarFormularioBuscaPorCpf() {
    // Adiciona um botão para recarregar a página
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const cpfInput = document.createElement('input');
    cpfInput.setAttribute('type', 'text');
    cpfInput.setAttribute('id', 'inputCpf');
    cpfInput.setAttribute('placeholder', 'Digite o CPF');

    const searchButton = document.createElement('button');
    searchButton.textContent = 'Buscar';
    searchButton.className = 'btn btn-primary btn-lg btn-large';
    searchButton.addEventListener('click', function () {
        const cpf = document.getElementById('inputCpf').value;
        buscarPorCpf(cpf);
    });

    container.appendChild(cpfInput);
    container.appendChild(searchButton);
}

function buscarPorCpf(cpf) {
    // Adiciona um botão para recarregar a página
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    const ul = document.querySelector('.resultado-aluno');

    if (ul) {
        ul.remove();
    }

    container.appendChild(reloadButton);

    axios.get(`${baseURL}/alunos/${cpf}`)
        .then(response => {
            const aluno = response.data;
            if (aluno) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-aluno';
                container.appendChild(ul);

                const li = document.createElement('li');
                li.textContent = `CPF: ${aluno.cpf}, Nome: ${aluno.nome}`;
                li.className = 'list-group-item';
                ul.appendChild(li);
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum aluno encontrado para o CPF informado.';
                noResults.className = 'resultado-aluno';
                container.appendChild(noResults);
            }
        })
        .catch(error => alert('Erro ao buscar aluno por CPF: ' + `${cpf}`, error));
}

function adicionarAluno() {
    // Adiciona um botão para recarregar a página
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const adicionarForm = document.createElement('form');
    adicionarForm.id = 'adicionar-form';

    const cpfInput = criarInput('CPF', 'inputCpf', '');
    const nomeInput = criarInput('Nome', 'inputNome', '');
    const emailInput = criarInput('Email', 'inputEmail', '');
    const telefoneInput = criarInput('Telefone', 'inputTelefone', '');

    const submitButton = document.createElement('button');
    submitButton.textContent = 'Adicionar Aluno';
    submitButton.className = 'btn btn-primary';
    submitButton.addEventListener('click', function (event) {
        event.preventDefault(); // Evita o envio padrão do formulário
        const formData = new FormData(adicionarForm);
        const cpf = document.getElementById('inputCpf').value;
        const nome = document.getElementById('inputNome').value;
        const email = document.getElementById('inputEmail').value;
        const telefone = document.getElementById('inputTelefone').value;

        const aluno = {
            cpf: cpf,
            nome: nome,
            email: email,
            telefone: telefone
        };
        console.log('Aluno:', aluno);  // Verifica o objeto aluno antes de enviar
        axios.post(`${baseURL}/alunos`, aluno)
            .then(response => {
                alert('Aluno adicionado com sucesso:', response.data);
                //toggleAddingAluno();
                //listarAlunos();
            })
            .catch(error => alert('Erro ao adicionar aluno:', error));
    });

    adicionarForm.appendChild(cpfInput);
    adicionarForm.appendChild(nomeInput);
    adicionarForm.appendChild(emailInput);
    adicionarForm.appendChild(telefoneInput);
    adicionarForm.appendChild(submitButton);

    container.appendChild(adicionarForm);
}

// Função para criar um botão para recarregar a página
function criarBotaoRecarregarPagina() {
    const reloadButton = document.createElement('button');
    reloadButton.textContent = 'Voltar';
    reloadButton.className = 'btn btn-secondary';
    reloadButton.addEventListener('click', function () {
        location.reload();
    });
    return reloadButton;
}

function buscarParaEditar() {
    const cpf = prompt('Digite o CPF do aluno que deseja editar:');
    if (cpf) {
        axios.get(`${baseURL}/alunos/${cpf}`)
            .then(response => {
                const aluno = response.data;
                console.log('Aluno encontrado para edição:', aluno);
                if (aluno) {
                    // limparCamposEdicao();  // Limpar os campos antes de preencher
                    preencherCamposParaEdicao(aluno);
                } else {
                    alert('Nenhum aluno encontrado para o CPF informado.');
                }
            })
            .catch(error => alert('Erro ao buscar aluno para edição:', error));
    }
}

function preencherCamposParaEdicao(aluno) {
    const container = document.querySelector('.container');
    container.innerHTML = '';  // Limpa o conteúdo anterior

    const form = document.createElement('form');
    form.id = 'editar-form';

    const cpfInput = criarInput('CPF', 'inputCpf', aluno.cpf);
    const nomeInput = criarInput('Nome', 'inputNome', aluno.nome);
    const emailInput = criarInput('Email', 'inputEmail', aluno.email);
    const telefoneInput = criarInput('Telefone', 'inputTelefone', aluno.telefone);

    const salvarButton = document.createElement('button');
    salvarButton.textContent = 'Salvar Edição';
    salvarButton.className = 'btn btn-primary btn-lg btn-large';
    salvarButton.addEventListener('click', function () {
        salvarEdicao();
    });

    form.appendChild(cpfInput);
    form.appendChild(nomeInput);
    form.appendChild(emailInput);
    form.appendChild(telefoneInput);
    form.appendChild(salvarButton);

    container.appendChild(form);
}

function criarInput(labelText, id, valor) {
    const divFormGroup = document.createElement('div');
    divFormGroup.className = 'form-group';

    const label = document.createElement('label');
    label.textContent = labelText;

    const input = document.createElement('input');
    input.setAttribute('type', 'text');
    input.setAttribute('id', id);
    input.setAttribute('value', valor);
    input.className = 'form-control';

    divFormGroup.appendChild(label);
    divFormGroup.appendChild(input);

    return divFormGroup;
}

function salvarEdicao() {
    const cpf = document.getElementById('inputCpf').value;
    const aluno = {
        nome: document.getElementById('inputNome').value,
        email: document.getElementById('inputEmail').value,
        telefone: document.getElementById('inputTelefone').value,
    };

    axios.put(`${baseURL}/alunos/${cpf}`, aluno)
        .then(response => {
            console.log('Aluno editado com sucesso:', response.data);
            limparCamposEdicao();
            listarAlunos(); // Atualiza a lista após editar um aluno
        })
        .catch(error => console.error('Erro ao editar aluno:', error));
}

function limparCamposEdicao() {
    document.getElementById('inputCpf').value = '';
    document.getElementById('inputNome').value = '';
    document.getElementById('inputEmail').value = '';
    document.getElementById('inputTelefone').value = '';
}
function deletarAluno() {
    const cpfParaExcluir = prompt('Digite o CPF do aluno para confirmar a exclusão:');

    axios.delete(`${baseURL}/alunos/${cpfParaExcluir}`)
        .then(response => {
            alert('Aluno excluído com sucesso.');
            //listarAlunos(); // Atualiza a lista após excluir o aluno
        })
        .catch(error => console.error('Erro ao excluir aluno:', error));
}

