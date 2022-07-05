/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.security;

import com.uyawer.portal.constants.type.RoleType;
import com.uyawer.portal.service.impl.LoginUserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final LoginUserDetailsServiceImpl userDetailsService;

    public WebSecurityConfiguration(LoginUserDetailsServiceImpl service) {
        this.userDetailsService = service;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
            "/images/**",
            "/css/**",
            "/js/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .expressionHandler(createSecurityExpressionHandler())
            .antMatchers("/terms").permitAll() // 利用規約画面はログイン不要
            .antMatchers("/manager/**", "/api/manager/**").hasRole(RoleType.MANAGER.name()) // manager以下はマネージャー以上
            .antMatchers("/admin/**", "/api/admin/**").hasRole(RoleType.ADMIN.name()) // admin以下は管理者のみ
            .anyRequest().authenticated() // 指定したURL以外は認証が必要
            .and()
            // ログインの設定
            .formLogin()
            .loginPage("/login") // pathではなくHTMLのファイル名
            .loginProcessingUrl("/login") // ログインフォームからの送信先
            .usernameParameter("loginId")
            .passwordParameter("password")
            .defaultSuccessUrl("/") // ログイン成功時の遷移先
            .failureUrl("/login?error")
            .permitAll()
            .and()
            // ログアウトの設定
            .logout()
            .logoutUrl("/logout") // ログアウトのURL
            .logoutSuccessUrl("/login?logout")
            .permitAll()
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            // 入力値をハッシュ化した値に変換し認証を行う
            .passwordEncoder(passwordEncoder());
    }

    /**
     * 権限の優劣の設定を作成
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
