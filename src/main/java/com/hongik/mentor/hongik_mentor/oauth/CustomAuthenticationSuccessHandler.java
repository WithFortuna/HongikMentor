package com.hongik.mentor.hongik_mentor.oauth;

//기능: 로그인 성공 후, 신규유저 여부에 따라 리다이렉트 경로 설정

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

//소셜로그인 성공 시, 유저 가입 여부에 따라 리다이렉트 경로를 결정함
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal(); //Oauth2UserService에서 Oauth2User를 반환했으므로 어딘가에는 저장되어있었을 것. 여길보면 그게 Authentication인듯?

        //신규유저 리다이렉트
        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_TEMP"))) {
            response.sendRedirect("/member");
        }
        //기존유저 리다이렉트
        else {
            response.sendRedirect("/");
        }
    }
}
