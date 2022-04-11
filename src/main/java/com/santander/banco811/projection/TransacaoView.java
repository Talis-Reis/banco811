package com.santander.banco811.projection;

public interface TransacaoView {

    String getTipoTransacao();
    Integer getValor();
    ContaView getContaTransacao();

}
