package org.roleApp.rollApp.security.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.security.CustomUserDetailsService;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Profile("test")
@RequiredArgsConstructor
public class CustomTestAuthenticationProvider implements AuthenticationProvider {
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        boolean password = authentication.getCredentials().toString().isEmpty();

        UserDetails user = customUserDetailsService.loadUserByUsername(email);

        if(user != null && !password) {
            return new UsernamePasswordAuthenticationToken(email, null, user.getAuthorities());
        } else {
            throw new BadCredentialsException("user name or password is incorrect!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
