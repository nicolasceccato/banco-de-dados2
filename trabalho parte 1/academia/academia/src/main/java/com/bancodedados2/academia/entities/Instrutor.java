package com.bancodedados2.academia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;


}
