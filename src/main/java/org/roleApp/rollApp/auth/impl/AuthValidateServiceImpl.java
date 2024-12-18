package org.roleApp.rollApp.auth.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.auth.service.AuthValidateService;
import org.roleApp.rollApp.shared.exception.InvalidDataException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.roleApp.rollApp.shared.constant.ApiConstants.API_PWNED_URL;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthValidateServiceImpl implements AuthValidateService {

    public boolean isPasswordPwned(String password) {
        try {
            // Hash the password using SHA-1
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] hash = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
    
            // Convert the hash to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
    
            // Get the first 5 characters of the hash
            String hashPrefix = hexString.substring(0, 5);
            String hashSuffix = hexString.substring(5).toUpperCase(); // Get the rest of the hash
    
            // Call the Pwned Passwords API with the hash prefix
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(API_PWNED_URL + hashPrefix, String.class);
    
            // Check if the hashSuffix is in the response
            if (response != null) {
                String[] compromisedHashes = response.split("\n");
                for (String compromisedHash : compromisedHashes) {
                    if (compromisedHash.startsWith(hashSuffix)) {
                        return true; // Password is compromised
                    }
                }
            }
            return false; // Password is not compromised
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password: ", e);
        }
    }

    @Override
    public void createValidate(AppUser entity){
        if(isPasswordPwned(entity.getPassword())) {
            throw new InvalidDataException("password have been compromised, please choose another password!");
        }
    }

    @Override
    public void findAllValidate(Page<AppUser> page) {

    }

    @Override
    public void findByIdValidate(AppUser entity) {

    }

    @Override
    public void updateByIdValidate(AppUser updateEntity, Long id) {

    }

    @Override
    public void deleteByIdValidate(Long id) {

    }
}
