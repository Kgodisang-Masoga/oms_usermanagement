package com.fnb.usermanagement.config;

import com.fnb.usermanagement.entity.Role;
import com.fnb.usermanagement.entity.User;
import com.fnb.usermanagement.entity.UserCredential;
import com.fnb.usermanagement.repository.UserCredentialsRepository;
import com.fnb.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class adminSeeder implements CommandLineRunner {

    private static final String ADMIN_USERNAME = "ADMIN";
    private static final String ADMIN_PASSWORD = "ADMIN123";
    private static final String ADMIN_EMAIL = "admin@fnbproject";

    private final UserRepository userRepository;
    private final UserCredentialsRepository userCredentialsRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.existsByEmail(ADMIN_EMAIL)) {
            log.info("User with email {} already exists", ADMIN_EMAIL);
            return;
        }

        User user = User.builder()
                .firstName(ADMIN_USERNAME)
                .surname("Admin")
                .email(ADMIN_EMAIL)
                .role(Role.ADMIN)
                .build();
        user = userRepository.save(user);

        UserCredential credential = UserCredential.builder()
                .user(user)
                .password(passwordEncoder.encode(ADMIN_PASSWORD))
                .build();
        userCredentialsRepository.save(credential);
    }
}
