package com.mongodb.crud.constant;

import static com.mongodb.crud.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class AspectConstant {
    public static final String BEFORE_MESSAGE = "Executing ===> {}.{} with arguments: [{}]";
    public static final String AFTER_RETURN_MESSAGE = "Finished ===> {}.{} with arguments: [{}] and returned {}";
    public static final String AFTER_THROW_MESSAGE = "Exception {} in ===> {}.{} with arguments: [{}]";

    private AspectConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
