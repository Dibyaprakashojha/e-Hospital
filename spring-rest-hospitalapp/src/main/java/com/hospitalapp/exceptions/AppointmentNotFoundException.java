package com.hospitalapp.exceptions;

/**
 * @author Dibya Prakash Ojha
 * @date : 18-May-22
 * @project : e-Hospital
 */
public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException() {
        super();
    }

    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
