package com.santander.banco811.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExtratoRequest {

    private BigDecimal valor;
    private String tipoMovimentacao;
    private String tipoTransacao;

}
