package com.WebSer.institute.Layers.Controller;

import com.WebSer.institute.Layers.Exeptions.ApplicationException;
import com.WebSer.institute.Layers.Exeptions.DataNotFoundException;
import com.WebSer.institute.Layers.Exeptions.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleDataNotFoundException(DataNotFoundException e){
        return new ErrorMessage(e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidInputException(InvalidInputException e){
        return new ErrorMessage(e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleApplicationException(ApplicationException e){
        return new ErrorMessage(e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException(Exception e){
        return new ErrorMessage(e.getMessage());
    }


}
