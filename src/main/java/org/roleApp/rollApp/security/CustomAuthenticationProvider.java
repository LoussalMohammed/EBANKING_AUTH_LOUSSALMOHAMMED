package org.roleApp.rollApp.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_user.repository.AppUserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("dev")
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails user = customUserDetailsService.loadUserByUsername(email);
        if(user != null && passwordEncoder.matches(password, user.getPassword())) {
            log.info("password = {}, after encoding = {}", password, passwordEncoder.encode("password"));
            log.info(passwordEncoder.encode(password) +" == "+ user.getPassword() + " returns: "+ passwordEncoder.encode(password).equals(user.getPassword()));
            return new UsernamePasswordAuthenticationToken(email, password, user.getAuthorities());
        } else {
            throw new BadCredentialsException("Invalid email or password!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
