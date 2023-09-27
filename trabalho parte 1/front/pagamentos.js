document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnPagamentos').addEventListener('click', listarPagamentos);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnBuscarPagamento').addEventListener('click', criarFormularioBuscaPorPagamento);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnAdicionar').addEventListener('click', adicionarPagamento);
});

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnEditar').addEventListener('click', buscarParaEditar);
});

// document.addEventListener('DOMContentLoaded', () => {
//     document.getElementById('btnSalvarEdicao').addEventListener('click', salvarEdicao);
// });

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnExcluir').addEventListener('click', deletarPagamento);
});

function listarPagamentos() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    axios.get(`${baseURL}/pagamentos`)
        .then(response => {
            const listaDePagamentos = response.data;

            const resultadosAnteriores = document.querySelectorAll('.resultado-pagamento');
            resultadosAnteriores.forEach(resultado => resultado.remove());

            if (listaDePagamentos.length > 0) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-pagamento';
                container.appendChild(ul);

                listaDePagamentos.forEach(pagamento => {
                    const li = document.createElement('li');
                    li.textContent = `ID do Pagamento: ${pagamento.idPagamento}, Valor: ${pagamento.valorDoPagamento}, Data: ${pagamento.dataDoPagamento}`;
                    li.className = 'list-group-item';
                    ul.appendChild(li);
                });
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum pagamento encontrado.';
                noResults.className = 'resultado-pagamento';
                container.appendChild(noResults);
            }
        })
        .catch(error => console.error('Erro ao listar pagamentos:', error));
}

function criarFormularioBuscaPorPagamento() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const idPagamentoInput = document.createElement('input');
    idPagamentoInput.setAttribute('type', 'text');
    idPagamentoInput.setAttribute('id', 'inputIdPagamento');
    idPagamentoInput.setAttribute('placeholder', 'Digite o ID do Pagamento');

    const searchButton = document.createElement('button');
    searchButton.textContent = 'Buscar';
    searchButton.className = 'btn btn-primary btn-lg btn-large';
    searchButton.addEventListener('click', function () {
        const idPagamento = document.getElementById('inputIdPagamento').value;
        buscarPorPagamento(idPagamento);
    });

    container.appendChild(idPagamentoInput);
    container.appendChild(searchButton);
}

function buscarPorPagamento(idPagamento) {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    const ul = document.querySelector('.resultado-pagamento');

    if (ul) {
        ul.remove();
    }

    container.appendChild(reloadButton);

    axios.get(`${baseURL}/pagamentos/${idPagamento}`)
        .then(response => {
            const pagamento = response.data;
            if (pagamento) {
                const ul = document.createElement('ul');
                ul.className = 'list-group resultado-pagamento';
                container.appendChild(ul);

                const li = document.createElement('li');
                li.textContent = `ID do Pagamento: ${pagamento.idPagamento}, Valor: ${pagamento.valorDoPagamento}, Data: ${pagamento.dataDoPagamento}`;
                li.className = 'list-group-item';
                ul.appendChild(li);
            } else {
                const noResults = document.createElement('p');
                noResults.textContent = 'Nenhum pagamento encontrado para o ID informado.';
                noResults.className = 'resultado-pagamento';
                container.appendChild(noResults);
            }
        })
        .catch(error => alert('Erro ao buscar pagamento por ID: ' + `${idPagamento}`, error));
}

function adicionarPagamento() {
    const reloadButton = criarBotaoRecarregarPagina();
    const container = document.querySelector('.container');
    container.innerHTML = '';
    container.appendChild(reloadButton);

    const adicionarForm = document.createElement('form');
    adicionarForm.id = 'adicionar-form';

    const valorPagamentoInput = criarInput('Valor do Pagamento', 'inputValorPagamento', '');
    const dataPagamentoInput = criarInput('Data do Pagamento', 'inputDataPagamento', '', 'date');  // Adicionando campo de data

    const submitButton = document.createElement('button');
    submitButton.textContent = 'Adicionar Pagamento';
    submitButton.className = 'btn btn-primary';
    submitButton.addEventListener('click', function (event) {
        event.preventDefault();
        const formData = new FormData(adicionarForm);
        const valorDoPagamento = document.getElementById('inputValorPagamento').value;
        const dataDoPagamento = document.getElementById('inputDataPagamento').value;  // Obtendo a data do pagamento

        const pagamento = {
            valorDoPagamento: valorDoPagamento,
            dataDoPagamento: dataDoPagamento  // Incluindo a data no objeto de pagamento
        };

        axios.post(`${baseURL}/pagamentos`, pagamento)
            .then(response => {
                alert('Pagamento adicionado com sucesso:', response.data);
            })
            .catch(error => alert('Erro ao adicionar pagamento:', error));
    });

    adicionarForm.appendChild(valorPagamentoInput);
    adicionarForm.appendChild(dataPagamentoInput);
    adicionarForm.appendChild(submitButton);

    container.appendChild(adicionarForm);
}

function deletarPagamento() {
    const idPagamentoParaExcluir = prompt('Digite o ID do pagamento para confirmar a exclusão:');

    axios.delete(`${baseURL}/pagamentos/${idPagamentoParaExcluir}`)
        .then(response => {
            alert('Pagamento excluído com sucesso.');
        })
        .catch(error => console.error('Erro ao excluir pagamento:', error));
}

function buscarParaEditar() {
    const id = prompt('Digite o ID do pagamento que deseja editar:');
    if (id) {
        axios.get(`${baseURL}/pagamentos/${id}`)
            .then(response => {
                const pagamento = response.data;
                console.log('Pagamento encontrado para edição:', pagamento);
                if (pagamento) {
                    preencherCamposParaEdicao(pagamento);
                } else {
                    alert('Nenhum pagamento encontrado para o ID informado.');
                }
            })
            .catch(error => alert('Erro ao buscar pagamento para edição:', error));
    }
}

function preencherCamposParaEdicao(pagamento) {
    const container = document.querySelector('.container');
    container.innerHTML = '';

    const form = document.createElement('form');
    form.id = 'editar-form';

    const valorPagamentoInput = criarInput('Valor do Pagamento', 'inputValorPagamento', pagamento.valorDoPagamento);
    const dataPagamentoInput = criarInput('Data do Pagamento', 'inputDataPagamento', pagamento.dataDoPagamento, 'date');  // Preenchendo a data

    const salvarButton = document.createElement('button');
    salvarButton.textContent = 'Salvar Edição';
    salvarButton.className = 'btn btn-primary btn-lg btn-large';
    salvarButton.addEventListener('click', function () {
        salvarEdicao(pagamento.idPagamento);
    });

    form.appendChild(valorPagamentoInput);
    form.appendChild(dataPagamentoInput);
    form.appendChild(salvarButton);

    container.appendChild(form);
}

function salvarEdicao(idPagamento) {
    const valorDoPagamento = document.getElementById('inputValorPagamento').value; // Obter o valor do pagamento
    const dataDoPagamento = document.getElementById('inputDataPagamento').value;   // Obter a data do pagamento

    const pagamento = {
        valorDoPagamento: valorDoPagamento,  // Incluir o valor do pagamento
        dataDoPagamento: dataDoPagamento      // Incluir a data do pagamento
    };
    console.log('Pagamento editado:', pagamento);
    axios.put(`${baseURL}/pagamentos/${idPagamento}`, pagamento)
        .then(response => {
            console.log('Pagamento editado com sucesso:', response.data);
            limparCamposEdicao();
            listarPagamentos();
        })
        .catch(error => console.error('Erro ao editar pagamento:', error));
}



function limparCamposEdicao() {
    document.getElementById('inputValorPagamento').value = '';
    document.getElementById('inputDataPagamento').value = '';  // Limpando o campo de data
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

function criarInput(label, id, valor, type = 'text') {
    const divFormGroup = document.createElement('div');
    divFormGroup.className = 'form-group';

    const labelElement = document.createElement('label');
    labelElement.setAttribute('for', id);
    labelElement.textContent = label;

    const inputElement = document.createElement('input');
    inputElement.setAttribute('type', type);
    inputElement.setAttribute('id', id);
    inputElement.setAttribute('value', valor);
    inputElement.className = 'form-control';

    divFormGroup.appendChild(labelElement);
    divFormGroup.appendChild(inputElement);

    return divFormGroup;
}
