document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btnInstrutoresPorTreino').addEventListener('click', contarInstrutoresPorTreino);
});

function contarInstrutoresPorTreino() {
    const idTreino = prompt('Digite o ID do treino:');
    if (idTreino !== null) {
        axios.get(`${baseURL}/treinos/instrutores/${idTreino}`)
            .then(response => {
                const numInstrutores = response.data;
                alert(`Número de instrutores para o treino ${idTreino}: ${numInstrutores}`);
            })
            .catch(error => {
                console.error('Erro ao contar instrutores por treino:', error);
                alert('Ocorreu um erro ao contar os instrutores por treino.');
            });
    }
}
