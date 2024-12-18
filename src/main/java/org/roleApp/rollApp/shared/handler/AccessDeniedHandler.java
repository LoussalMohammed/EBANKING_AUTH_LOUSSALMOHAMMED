package org.roleApp.rollApp.shared.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;

import java.io.IOException;

public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        org.roleApp.rollApp.shared.exception.AccessDeniedException customAccessDeniedException = new org.roleApp.rollApp.shared.exception.AccessDeniedException(accessDeniedException.getMessage());

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(
                "{ \"error\": \""+ accessDeniedException.getMessage() +"\", " +
                        "\"message\": \"You do not have the necessary permissions to access this resource.\", " +
                        "\"path \": \"" + request.getRequestURI() + "\" " +
                        "}"
        );
    }
}
