package com.bancodedados2.academia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    @Column(name = "data_nasc", nullable = false)
    private Date data_nasc;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "rua", length = 255, nullable = false)
    private String rua;

    @Column(name = "numero_casa", length = 10, nullable = false)
    private String numero_casa;

    @Column(name = "bairro", length = 255, nullable = false)
    private String bairro;


}
