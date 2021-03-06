package com.santander.banco811.service.impl;

import com.santander.banco811.dto.ContaRequest;
import com.santander.banco811.dto.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.Enum.TipoConta;
import com.santander.banco811.projection.ContaView;
import com.santander.banco811.repository.ContaRepository;
import com.santander.banco811.service.ContaService;
import com.santander.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public Page<Conta> getAll(Integer numero, int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.DESC,
                "numero"
        );

        if (numero != null) {
            return contaRepository.findByNumero(numero, pageRequest);
        } else {
            return contaRepository.findAll(pageRequest);
        }
    }


    @Override
    public ContaResponse create(Integer usuarioId, ContaRequest contaRequest) {
        var usuario = usuarioService.getById(usuarioId);
        Conta conta = new Conta();
        conta.setUsuario(usuario);
        conta.setNumero(contaRequest.getNumero());
        conta.setAgencia(contaRequest.getAgencia());
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setSaldo(contaRequest.getSaldo());
        Conta savedConta = contaRepository.save(conta);

        return new ContaResponse(savedConta);
    }

    @Override
    public Conta update(ContaRequest contaRequest, Integer id) {
        Conta conta = contaRepository.findById(id).orElseThrow();

        conta.setNumero(contaRequest.getNumero());
        conta.setAgencia(contaRequest.getAgencia());
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setSaldo(contaRequest.getSaldo());

        return contaRepository.save(conta);
    }

    @Override
    public void delete(Integer id) {
        var conta = contaRepository.findById(id).orElseThrow();

        contaRepository.delete(conta);
    }

    @Override
    public List<ContaView> getAllViewByTipoConta(TipoConta tipoConta) {
        return contaRepository.findAllByTipoConta(tipoConta);
    }

}

