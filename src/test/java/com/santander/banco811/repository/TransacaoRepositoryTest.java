package com.santander.banco811.repository;

import com.santander.banco811.model.Transacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

@DataJpaTest
@Profile("test")
class TransacaoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TransacaoRepository transacaoRepository;


    @Test
    public void validar_findAll_vazio_se_repository_em_branco() {
        var transacoes = transacaoRepository.findAll();

        Assertions.assertEquals(Arrays.asList(), transacoes);
    }

    @Test
    public void trazer_transacoes_find_all() {
        Transacao transacao = new Transacao();
        transacao.setValor(BigDecimal.valueOf(150));
        transacao.setTipoTransacao("DEPOSITO");
        transacao.setNumero(12345677);
        transacao.setAgencia(1231);

        Transacao transacao1 = new Transacao();
        transacao.setValor(BigDecimal.valueOf(5000));
        transacao.setTipoTransacao("PIX");
        transacao.setNumero(12345688);
        transacao.setAgencia(3122);

        entityManager.persist(transacao);
        entityManager.persist(transacao1);

        var transacoes = transacaoRepository.findAll();

        Assertions.assertEquals(Arrays.asList(transacao, transacao1), transacoes);
    }
}