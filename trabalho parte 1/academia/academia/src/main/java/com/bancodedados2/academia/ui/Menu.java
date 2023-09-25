package com.bancodedados2.academia.ui;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.services.AlunoService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static AlunoService alunoService;

    public Menu(AlunoService alunoService) {
        this.alunoService = alunoService;
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
                    menuAluno();
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

    private static void menuAluno() {
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
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    listarAlunos();
                    break;
                case 2:
                    cadastrarAluno();
                    break;
                case 3:
                    visualizarAluno();
                    break;
                case 4:
                    atualizarAluno();
                    break;
                case 5:
                    excluirAluno();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 6);
    }

    private static void listarAlunos() {
        List<Aluno> alunos = alunoService.findAll();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private static void cadastrarAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        // Obtenha outros dados do aluno conforme necessário
        Aluno aluno = new Aluno(cpf, nome, ...);
        alunoService.save(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void visualizarAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno aluno = alunoService.findById(cpf);
        System.out.println(aluno);

    }

    private static void atualizarAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF do aluno a ser atualizado: ");
        String cpf = scanner.nextLine();


        Aluno aluno = alunoService.findById(cpf);

        System.out.print("Digite o novo nome do aluno: ");
        String novoNome = scanner.nextLine();
        aluno.setNome(novoNome);

        // Atualize outros dados do aluno conforme necessário

        alunoService.update(cpf, aluno);
        System.out.println("Aluno atualizado com sucesso!");

    }

    private static void excluirAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF do aluno a ser excluído: ");
        String cpf = scanner.nextLine();


            alunoService.deleteById(cpf);
            System.out.println("Aluno excluído com sucesso!");

    }

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
