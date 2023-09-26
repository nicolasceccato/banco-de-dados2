package com.bancodedados2.academia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    private String nome;

    private String email;

    private String telefone;

    private Date dataDeNascimento;

    private String cep;

    private String rua;

    private String numeroDaCasa;

    private String bairro;

    @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;

    @ManyToMany
    @JoinTable(name = "alunos_treinos", joinColumns = @JoinColumn(name = "cpf"), inverseJoinColumns = @JoinColumn(name = "idTreino"))
    private List<Treino> treinos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Aluno() {

    }

    public Aluno(String cpf, String nome, String email, String telefone, Plano plano) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.plano = plano;
    }
    public Aluno(String cpf, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void addTreinos(List<Treino> novosTreinos) {
        for (Treino treino : novosTreinos) {
            treinos.add(treino);
        }
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

}
