package com.bancodedados2.academia.ui;

import com.bancodedados2.academia.controllers.AlunoController;

import java.util.Scanner;

public class Menu {

    private static MenuAluno menuAluno = new MenuAluno();

    public Menu(AlunoController alunoController) {
        alunoController = alunoController;
    }


    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Instrutores");
            System.out.println("3. Gerenciar Pagamentos");
            System.out.println("4. Gerenciar Planos");
            System.out.println("5. Gerenciar Treinos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    menuAluno.menuAluno();
                    break;
                case 2:
                    menuInstrutor();
                    break;
                case 3:
                    menuPagamento();
                    break;
                case 4:
                    menuPlano();
                    break;
                case 5:
                    menuTreino();
                    break;
                case 6:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 6);
    }


    private static void menuInstrutor() {
        // Implemente aqui o menu para gerenciar instrutores (CRUD)
        // Use instrutorRepository para interagir com a entidade Instrutor
    }

    private static void menuPagamento() {
        // Implemente aqui o menu para gerenciar pagamentos (CRUD)
        // Use pagamentoRepository para interagir com a entidade Pagamento
    }

    private static void menuPlano() {
        // Implemente aqui o menu para gerenciar planos (CRUD)
        // Use planoRepository para interagir com a entidade Plano
    }

    private static void menuTreino() {
        // Implemente aqui o menu para gerenciar treinos (CRUD)
        // Use treinoRepository para interagir com a entidade Treino
    }
}
