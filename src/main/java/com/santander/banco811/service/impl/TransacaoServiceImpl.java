package com.santander.banco811.service.impl;

import com.santander.banco811.model.Transacao;
import com.santander.banco811.projection.TransacaoView;
import com.santander.banco811.repository.TransacaoRepository;
import com.santander.banco811.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Override
    public List<Transacao> getAll() {
        return transacaoRepository.findAll();
    }

    @Override
    public List<TransacaoView> getAllTransacaoViewByNumero(Integer numero) {
        return transacaoRepository.findAllByNumero(numero);
    }

    @Override
    public List<TransacaoView> getAllTransacaoViewByNumeroAndDatacriacao(Integer numero, String tipoTransacao) {
        System.out.println(numero);
        System.out.println(tipoTransacao);
        return transacaoRepository.findAllTransacaoByNumeroAndDatacriacao(numero,tipoTransacao);
    }

}
