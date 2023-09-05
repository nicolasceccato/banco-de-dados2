package com.bancodedados2.academia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

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


}
