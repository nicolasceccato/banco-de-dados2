package com.bancodedados2.academia.ui;

import com.bancodedados2.academia.entities.Aluno;

import java.util.List;
import java.util.Scanner;

public class MenuAluno {

    private AlunoClient alunoClient;

    public MenuAluno() {
        this.alunoClient = new AlunoClient();
    }

    public void menuAluno() {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("=== MENU DE ALUNOS ===");
            System.out.println("1. Listar Alunos");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Visualizar Aluno");
            System.out.println("4. Atualizar Aluno");
            System.out.println("5. Excluir Aluno");
            System.out.println("6. Voltar ao menu principal");
            System.out.println("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    listarAlunos();
                    break;
                case 2:
                    //cadastrarAluno();
                    break;
                case 3:
                    //visualizarAluno();
                    break;
                case 4:
                    //atualizarAluno();
                    break;
                case 5:
                    //excluirAluno();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 6);
    }

    private void listarAlunos() {
        List<Aluno> listaDeAlunos = alunoClient.listarAlunos();
        if (!listaDeAlunos.isEmpty()) {
            for (Aluno aluno : listaDeAlunos) {
                System.out.println("CPF: " + aluno.getCpf() + "; Nome: " + aluno.getNome() + "; Plano: " + aluno.getPlano());
            }
        } else {
            System.out.println("Falha ao listar os alunos.");
        }
    }
}
