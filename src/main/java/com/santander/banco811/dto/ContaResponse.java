package com.santander.banco811.dto;

import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class ContaResponse {

    private UsuarioResponse usuario;
    private Integer id;
    private Integer numero;
    private Integer agencia;
    private TipoConta tipoConta;
    private BigDecimal saldo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public ContaResponse(Conta conta){
        this.usuario = new UsuarioResponse(conta.getUsuario());
        this.id = conta.getId();
        this.numero = conta.getNumero();
        this.agencia = conta.getAgencia();
        this.tipoConta = conta.getTipoConta();
        this.saldo = conta.getSaldo();
        this.dataCriacao = conta.getDataCriacao();
        this.dataAtualizacao = conta.getDataAtualizacao();
    }

    public static List<ContaResponse> toResponse(List<Conta> contas){
        return contas.stream().map(ContaResponse::new).collect(Collectors.toList());
    }
}
