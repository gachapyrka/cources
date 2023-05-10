package com.example.cources.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id, String entityName) {
        super("Could not find" + entityName + "with id = " + id);
    }
}
