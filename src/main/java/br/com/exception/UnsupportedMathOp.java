package br.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOp extends RuntimeException{

    public UnsupportedMathOp(String exception){
        super(exception);
    }
}
