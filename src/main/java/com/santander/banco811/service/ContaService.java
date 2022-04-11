package com.santander.banco811.service;

import com.santander.banco811.dto.ContaRequest;
import com.santander.banco811.dto.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.Enum.TipoConta;
import com.santander.banco811.projection.ContaView;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContaService {
    Page<Conta> getAll(Integer numero, int page, int size);
    ContaResponse create(Integer usuarioId, ContaRequest contaRequest);
    Conta update(ContaRequest contaRequest, Integer id);
    void delete(Integer id);
    List<ContaView> getAllViewByTipoConta(TipoConta tipoConta);
}
