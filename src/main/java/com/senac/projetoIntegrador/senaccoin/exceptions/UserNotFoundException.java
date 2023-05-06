package com.senac.projetoIntegrador.senaccoin.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
