document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnAlunosPorTreino').addEventListener('click', contarAlunosPorTreino);
});

function contarAlunosPorTreino() {
    const idTreino = prompt('Digite o ID do treino:');
    if (idTreino !== null) {
        axios.get(`${baseURL}/treinos/alunos/${idTreino}`)
            .then(response => {
                const numAlunos = response.data;
                alert(`Número de alunos para o treino ${idTreino}: ${numAlunos}`);
            })
            .catch(error => {
                console.error('Erro ao contar alunos por treino:', error);
                alert('Ocorreu um erro ao contar os alunos por treino.');
            });
    }
}
