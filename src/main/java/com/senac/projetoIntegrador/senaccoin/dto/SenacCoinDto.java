package com.senac.projetoIntegrador.senaccoin.dto;

public class SenacCoinDto {
    private Long senacCoinId;
    private Long senacCoinSaldo;
    private int senacCoinStatus;
    private String userId;

    public Long getSenacCoinId() {
        return senacCoinId;
    }

    public void setSenacCoinId(Long senacCoinId) {
        this.senacCoinId = senacCoinId;
    }

    public Long getSenacCoinSaldo() {
        return senacCoinSaldo;
    }

    public void setSenacCoinSaldo(Long senacCoinSaldo) {
        this.senacCoinSaldo = senacCoinSaldo;
    }

    public int getSenacCoinStatus() {
        return senacCoinStatus;
    }

    public void setSenacCoinStatus(int senacCoinStatus) {
        this.senacCoinStatus = senacCoinStatus;
    }

    public String getUsuarioId() {
        return userId;
    }

    public void setUserId(String usuarioId) {
        this.userId = usuarioId;
    }

}
