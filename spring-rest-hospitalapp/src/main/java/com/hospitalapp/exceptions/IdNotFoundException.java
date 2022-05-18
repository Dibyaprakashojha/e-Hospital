package com.hospitalapp.exceptions;

/**
 * @author Dibya Prakash Ojha
 * @date : 18-May-22
 * @project : e-Hospital
 */
public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException() {
        super();
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
