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
                                .defaultSuccessUrl("/"))
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃 요청 경로
                        .logoutSuccessUrl("/") // 로그아웃 성공 시 이동할 경로
                        .deleteCookies("JSESSIONID", "remember-me")
                        .addLogoutHandler(logoutHandler())
                        .logoutSuccessHandler(logoutSuccessHandler())
                );
        return http.build();
    }

    // 로그아웃 성공 후 리다이렉트 또는 처리할 핸들러
    private LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            System.out.println("로그아웃 성공!");
            response.sendRedirect("/");
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