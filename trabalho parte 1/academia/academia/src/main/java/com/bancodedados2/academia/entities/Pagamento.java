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
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pagamento;

    private Date data_pagamento;

    private Double valor_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_plano")
    private Plano plano;


}


