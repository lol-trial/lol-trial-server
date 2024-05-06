package org.lol.loltrial.dto;

import lombok.Builder;
import org.lol.loltrial.entity.User;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record OAuth2UserDto(
        String name,
        String email
) {
    public static OAuth2UserDto of(String registrationId, Map<String, Object> attributes) {
        return switch (registrationId) {
            case "kakao" -> ofKakao(attributes);
            default -> throw new IllegalStateException("registrationId error");
        };
    }

    @SuppressWarnings(value = "unchecked")
    private static OAuth2UserDto ofKakao(Map<String, Object> attributes) {
        Map<String, Object> account = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) account.get("profile");

        return OAuth2UserDto.builder()
                .name((String) profile.get("nickname"))
                .email(profile.get("nickname") + "@google.com") //email은 kakao 승인 필요로 인해 nickname 필드로 임시 대체
                .build();
    }

    public User toEntity(String provider) {
        return User.builder()
                .name(name)
                .email(email)
                .role("USER")
                .provider(provider)
                .lastLogin(LocalDateTime.now())
                .build();
    }
}
