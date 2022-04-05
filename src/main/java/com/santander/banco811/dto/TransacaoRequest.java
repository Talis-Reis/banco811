package com.santander.banco811.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransacaoRequest {

    private BigDecimal valor;
    private String tipoTransacao;
    private Integer numero;
    private Integer agencia;

}
