package com.mongodb.crud.util;

import com.mongodb.crud.exception.DuplicateResourceException;
import com.mongodb.crud.exception.NullResourceException;
import com.mongodb.crud.exception.ResourceNotFoundException;

import static com.mongodb.crud.constant.ExceptionConstant.RESOURCE_ALREADY_EXIST;
import static com.mongodb.crud.constant.ExceptionConstant.RESOURCE_FIELD_CANNOT_BE_NULL_OR_EMPTY;
import static com.mongodb.crud.constant.ExceptionConstant.RESOURCE_IS_NULL;
import static com.mongodb.crud.constant.ExceptionConstant.RESOURCE_NOT_FOUND;
import static java.lang.String.format;

public final class ServiceUtil {
    private ServiceUtil() {
    }

    /**
     * Validate resource not null.
     *
     * @param object       the resource
     * @param resourceName the resource name
     */
    public static void validateResourceNotNull(Object object, String resourceName) {
        if (object == null) {
            throw new NullResourceException(
                    format(RESOURCE_IS_NULL, resourceName)
            );
        }
    }

    /**
     * Validate string not null or empty.
     *
     * @param string   the string
     * @param resource the resource
     * @param field    the field
     */
    public static void validateStringNotNullOrEmpty(String string, String resource, String field) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    format(RESOURCE_FIELD_CANNOT_BE_NULL_OR_EMPTY, resource, field)
            );
        }
    }

    /**
     * Validate resource not duplicated.
     *
     * @param object   the resource
     * @param resource the resource name
     * @param field    the field
     * @param value    the value of field
     */
    public static void validateResourceNotDuplicated(Object object, String resource, String field, String value) {
        if (object != null) {
            throw new DuplicateResourceException(
                    format(RESOURCE_ALREADY_EXIST, resource, field, value)
            );
        }
    }

    /**
     * Validate resource exists.
     *
     * @param object   the resource
     * @param resource the resource name
     * @param field    the field
     * @param value    the value
     */
    public static void validateResourceExists(Object object, String resource, String field, String value) {
        if (object == null) {
            throw new ResourceNotFoundException(
                    format(RESOURCE_NOT_FOUND, resource, field, value)
            );
        }
    }
}
