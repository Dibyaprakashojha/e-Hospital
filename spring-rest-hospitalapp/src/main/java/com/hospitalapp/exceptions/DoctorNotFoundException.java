package com.hospitalapp.exceptions;

/**
 * @author Dibya Prakash Ojha
 * @date : 19-May-22
 * @project : e-Hospital
 */
public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException() {
        super();
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
