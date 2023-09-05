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

    private Date data_treino;

    private Double valor_treino;

    @ManyToMany
    @JoinTable(name = "instrutores_treinos", joinColumns = @JoinColumn(name = "id_treino"), inverseJoinColumns = @JoinColumn(name = "matricula"))
    private List<Instrutor> instrutores = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "alunos_treinos", joinColumns = @JoinColumn(name = "id_treino"), inverseJoinColumns = @JoinColumn(name = "cpf"))
    private List<Aluno> alunos = new ArrayList<>();

}


