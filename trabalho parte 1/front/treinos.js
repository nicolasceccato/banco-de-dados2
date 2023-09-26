document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnTreinos').addEventListener('click', listarTreinos);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnBuscarTreino').addEventListener('click', criarFormularioBuscaPorTreino);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnAdicionar').addEventListener('click', adicionarTreino);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnEditar').addEventListener('click', buscarParaEditar);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnSalvarEdicao').addEventListener('click', salvarEdicao);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnExcluir').addEventListener('click', deletarTreino);
});

function listarTreinos() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    axios.get(`${baseURL}/treinos`)
        .then(response => {
            const listaDeTreinos = response.data;

            const resultadosAnteriores = document.querySelectorAll('.resultado-treino');
            resultadosAnteriores.forEach(resultado => resultado.remove());

            if (listaDeTreinos.length > 0) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-treino';
                container.appendChild(ul);

                listaDeTreinos.forEach(treino => {
                    const li = document.createElement('li');
                    li.textContent = `ID do Treino: ${treino.idTreino}, Nome: ${treino.nomeDoTreino}`;
                    li.className = 'list-group-item';
                    ul.appendChild(li);
                });
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum treino encontrado.';
                noResults.className = 'resultado-treino';
                container.appendChild(noResults);
            }
        })
        .catch(error => console.error('Erro ao listar treinos:', error));
}

function criarFormularioBuscaPorTreino() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const idTreinoInput = document.createElement('input');
    idTreinoInput.setAttribute('type', 'text');
    idTreinoInput.setAttribute('id', 'inputIdTreino');
    idTreinoInput.setAttribute('placeholder', 'Digite o ID do Treino');

    const searchButton = document.createElement('button');
    searchButton.textContent = 'Buscar';
    searchButton.className = 'btn btn-primary btn-lg btn-large';
    searchButton.addEventListener('click', function () {
        const idTreino = document.getElementById('inputIdTreino').value;
        buscarPorTreino(idTreino);
    });

    container.appendChild(idTreinoInput);
    container.appendChild(searchButton);
}

function buscarPorTreino(idTreino) {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    const ul = document.querySelector('.resultado-treino');

    if (ul) {
        ul.remove();
    }

    container.appendChild(reloadButton);

    axios.get(`${baseURL}/treinos/${idTreino}`)
        .then(response => {
            const treino = response.data;
            if (treino) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-treino';
                container.appendChild(ul);

                const li = document.createElement('li');
                li.textContent = `ID do Treino: ${treino.idTreino}, Nome: ${treino.nomeDoTreino}`;
                li.className = 'list-group-item';
                ul.appendChild(li);
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum treino encontrado para o ID informado.';
                noResults.className = 'resultado-treino';
                container.appendChild(noResults);
            }
        })
        .catch(error => alert('Erro ao buscar treino por ID: ' + `${idTreino}`, error));
}

function adicionarTreino() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const adicionarForm = document.createElement('form');
    adicionarForm.id = 'adicionar-form';

    const nomeTreinoInput = criarInput('Nome do Treino', 'inputNomeTreino', '');
    const descricaoInput = criarInput('Descrição', 'inputDescricao', '');
    const duracaoInput = criarInput('Duração em minutos', 'inputDuracao', '');
    const dataTreinoInput = criarInput('Data do Treino', 'inputDataTreino', '');

    const submitButton = document.createElement('button');
    submitButton.textContent = 'Adicionar Treino';
    submitButton.className = 'btn btn-primary';
    submitButton.addEventListener('click', function (event) {
        event.preventDefault();
        const formData = new FormData(adicionarForm);
        const nomeDoTreino = document.getElementById('inputNomeTreino').value;
        const descricao = document.getElementById('inputDescricao').value;
        const duracaoEmMinutos = document.getElementById('inputDuracao').value;
        const dataDoTreino = document.getElementById('inputDataTreino').value;

        const treino = {
            nomeDoTreino: nomeDoTreino,
            descricao: descricao,
            duracaoEmminutos: duracaoEmMinutos,
            dataDoTreino: dataDoTreino
        };

        axios.post(`${baseURL}/treinos`, treino)
            .then(response => {
                alert('Treino adicionado com sucesso:', response.data);
            })
            .catch(error => alert('Erro ao adicionar treino:', error));
    });

    adicionarForm.appendChild(nomeTreinoInput);
    adicionarForm.appendChild(descricaoInput);
    adicionarForm.appendChild(duracaoInput);
    adicionarForm.appendChild(dataTreinoInput);
    adicionarForm.appendChild(submitButton);

    container.appendChild(adicionarForm);
}

function deletarTreino() {
    const idTreinoParaExcluir = prompt('Digite o ID do treino para confirmar a exclusão:');

    axios.delete(`${baseURL}/treinos/${idTreinoParaExcluir}`)
        .then(response => {
            alert('Treino excluído com sucesso.');
        })
        .catch(error => console.error('Erro ao excluir treino:', error));
}

function buscarParaEditar() {
    const id = prompt('Digite o ID do treino que deseja editar:');
    if (id) {
        axios.get(`${baseURL}/treinos/${id}`)
            .then(response => {
                const treino = response.data;
                console.log('Treino encontrado para edição:', treino);
                if (treino) {
                    preencherCamposParaEdicao(treino);
                } else {
                    alert('Nenhum treino encontrado para o ID informado.');
                }
            })
            .catch(error => alert('Erro ao buscar treino para edição:', error));
    }
}

function preencherCamposParaEdicao(treino) {
    const container = document.querySelector('.container');
    container.innerHTML = '';

    const form = document.createElement('form');
    form.id = 'editar-form';

    const nomeTreinoInput = criarInput('Nome do Treino', 'inputNomeTreino', treino.nomeDoTreino);
    const descricaoInput = criarInput('Descrição', 'inputDescricao', treino.descricao);
    const duracaoInput = criarInput('Duração em minutos', 'inputDuracao', treino.duracaoEmminutos);
    const dataTreinoInput = criarInput('Data do Treino', 'inputDataTreino', treino.dataDoTreino);

    const salvarButton = document.createElement('button');
    salvarButton.textContent = 'Salvar Edição';
    salvarButton.className = 'btn btn-primary btn-lg btn-large';
    salvarButton.addEventListener('click', function () {
        salvarEdicao(treino.idTreino);
    });

    form.appendChild(nomeTreinoInput);
    form.appendChild(descricaoInput);
    form.appendChild(duracaoInput);
    form.appendChild(dataTreinoInput);
    form.appendChild(salvarButton);

    container.appendChild(form);
}

function salvarEdicao(idTreino) {
    const treino = {
        nomeDoTreino: document.getElementById('inputNomeTreino').value,
        descricao: document.getElementById('inputDescricao').value,
        duracaoEmminutos: document.getElementById('inputDuracao').value,
        dataDoTreino: document.getElementById('inputDataTreino').value
    };

    axios.put(`${baseURL}/treinos/${idTreino}`, treino)
        .then(response => {
            console.log('Treino editado com sucesso:', response.data);
            limparCamposEdicao();
            listarTreinos();
        })
        .catch(error => console.error('Erro ao editar treino:', error));
}

function limparCamposEdicao() {
    document.getElementById('inputNomeTreino').value = '';
    document.getElementById('inputDescricao').value = '';
    document.getElementById('inputDuracao').value = '';
    document.getElementById('inputDataTreino').value = '';
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
