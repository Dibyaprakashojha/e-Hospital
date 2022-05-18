package com.hospitalapp.exceptions;

/**
 * @author Dibya Prakash Ojha
 * @date : 19-May-22
 * @project : e-Hospital
 */
public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException() {
        super();
    }

    public PatientNotFoundException(String message) {
        super(message);
    }
}
