package com.senac.projetoIntegrador.senaccoin.response;

public class ErrorResponse {
    private String message;
    private String error;
    private String details;

    public ErrorResponse(String message, String error, String details) {
        this.message = message;
        this.error = error;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
