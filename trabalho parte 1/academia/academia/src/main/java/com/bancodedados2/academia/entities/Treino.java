package com.bancodedados2.academia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "treinos")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_treino;

    private String nome_treino;

    private String descricao;

    private Date dataDoTreino;

    private int duracao_min;

    @ManyToMany
    @JoinTable(name = "instrutores_treinos", joinColumns = @JoinColumn(name = "id_treino"), inverseJoinColumns = @JoinColumn(name = "matricula"))
    private List<Instrutor> instrutores = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "alunos_treinos", joinColumns = @JoinColumn(name = "id_treino"), inverseJoinColumns = @JoinColumn(name = "cpf"))
    private List<Aluno> alunos = new ArrayList<>();

    public Treino(String nome_treino, String descricao, int duracao_min, Date dataDoTreino) {
        this.nome_treino = nome_treino;
        this.descricao = descricao;
        this.duracao_min = duracao_min;
        this.dataDoTreino = dataDoTreino;
    }
}


