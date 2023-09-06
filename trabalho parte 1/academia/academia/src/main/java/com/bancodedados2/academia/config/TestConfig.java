package com.bancodedados2.academia.config;

import com.bancodedados2.academia.entities.Aluno;
import com.bancodedados2.academia.entities.Plano;
import com.bancodedados2.academia.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@Configuration
@Profile("test")
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

        Plano p1 = new Plano(null, "Plano Silver", "Este é o Plano Silver com recursos básicos.", null, null );
        Plano p2 = new Plano(null, "Plano Gold", "O Plano Gold oferece recursos avançados para assinantes.", null, null );
        Plano p3 = new Plano(null, "Plano Premium", "Assine o Plano Premium para obter acesso total a todos os recursos.", null, null );
        Plano p4 = new Plano(null, "Plano Familiar", "O Plano Familiar permite que até 5 membros da família compartilhem uma assinatura.", null, null );
        Plano p5 = new Plano(null, "Plano Estudante", "Os estudantes podem aproveitar o Plano Estudante com desconto especial.", null, null );


        Aluno a1 = new Aluno("12312312312", "Joaquim Brasil", "joaquim@gmail.com", "47999887766", new Date(79, 9, 25), "89201100", "Rua XV de Novembro", "123", "Centro", p1, null);
    }
}
