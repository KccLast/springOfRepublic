package com.kcc.rich.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(authorize ->
                authorize.requestMatchers("/members/confirm-myInfo").authenticated()
                        .requestMatchers("/members/update-info").authenticated()

                        .anyRequest().permitAll()
        ).formLogin(form ->
                form.loginPage("/members/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/members/join"));
//        http.logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/members/login")
//                .deleteCookies("JSESSIONID", "remember-me")
//                .addLogoutHandler(logoutHandler())
//                .logoutSuccessHandler(logoutSuccessHandler());
        return http.build();
    }

    private void logoutConfigure(HttpSecurity http) throws Exception {
        http.logout()                                       // 로그아웃 기능이 동작
                .logoutUrl("/logout")                           // 로그아웃 처리 URL
                .logoutSuccessUrl("/login")                     // 로그아웃 성공 후 이동 페이지
                .deleteCookies("JSESSIONID", "remember-me")     // 로그아웃 후 쿠키 삭제
                .addLogoutHandler(logoutHandler())              // 로그아웃 핸들러
                .logoutSuccessHandler(logoutSuccessHandler());  // 로그아웃 성공 후 핸들러
    }

    // 로그아웃 성공 후 리다이렉트 또는 처리할 핸들러
    private LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            System.out.println("로그아웃 성공!");
            response.sendRedirect("/login");
        };
    }

    // 로그아웃 처리 중 추가 작업을 할 핸들러 (예: 세션 정리)
    private LogoutHandler logoutHandler() {
        return (request, response, authentication) -> {
            if (authentication != null) {
                System.out.println("로그아웃 처리 중: " + authentication.getName());
                // 세션 무효화 또는 기타 작업
                request.getSession().invalidate();
            }
        };
    }
}

