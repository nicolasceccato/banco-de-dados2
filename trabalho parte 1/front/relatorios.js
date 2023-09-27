document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('relatorio1').addEventListener('click', alunosPorPlano);
});
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('relatorio2').addEventListener('click', instrutoresEAlunos);
});
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('relatorio3').addEventListener('click', pagamentosPorAluno);
});

function alunosPorPlano() {
    const idPlano = prompt('Digite o ID do plano:');
    if (idPlano !== null) {

        buscarAlunosPorPlano(idPlano);
    }
}

function criarFormularioAlunos(alunos) {
    const formContainer = document.getElementById('formularioContainer');

    // Limpa o conteúdo anterior
    formContainer.innerHTML = '';

    // Cria um formulário
    const form = document.createElement('form');
    form.setAttribute('id', 'alunosForm');

    // Itera sobre os alunos e cria os campos para cada um
    alunos.forEach((aluno, index) => {
        const alunoDiv = document.createElement('div');
        const alunoIndex = index + 1; // Índice do aluno
        alunoDiv.innerHTML = `
            <input type="text" id="alunos" value="Aluno ${alunoIndex}: CPF: ${aluno.cpf}, Nome: ${aluno.nome}" class="aluno-input" disabled>
        `;
        form.appendChild(alunoDiv);
    });

    // Adiciona o formulário ao contêiner
    formContainer.appendChild(form);
}

function buscarAlunosPorPlano(idPlano) {
    axios.get(`${baseURL}/alunos/plano/${idPlano}`)
        .then(response => {
            const alunos = response.data;
            if (alunos.length > 0) {
                criarFormularioAlunos(alunos);
            } else {
                alert('Nenhum aluno encontrado para o plano informado.');
            }
        })
        .catch(error => {
            console.error('Erro ao buscar alunos por plano:', error);
            alert('Ocorreu um erro ao buscar os alunos por plano.');
        });
}
function instrutoresEAlunos() {
    axios.get(`${baseURL}/instrutores/instrutores-alunos`)
        .then(response => {
            const data = response.data;
            if (data.length > 0) {
                criarFormularioInstrutores(data);
            } else {
                alert('Nenhum instrutor encontrado com informações de alunos.');
            }
        })
        .catch(error => {
            console.error('Erro ao buscar instrutores e alunos:', error);
            alert('Ocorreu um erro ao buscar os instrutores e alunos.');
        });
}

function criarFormularioInstrutores(instrutoresData) {
    const formContainer = document.getElementById('formularioContainer');

    // Limpa o conteúdo anterior
    formContainer.innerHTML = '';

    // Cria um formulário
    const form = document.createElement('form');
    form.setAttribute('id', 'instrutoresForm');

    // Itera sobre os instrutores e cria os campos para cada um
    instrutoresData.forEach((instrutorData, index) => {
        const instrutorDiv = document.createElement('div');
        const instrutorIndex = index + 1; // Índice do instrutor
        const [instrutor, numAlunos] = instrutorData; // Desestruturação da array

        instrutorDiv.innerHTML = `
            <input type="text" id="instrutor${instrutor.matricula}" value="Instrutor ${instrutorIndex}: Matrícula: ${instrutor.matricula}, Quantidade de Alunos: ${numAlunos}" class="instrutor-input" disabled>
        `;
        form.appendChild(instrutorDiv);
    });

    // Adiciona o formulário ao contêiner
    formContainer.appendChild(form);
}
