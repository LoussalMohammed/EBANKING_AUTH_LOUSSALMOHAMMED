package org.roleApp.rollApp.shared.exception;

import org.springframework.http.HttpStatus;

import static org.roleApp.rollApp.shared.constant.ErrorCodes.RESOURCE_NOT_FOUND;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String message) {
        super(message, RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}