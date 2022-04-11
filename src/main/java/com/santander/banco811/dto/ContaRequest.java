package com.santander.banco811.dto;

import com.santander.banco811.model.Enum.TipoConta;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class ContaRequest {

    @NotNull @NotEmpty @Size(min = 3)
    private Integer numero;

    @NotNull @NotEmpty @Size(min  = 2)
    private Integer agencia;

    @NotNull @NotEmpty @Size(min = 2, max = 2)
    private TipoConta tipoConta;

    @NotNull @NotEmpty
    private BigDecimal saldo;

}
