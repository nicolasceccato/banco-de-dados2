package com.bancodedados2.academia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "planos")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlano;

    private String nomeDoPlano;

    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "plano")
    private List<Aluno> alunos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "plano")
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Plano(String nomeDoPlano, String descricao) {
        this.nomeDoPlano = nomeDoPlano;
        this.descricao = descricao;
    }


}


