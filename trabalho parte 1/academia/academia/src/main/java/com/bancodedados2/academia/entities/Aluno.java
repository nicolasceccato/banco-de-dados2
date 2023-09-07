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
@Table(name = "alunos")
public class Aluno {

    @Id
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    private String nome;

    private String email;

    private String telefone;

    private Date data_nasc;

    private String cep;

    private String rua;

    private String numero_casa;

    private String bairro;

    @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;

    @ManyToMany(mappedBy = "alunos")
    private List<Treino> treinos = new ArrayList<>();

    public Aluno(String cpf, String nome, String email, String telefone, Plano plano) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.plano = plano;
    }

}
