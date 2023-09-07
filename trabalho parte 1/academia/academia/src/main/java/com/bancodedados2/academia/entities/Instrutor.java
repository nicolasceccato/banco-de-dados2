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
@Table(name = "instrutores")
public class Instrutor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;

    private String nome;

    private String email;

    private String telefone;

    private Date data_nasc;

    private String cep;

    private String rua;

    private String numero_casa;

    private String bairro;

    private String cargo;

    private String especialidade;

    @ManyToMany(mappedBy = "instrutores")
    private List<Treino> treinos = new ArrayList<>();

    public Instrutor(String nome, String email, String telefone, String cargo, String especialidade) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.especialidade = especialidade;
    }

}
