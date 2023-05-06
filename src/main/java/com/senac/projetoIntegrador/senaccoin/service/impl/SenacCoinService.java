package com.senac.projetoIntegrador.senaccoin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoIntegrador.senaccoin.dto.SenacCoinDto;
import com.senac.projetoIntegrador.senaccoin.dto.SenacCoinMovimentacaoDto;
import com.senac.projetoIntegrador.senaccoin.exceptions.UserNotFoundException;
import com.senac.projetoIntegrador.senaccoin.repository.ISenacCoinRepository;
import com.senac.projetoIntegrador.senaccoin.request.NewTransactionRequest;
import com.senac.projetoIntegrador.senaccoin.service.ISenacCoinService;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Service
public class SenacCoinService implements ISenacCoinService {

    @Autowired
    ISenacCoinRepository repository;


    public void addNewTRansaction(NewTransactionRequest transaction){

        SenacCoinMovimentacaoDto senacCoinMovimentacaoDto = new SenacCoinMovimentacaoDto();

        Timestamp now = new Timestamp(System.currentTimeMillis());
        senacCoinMovimentacaoDto.setSenacCoinMovimentacaoDate(now);
        senacCoinMovimentacaoDto.setSenacCoinMovimentacaoObservacao(transaction.getObservation());
        senacCoinMovimentacaoDto.setSenacCoinMovimentacaoValor(transaction.getAmount());
        senacCoinMovimentacaoDto.setSenacCoinMovimentacaoStatus(transaction.getMovementStatus());
        senacCoinMovimentacaoDto.setUsuarioId(transaction.getUserId());
        
        CompletableFuture<Integer> addMovement = repository.addMovement(senacCoinMovimentacaoDto);
        CompletableFuture<Integer> updateBalance = repository.updateBalance(senacCoinMovimentacaoDto);

        CompletableFuture.allOf(addMovement, updateBalance).join();
        
    }

    public List<SenacCoinMovimentacaoDto> getSenacCoinStatement(String userId){
        return repository.getMovimentsByUserId(userId);
    }

    public Long getUserBalance(String userId) throws UserNotFoundException{
        return repository.getBalanceByUserId(userId);

    }
}
