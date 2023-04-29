package com.senac.projetoIntegrador.senaccoin.dto;

import java.sql.Timestamp;

import com.senac.projetoIntegrador.senaccoin.dto.enums.MovimentStatus;

public class SenacCoinMovimentacaoDto {
    private Long senacCoinMovimentacaoId;
    private Timestamp senacCoinMovimentacaoDate;
    private String senacCoinMovimentacaoObservacao;
    private Long senacCoinMovimentacaoValor;
    private MovimentStatus senacCoinMovimentacaoStatus;
    private String usuarioId;

    public Long getSenacCoinMovimentacaoId() {
        return senacCoinMovimentacaoId;
    }

    public void setSenacCoinMovimentacaoId(Long senacCoinMovimentacaoId) {
        this.senacCoinMovimentacaoId = senacCoinMovimentacaoId;
    }

    public Timestamp getSenacCoinMovimentacaoDate() {
        return senacCoinMovimentacaoDate;
    }

    public void setSenacCoinMovimentacaoDate(Timestamp senacCoinMovimentacaoDate) {
        this.senacCoinMovimentacaoDate = senacCoinMovimentacaoDate;
    }

    public String getSenacCoinMovimentacaoObservacao() {
        return senacCoinMovimentacaoObservacao;
    }

    public void setSenacCoinMovimentacaoObservacao(String senacCoinMovimentacaoObservacao) {
        this.senacCoinMovimentacaoObservacao = senacCoinMovimentacaoObservacao;
    }

    public Long getSenacCoinMovimentacaoValor() {
        return senacCoinMovimentacaoValor;
    }

    public void setSenacCoinMovimentacaoValor(Long senacCoinMovimentacaoValor) {
        this.senacCoinMovimentacaoValor = senacCoinMovimentacaoValor;
    }

    public MovimentStatus getSenacCoinMovimentacaoStatus() {
        return senacCoinMovimentacaoStatus;
    }

    public void setSenacCoinMovimentacaoStatus(MovimentStatus senacCoinMovimentacaoStatus) {
        this.senacCoinMovimentacaoStatus = senacCoinMovimentacaoStatus;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

}
