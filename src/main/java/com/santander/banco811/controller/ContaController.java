package com.santander.banco811.controller;

import com.santander.banco811.dto.ContaRequest;
import com.santander.banco811.dto.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.projection.ContaView;
import com.santander.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping("/view")
    public List<ContaView> getAllContaViewByTipoConta(
            @RequestParam TipoConta tipoConta
    ){
        return contaService.getAllViewByTipoConta(tipoConta);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ContaResponse> create(
            @PathVariable("id") Integer usuarioId,
            @RequestBody ContaRequest contaRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        ContaResponse conta =  contaService.create(usuarioId, contaRequest);
        URI uri = uriComponentsBuilder .path("/conta/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).body(conta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> update(
            @PathVariable Integer id,
            @RequestBody ContaRequest contaRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Conta conta = contaService.update(contaRequest, id);
        URI uri = uriComponentsBuilder.path("/conta/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).body(conta);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        contaService.delete(id);
        return "Conta deletada com sucesso!";
    }
}
