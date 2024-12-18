package org.roleApp.rollApp.shared.exception;


import org.springframework.http.HttpStatus;

import static org.roleApp.rollApp.shared.constant.ErrorCodes.ACCESS_DENIED;

public class AccessDeniedException extends BaseException {
    public AccessDeniedException(String message) {
        super(message, ACCESS_DENIED, HttpStatus.FORBIDDEN);
    }
}
