package com.santander.banco811.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class UsuarioRequest {

    @NotNull @NotEmpty @Size(min = 11)
    private String cpf;

    @NotNull @NotEmpty @Size(min = 3)
    private String nome;

    @NotNull @NotEmpty @Size(min = 6)
    private String senha;
}
