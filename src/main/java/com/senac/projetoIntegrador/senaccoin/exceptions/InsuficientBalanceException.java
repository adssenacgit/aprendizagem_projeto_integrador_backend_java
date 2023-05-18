package com.senac.projetoIntegrador.senaccoin.exceptions;

public class InsuficientBalanceException extends Exception{
    public InsuficientBalanceException(String errorMsg){
        super(errorMsg);
    }
}
