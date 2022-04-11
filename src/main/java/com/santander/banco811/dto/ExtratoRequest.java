package com.santander.banco811.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ExtratoRequest {

    @NotNull @NotEmpty
    private BigDecimal valor;

    @NotNull @NotEmpty
    private String tipoMovimentacao;

    @NotNull @NotEmpty
    private String tipoTransacao;

}
