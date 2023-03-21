package org.zerock.b01.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    // 실제 인증을 처리하는 UserDetailsService 인터페이스 구현

    /**
     * 1. UserDetails라는 인터페이스 타입에 맞는 객체가 필요
     * 2. 이 객체를 CustomUserDetailsService에서 반환
     */
    @Override   // 인증처리시 호출되는 loadUserByUsername
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // username(사용자의 아이디) 인증

        log.info("loadUserByUsername: " + username);

        return null;
    }
}
