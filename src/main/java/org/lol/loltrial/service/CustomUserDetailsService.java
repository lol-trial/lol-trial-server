package org.lol.loltrial.service;

import lombok.RequiredArgsConstructor;
import org.lol.loltrial.dto.CustomUserDetails;
import org.lol.loltrial.entity.User;
import org.lol.loltrial.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByName(username);

        if(user != null) {
            return new CustomUserDetails(user);
        }

        return null;
    }
}
