package com.test.inditex.infrastructure.inbound.exception;

public class NotFoundException extends Exception{
    public NotFoundException() {
        super("Not found.");
    }
}

