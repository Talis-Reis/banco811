package com.santander.banco811.repository;

import com.santander.banco811.model.Transacao;
import com.santander.banco811.projection.TransacaoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<TransacaoView> findAllByNumero(Integer numero);

    @Query("select t from Transacao t " +
            "where t.numero = :numero and t.tipoTransacao = :tipoTransacao")
    List<TransacaoView> findAllTransacaoByNumeroAndDatacriacao(
            @Param("numero") Integer numero,
            @Param("tipoTransacao") String tipoTransacao
    );
}

