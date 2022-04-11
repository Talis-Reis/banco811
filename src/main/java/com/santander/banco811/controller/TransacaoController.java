package com.santander.banco811.controller;

import com.santander.banco811.model.Transacao;
import com.santander.banco811.projection.TransacaoView;
import com.santander.banco811.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @GetMapping("/view")
    public List<TransacaoView> getAllTransacaoViewByNumero(@RequestParam Integer numero){
        return transacaoService.getAllTransacaoViewByNumero(numero);
    }

    @GetMapping("/transacaoAndTipoMovimentacao")
    public List<TransacaoView> getAllTransacaoViewByNumeroAndDatacriacao(@RequestParam Integer numero, @RequestParam String tipoTransacao){
        return transacaoService.getAllTransacaoViewByNumeroAndDatacriacao(numero,tipoTransacao);
    }

    @GetMapping
    public List<Transacao> getAllTransacoes(){
        return transacaoService.getAll();
    }

}
