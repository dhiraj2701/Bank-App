package com.Bank.app.exception;

import java.io.Serial;

public class NotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = 7992904489502842099L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
