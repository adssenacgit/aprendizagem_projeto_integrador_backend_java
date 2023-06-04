package com.senac.projetoIntegrador.senaccoin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoIntegrador.senaccoin.dto.SenacCoinMovimentacaoDto;
import com.senac.projetoIntegrador.senaccoin.exceptions.InsuficientBalanceException;
import com.senac.projetoIntegrador.senaccoin.exceptions.UserNotFoundException;
import com.senac.projetoIntegrador.senaccoin.repository.ISenacCoinRepository;
import com.senac.projetoIntegrador.senaccoin.request.NewTransactionRequest;
import com.senac.projetoIntegrador.senaccoin.service.ISenacCoinService;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class SenacCoinService implements ISenacCoinService {

    @Autowired
    ISenacCoinRepository repository;


    public void addNewTRansaction(NewTransactionRequest transaction) throws UserNotFoundException, InsuficientBalanceException{
        
        SenacCoinMovimentacaoDto senacCoinMovimentacaoDto = new SenacCoinMovimentacaoDto(
            new Timestamp(System.currentTimeMillis()),
            transaction.getObservation(),
            transaction.getAmount(),
            transaction.getMovementStatus(),
            transaction.getUserId()
        );

        if (transaction.getMovementStatus().name().equals("DEBT")){
            Long userBalance = repository.getBalanceByUserId(transaction.getUserId());

            if (userBalance - transaction.getAmount() < 0 ){
                throw new InsuficientBalanceException(String.format("User with id %s doest have enough money to purchase %s", transaction.getUserId(), transaction.getObservation()));
            }
        }
        
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
