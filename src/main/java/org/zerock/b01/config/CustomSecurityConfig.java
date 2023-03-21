package org.zerock.b01.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class CustomSecurityConfig {
    //스프링 시큐리티는 별도의 설정이 없을 땐 모든 자원에 필요한 권한이나 로그인 여부 등을 확인한다.
    //Using generated security password:

    @Bean   //웹에서 사용하는 필터(filter)로 접근 제어
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        log.info("-------------configure-------------");    //동작여부 확인

        //로그인화면에서 로그인을 진행하는 설정(사용자의 아이디 인증)
        http.formLogin();

        return http.build();
    }

    @Bean   //정적으로 동작하는 파일들(css,js파일..)스프링시큐리티 적용제외
    public WebSecurityCustomizer webSecurityCustomizer() {

        log.info("-------------web configure-----------");

        return (web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()));
    }

    @Bean   //패스워드 암호화 처리
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //해시 알고리즘으로 암호화 처리
    }

}
