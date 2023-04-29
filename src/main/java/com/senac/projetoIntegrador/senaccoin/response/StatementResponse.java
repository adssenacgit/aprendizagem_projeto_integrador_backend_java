package com.senac.projetoIntegrador.senaccoin.response;

import java.sql.Timestamp;
import com.senac.projetoIntegrador.senaccoin.dto.enums.MovimentStatus;

public class StatementResponse {
    private Timestamp date;
    private String observation;
    private Long transactionAmount;
    private MovimentStatus status;

    

    public StatementResponse(Timestamp timestamp, String observation, Long transactionAmount, MovimentStatus status) {
        this.date = timestamp;
        this.observation = observation;
        this.transactionAmount = transactionAmount;
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public MovimentStatus getStatus() {
        return status;
    }

    public void setStatus(MovimentStatus status) {
        this.status = status;
    }

}
