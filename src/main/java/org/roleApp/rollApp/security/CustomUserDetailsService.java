package org.roleApp.rollApp.security;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.app_role.repository.AppRoleRepository;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.app_user.repository.AppUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final AppUserRepository userRepository;
    private final AppRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("going to get user by email");
        AppUser user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("No entity user found using specified email: "+ email);
        }


        Collection<GrantedAuthority> authorities = new ArrayList<>();
        log.info("getting role name");
        for(AppRole role: roleRepository.findByUserId(user.getId())) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        log.info("user name: {}, user password: {}, user authorities: {}", user.getName(), user.getPassword(), authorities);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }
}
