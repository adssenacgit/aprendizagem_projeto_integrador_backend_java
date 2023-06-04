package com.senac.projetoIntegrador.senaccoin.service;

import java.util.List;

import com.senac.projetoIntegrador.senaccoin.dto.SenacCoinMovimentacaoDto;
import com.senac.projetoIntegrador.senaccoin.exceptions.InsuficientBalanceException;
import com.senac.projetoIntegrador.senaccoin.exceptions.UserNotFoundException;
import com.senac.projetoIntegrador.senaccoin.request.NewTransactionRequest;

public interface ISenacCoinService {
    public void addNewTRansaction(NewTransactionRequest transaction) throws UserNotFoundException, InsuficientBalanceException;
    public List<SenacCoinMovimentacaoDto> getSenacCoinStatement(String userId);
    public Long getUserBalance(String userId) throws UserNotFoundException;
    
}
