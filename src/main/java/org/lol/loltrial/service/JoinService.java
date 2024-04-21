package org.lol.loltrial.service;

import lombok.RequiredArgsConstructor;
import org.lol.loltrial.dto.JoinDto;
import org.lol.loltrial.entity.User;
import org.lol.loltrial.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(JoinDto joinDto) {
        Boolean exists = userRepository.existsByName(joinDto.getUsername());

        if(exists) {
            return;
        }

        User user = new User();

        user.setName(joinDto.getUsername());
//        user.setPassword(
//                bCryptPasswordEncoder.encode(joinDto.getPassword())
//        );
        user.setRole("ROLE_USER");

        userRepository.save(user);

    }
}
