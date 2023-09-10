package com.bancodedados2.academia.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    private Date dataDoPagamento;

    private Double valorDoPagamento;

    @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;

    public Pagamento(Date dataDoPagamento, Double valorDoPagamento, Plano plano) {
        this.dataDoPagamento = dataDoPagamento;
        this.valorDoPagamento = valorDoPagamento;
        this.plano = plano;
    }

}


