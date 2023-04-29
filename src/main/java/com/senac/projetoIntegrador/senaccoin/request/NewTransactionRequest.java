package com.senac.projetoIntegrador.senaccoin.request;

import com.senac.projetoIntegrador.senaccoin.dto.enums.MovimentStatus;

public class NewTransactionRequest {

    private Long amount;
    private String userId;
    private String observation;
    private int senacCoinStatus;
    private MovimentStatus movementStatus;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getSenacCoinStatus() {
        return senacCoinStatus;
    }

    public void setSenacCoinStatus(int senacCoinStatus) {
        this.senacCoinStatus = senacCoinStatus;
    }

    public MovimentStatus getMovementStatus() {
        return movementStatus;
    }

    public void setMovementStatus(MovimentStatus movementStatus) {
        this.movementStatus = movementStatus;
    }

}
