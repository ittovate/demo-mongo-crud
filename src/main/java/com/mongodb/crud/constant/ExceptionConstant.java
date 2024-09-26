package com.mongodb.crud.constant;

public final class ExceptionConstant {
    public static final String RESOURCE_FIELD_CANNOT_BE_NULL_OR_EMPTY = "%s %s cannot be null or empty!";
    public static final String RESOURCE_ALREADY_EXIST = "%s with %s `%s` already exists!";
    public static final String RESOURCE_NOT_FOUND = "%s with %s '%s' is not found!";
    public static final String RESOURCE_IS_NULL = "%s is null!";

    private ExceptionConstant() {
    }
}
