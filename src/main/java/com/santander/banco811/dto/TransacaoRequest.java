package com.santander.banco811.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class TransacaoRequest {

    @NotNull @NotEmpty
    private BigDecimal valor;

    @NotNull @NotEmpty
    private String tipoTransacao;

    @NotNull @NotEmpty @Size(min  = 2)
    private Integer numero;

    @NotNull @NotEmpty @Size(min  = 2)
    private Integer agencia;

}
