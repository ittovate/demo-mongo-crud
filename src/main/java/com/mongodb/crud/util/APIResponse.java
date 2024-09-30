package com.mongodb.crud.util;

public record APIResponse<T>(int statusCode, String message, T body) {
}

