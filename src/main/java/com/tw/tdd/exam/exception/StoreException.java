package com.tw.tdd.exam.exception;

/**
 * @author Gavin
 */
public class StoreException extends Exception {
    private static final long serialVersionUID = 849742717212015508L;
    
    public StoreException(String message) {
        super(message);
    }
}
