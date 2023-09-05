package com.bancodedados2.academia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "planos")
public class Plano implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @Column(name = "id_plano", length = 11, nullable = false)
    private String id_plano;

    @Column(name = "nome_plano", length = 50, nullable = false)
    private String nome_plano;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "plano")
    private List<Aluno> alunos = new ArrayList<>();


}


