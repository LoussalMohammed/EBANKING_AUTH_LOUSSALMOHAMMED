package org.roleApp.rollApp.shared.exception;

import org.springframework.http.HttpStatus;

import static org.roleApp.rollApp.shared.constant.ErrorCodes.INVALID_RELATIONSHIP;

public class InvalidRelationshipException extends BaseException {
    public InvalidRelationshipException(String message) {
        super(message, INVALID_RELATIONSHIP, HttpStatus.BAD_REQUEST);
    }
}
