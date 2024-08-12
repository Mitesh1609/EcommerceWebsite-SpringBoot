package com.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException{
    String fieldName;
    String resourceName;
    String field;
    Long id;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String fieldName, String resourceName, String field) {
        super(String.format("%s not found with %s : %s",resourceName,field,fieldName));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.field = field;
    }

    public ResourceNotFoundException(String resourceName, String field, Long id) {
        super(String.format("%s not found with %s : %d",resourceName,field,id));
        this.resourceName = resourceName;
        this.field = field;
        this.id = id;
    }
}
