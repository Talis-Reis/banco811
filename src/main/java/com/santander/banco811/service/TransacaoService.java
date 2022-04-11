package com.santander.banco811.service;

import com.santander.banco811.model.Transacao;
import com.santander.banco811.projection.TransacaoView;

import java.util.List;

public interface TransacaoService {
    List<Transacao> getAll();
    List<TransacaoView> getAllTransacaoViewByNumero(Integer numero);
    List<TransacaoView> getAllTransacaoViewByNumeroAndDatacriacao(Integer numero, String tipoTransacao);
}
