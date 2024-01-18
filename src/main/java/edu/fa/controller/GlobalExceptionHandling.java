package edu.fa.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author HieuLQ18
 * birthDay 2001/07/16
 * at 1/8/2024
 */
@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(Exception.class)
    private String processGenericException(Model model, Exception ex) {
        model.addAttribute("exception", ex);
        return "error/generic_error";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    private String processNotFounfException(Model model, Exception ex) {
        model.addAttribute("exception", ex);
        return "error/404";
    }

}