package com.santander.banco811.model;

import com.santander.banco811.dto.ExtratoRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "extrato")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Extrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "tipo_movimentacao")
    private String tipoMovimentacao;

    @Column(name = "tipo_transacao")
    private String tipoTransacao;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta contaExtrato;


    public Extrato(Conta conta, ExtratoRequest extratoRequest) {
        this.contaExtrato = conta;
        this.valor = extratoRequest.getValor();
        this.tipoMovimentacao = extratoRequest.getTipoMovimentacao();
        this.tipoTransacao = extratoRequest.getTipoTransacao();
    }

}
