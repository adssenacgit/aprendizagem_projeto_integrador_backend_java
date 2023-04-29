package com.senac.projetoIntegrador.senaccoin.response;

import java.util.List;

public class RetrieveStatementResponse {
    List<StatementResponse> transactions;

    public List<StatementResponse> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<StatementResponse> transactions) {
        this.transactions = transactions;
    }

    
}
