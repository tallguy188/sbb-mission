package com.ll.sbbmission.User;


import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password) {

        SiteUser user = userRepository.save(
                SiteUser.builder()
                        .username(username)
                                .email(email)
                                        .password(passwordEncoder.encode(password)).build());

        return user;
    }



}
