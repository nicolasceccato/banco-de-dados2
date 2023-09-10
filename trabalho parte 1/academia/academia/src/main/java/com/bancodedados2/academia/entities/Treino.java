package com.bancodedados2.academia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "treinos")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTreino;

    private String nomeDoTreino;

    private String descricao;

    private Date dataDoTreino;

    private int duracaoEmminutos;

    public Treino() {

    }

    public Treino(String nomeDoTreino, String descricao, int duracaoEmminutos, Date dataDoTreino) {
        this.nomeDoTreino = nomeDoTreino;
        this.descricao = descricao;
        this.duracaoEmminutos = duracaoEmminutos;
        this.dataDoTreino = dataDoTreino;
    }


    @ManyToMany
    @JoinTable(name = "instrutores_treinos", joinColumns = @JoinColumn(name = "idTreino"), inverseJoinColumns = @JoinColumn(name = "matricula"))
    private List<Instrutor> instrutores = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "treinos")
    private List<Aluno> alunos = new ArrayList<>();


    public Long getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(Long idTreino) {
        this.idTreino = idTreino;
    }

    public String getNomeDoTreino() {
        return nomeDoTreino;
    }

    public void setNomeDoTreino(String nomeDoTreino) {
        this.nomeDoTreino = nomeDoTreino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDoTreino() {
        return dataDoTreino;
    }

    public void setDataDoTreino(Date dataDoTreino) {
        this.dataDoTreino = dataDoTreino;
    }

    public int getDuracaoEmminutos() {
        return duracaoEmminutos;
    }

    public void setDuracaoEmminutos(int duracaoEmminutos) {
        this.duracaoEmminutos = duracaoEmminutos;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void addInstrutores(List<Instrutor> novosInstrutores) {
        for (Instrutor instrutor : novosInstrutores) {
            instrutores.add(instrutor);
        }
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> novosAlunos) {
        for (Aluno aluno : novosAlunos) {
            alunos.add(aluno);
        }
    }
}


