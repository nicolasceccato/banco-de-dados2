package com.bancodedados2.academia.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    private Date dataDoPagamento;

    private Double valorDoPagamento;

    @ManyToOne
    @JoinColumn(name = "cpf")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;

    public Pagamento() {

    }

    public Pagamento(Date dataDoPagamento, Double valorDoPagamento, Plano plano, Aluno aluno) {
        this.dataDoPagamento = dataDoPagamento;
        this.valorDoPagamento = valorDoPagamento;
        this.plano = plano;
        this.aluno = aluno;
    }

    public Pagamento(Date dataDoPagamento, Double valorDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
        this.valorDoPagamento = valorDoPagamento;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Date getDataDoPagamento() {
        return dataDoPagamento;
    }

    public void setDataDoPagamento(Date dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }

    public Double getValorDoPagamento() {
        return valorDoPagamento;
    }

    public void setValorDoPagamento(Double valorDoPagamento) {
        this.valorDoPagamento = valorDoPagamento;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}


