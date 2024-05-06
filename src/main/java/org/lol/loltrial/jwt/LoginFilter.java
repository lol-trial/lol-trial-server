//package org.lol.loltrial.jwt;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.util.Collection;
//import java.util.Iterator;
//
///* custom login filter */
//@RequiredArgsConstructor
//public class LoginFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//
//    @Value("${spring.jwt.expiration}")
//    private Long expiration;
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        //HTTP 요청 가져오기
//        String username = obtainUsername(request);
//        String password = obtainPassword(request);
//
//        //Token 객체에 HTTP 요청 값을 넣어 객체 생성
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);
//
//        System.out.println("검증중");
//        //Manager 검증
//        return authenticationManager.authenticate(authToken);
//    }
//
//    //로그인 성공 시
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) {
//
//        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
//
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
//        GrantedAuthority auth = iterator.next();
//
//        String username = principal.getUsername();
//        String role = auth.getAuthority();
//        String token = jwtUtil.generateAccessToken(username, username, role, expiration);
//
//        response.addHeader("Authorization", "Bearer " + token);
//    }
//
//    //로그인 실패 시
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
//        response.setStatus(401);
//    }
//
//
//}
