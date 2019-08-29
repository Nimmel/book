package com.readbooker.website.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Base exception of the project.
 *
 * @author johnniang
 */
public abstract class BookerException extends RuntimeException {

    /**
     * Error errorData.
     */
    private Object errorData;

    public BookerException(String message) {
        super(message);
    }

    public BookerException(String message, Throwable cause) {
        super(message, cause);
    }

    @NonNull
    public abstract HttpStatus getStatus();

    @Nullable
    public Object getErrorData() {
        return errorData;
    }

    /**
     * Sets error errorData.
     *
     * @param errorData error data
     * @return current exception.
     */
    @NonNull
    public BookerException setErrorData(@Nullable Object errorData) {
        this.errorData = errorData;
        return this;
    }
}
