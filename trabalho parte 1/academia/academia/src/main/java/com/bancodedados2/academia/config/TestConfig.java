package com.bancodedados2.academia.config;

import com.bancodedados2.academia.entities.*;
import com.bancodedados2.academia.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private InstrutorRepository instrutorRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PlanoRepository planoRepository;
    @Autowired
    private TreinoRepository treinoRepository;

    @Override
    public void run(String... args) throws Exception {

        Plano p1 = new Plano("Plano Silver", "Este é o Plano Silver com recursos básicos.");
        Plano p2 = new Plano("Plano Gold", "O Plano Gold oferece recursos avançados para assinantes.");
        Plano p3 = new Plano("Plano Premium", "Assine o Plano Premium para obter acesso total a todos os recursos.");
        Plano p4 = new Plano("Plano Familiar", "O Plano Familiar permite que até 5 membros da família compartilhem uma assinatura.");
        Plano p5 = new Plano("Plano Estudante", "Os estudantes podem aproveitar o Plano Estudante com desconto especial.");


        Aluno a1 = new Aluno("12312312312", "Joaquim Brasil", "joaquim@gmail.com", "47999887766", p1);
        Aluno a2 = new Aluno("45645645645", "Maria Silva", "maria@gmail.com", "47998887777", p1);
        Aluno a3 = new Aluno("78978978978", "Carlos Santos", "carlos@gmail.com", "47997776666", p2);
        Aluno a4 = new Aluno("10101010101", "Ana Oliveira", "ana@gmail.com", "47996665555", p3);
        Aluno a5 = new Aluno("11111111111", "Pedro Mendes", "pedro@gmail.com", "47995554444", p4);
//        Aluno a6 = new Aluno("12121212121", "Isabela Pereira", "isabela@gmail.com", "47994443333", p5);
//        Aluno a7 = new Aluno("13131313131", "Lucas Souza", "lucas@gmail.com", "47993332222", p1);
//        Aluno a8 = new Aluno("14141414141", "Fernanda Lima", "fernanda@gmail.com", "47992221111", p2);
//        Aluno a9 = new Aluno("15151515151", "Rafaela Alves", "rafaela@gmail.com", "47991110000", p3);
//        Aluno a10 = new Aluno("16161616161", "Gustavo Santos", "gustavo@gmail.com", "47990009999", p4);
//        Aluno a11 = new Aluno("17171717171", "Amanda Ferreira", "amanda@gmail.com", "47998887776", p5);


        Instrutor instrutor1 = new Instrutor("João Silva", "joao@gmail.com", "47998887777", "Personal Trainer", "Musculação");
        Instrutor instrutor2 = new Instrutor("Maria Santos", "maria@gmail.com", "47997776666", "Instrutor de Yoga", "Yoga e Alongamento");
        Instrutor instrutor3 = new Instrutor("Carlos Oliveira", "carlos@gmail.com", "47996665555", "Instrutor de Cardio", "Aeróbica e Corrida");
        Instrutor instrutor4 = new Instrutor("Ana Mendes", "ana@gmail.com", "47995554444", "Instrutor de Pilates", "Pilates e Flexibilidade");
        Instrutor instrutor5 = new Instrutor("Pedro Pereira", "pedro@gmail.com", "47994443333", "Instrutor de Artes Marciais", "Boxe e Jiu-Jitsu");


        Pagamento pagamento1 = new Pagamento(new Date(), 50.0, p1);
        Pagamento pagamento2 = new Pagamento(new Date(), 60.0, p2);
        Pagamento pagamento3 = new Pagamento(new Date(), 70.0, p3);
        Pagamento pagamento4 = new Pagamento(new Date(), 80.0, p4);
        Pagamento pagamento5 = new Pagamento(new Date(), 90.0, p5);
        Pagamento pagamento6 = new Pagamento(new Date(), 55.0, p1);
        Pagamento pagamento7 = new Pagamento(new Date(), 65.0, p2);
        Pagamento pagamento8 = new Pagamento(new Date(), 75.0, p3);
        Pagamento pagamento9 = new Pagamento(new Date(), 85.0, p4);
        Pagamento pagamento10 = new Pagamento(new Date(), 95.0, p5);
        Pagamento pagamento11 = new Pagamento(new Date(), 52.0, p1);
        Pagamento pagamento12 = new Pagamento(new Date(), 62.0, p2);
        Pagamento pagamento13 = new Pagamento(new Date(), 72.0, p3);
        Pagamento pagamento14 = new Pagamento(new Date(), 82.0, p4);
        Pagamento pagamento15 = new Pagamento(new Date(), 92.0, p5);
        Pagamento pagamento16 = new Pagamento(new Date(), 58.0, p1);
        Pagamento pagamento17 = new Pagamento(new Date(), 68.0, p2);
        Pagamento pagamento18 = new Pagamento(new Date(), 78.0, p3);
        Pagamento pagamento19 = new Pagamento(new Date(), 88.0, p4);
        Pagamento pagamento20 = new Pagamento(new Date(), 98.0, p5);


        Treino treino1 = new Treino("Treino de Musculação", "Treino focado em fortalecimento muscular", 60, new Date());
        Treino treino2 = new Treino("Treino de Cardio", "Treino de alta intensidade para queimar calorias", 45, new Date());
        Treino treino3 = new Treino("Treino de Yoga", "Treino de relaxamento e flexibilidade", 90, new Date());
        Treino treino4 = new Treino("Treino de CrossFit", "Treino funcional para ganho de resistência e força", 75, new Date());
        Treino treino5 = new Treino("Treino de Pilates", "Treino focado em flexibilidade e equilíbrio", 60, new Date());

        List<Treino> treinos = new ArrayList<>();
        treinos.add(treino1);
        treinos.add(treino2);

//        a1.setTreinos(treinos);
//        a2.setTreinos(Arrays.asList(treino3, treino4));
//        a3.setTreinos(Arrays.asList(treino2, treino3));
//        a4.setTreinos(Arrays.asList(treino1, treino4));
//        a5.setTreinos(List.of(treino5));
        a1.addTreinos(Arrays.asList(treino1, treino1));
        a2.addTreinos(Arrays.asList(treino2, treino3));
        a3.addTreinos(Arrays.asList(treino2, treino3));
        a4.addTreinos(Arrays.asList(treino1, treino4));
        a5.addTreinos(List.of(treino5));

        treino1.addInstrutores(Arrays.asList(instrutor1, instrutor2, instrutor3, instrutor4, instrutor5));
        treino2.addInstrutores(Arrays.asList(instrutor1, instrutor2, instrutor3, instrutor4, instrutor5));
        treino3.addInstrutores(List.of(instrutor2));
        treino4.addInstrutores(List.of(instrutor3));
        treino5.addInstrutores(List.of(instrutor5));

        planoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2, pagamento3, pagamento4, pagamento5, pagamento6, pagamento7, pagamento8, pagamento9, pagamento10, pagamento11, pagamento12, pagamento13, pagamento14, pagamento15, pagamento16, pagamento17, pagamento18, pagamento19, pagamento20));
        instrutorRepository.saveAll(Arrays.asList(instrutor1, instrutor2, instrutor3, instrutor4, instrutor5));
        treinoRepository.saveAll(Arrays.asList(treino1, treino2, treino3, treino4, treino5));
        treinoRepository.saveAll(treinos);
        alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));


    }
}
