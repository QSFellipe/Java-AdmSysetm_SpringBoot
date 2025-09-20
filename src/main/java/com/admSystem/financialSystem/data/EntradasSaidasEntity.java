package com.admSystem.financialSystem.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "entradas_saidas")
public class EntradasSaidasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    private String categoria;
    
    private String descricao;

    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private LocalDate dataEntrada;

    @Column(name = "data_saida")
    @Temporal(TemporalType.DATE)
    private LocalDate dataSaida;

    @Column(name = "valor_entrada")
    private Double valorEntrada;

    @Column(name = "valor_saida")
    private Double valorSaida;

    @Column(name = "metodo_pagamento")
    private String metodoPagamento;

}
