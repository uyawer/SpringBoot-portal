/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.security;

import com.uyawer.portal.constants.type.RoleType;
import com.uyawer.portal.service.impl.LoginUserDetailsServiceImpl;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    private final LoginUserDetailsServiceImpl userDetailsService;

    public WebSecurityConfiguration(LoginUserDetailsServiceImpl service) {
        this.userDetailsService = service;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeHttpRequestsCustomizer -> authorizeHttpRequestsCustomizer
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // cssやjsなどのリソースは認証不要
                .requestMatchers("/terms").permitAll() // 利用規約画面はログイン不要
                .requestMatchers("/manager/**", "/api/manager/**").hasRole(RoleType.MANAGER.name()) // manager以下はマネージャー以上
                .requestMatchers("/admin/**", "/api/admin/**").hasRole(RoleType.ADMIN.name()) // admin以下は管理者のみ
                .anyRequest().authenticated()) // 指定したURL以外は認証が必要
            // ログインの設定
            .formLogin(formLoginCustomizer -> formLoginCustomizer
                .loginPage("/login") // pathではなくHTMLのファイル名
                .loginProcessingUrl("/login") // ログインフォームからの送信先
                .usernameParameter("loginId")
                .passwordParameter("password")
                .defaultSuccessUrl("/") // ログイン成功時の遷移先
                .failureUrl("/login?error")
                .permitAll())
            // ログアウトの設定
            .logout(logoutCustomizer -> logoutCustomizer
                .logoutUrl("/logout") // ログアウトのURL
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true));
        //.expressionHandler(createSecurityExpressionHandler())
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder()); // 入力値をハッシュ化した値に変換し認証を行う
        return auth.build();
    }

    /**
     * TODO: 権限の優劣の設定を作成
     *
     * @return 権限の優劣がまとまっているオブジェクト
     */
    private SecurityExpressionHandler<FilterInvocation> createSecurityExpressionHandler() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(RoleType.ADMIN.getRoleName() + " > " + RoleType.MANAGER.getRoleName());
        roleHierarchy.setHierarchy(RoleType.MANAGER.getRoleName() + " > " + RoleType.GENERAL.getRoleName());
        roleHierarchy.setHierarchy(RoleType.GENERAL.getRoleName() + " > " + RoleType.GUEST.getRoleName());

        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy);
        return expressionHandler;
    }
}
