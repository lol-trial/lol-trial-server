package org.lol.loltrial.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lol.loltrial.dto.OAuth2Details;
import org.lol.loltrial.dto.UserDetail;
import org.lol.loltrial.dto.OAuth2UserDto;
import org.lol.loltrial.entity.User;
import org.lol.loltrial.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class OAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 유저 정보
        Map<String, Object> oAuth2UserAttributes = super.loadUser(userRequest).getAttributes();

        // resistrationId
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // userNameAttributeName 가져오기
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        OAuth2UserDto oAuth2UserDto = OAuth2UserDto.of(registrationId, oAuth2UserAttributes);

        User user = userRepository.findByEmail(oAuth2UserDto.email())
                .orElseGet(() -> oAuth2UserDto.toEntity(registrationId));

        userRepository.save(user);

        log.info("regId = {}, userNameAttr = {}", registrationId, userNameAttributeName);

        return new OAuth2Details(user, oAuth2UserAttributes, userNameAttributeName);
    }
}