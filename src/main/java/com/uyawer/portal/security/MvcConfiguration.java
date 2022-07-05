/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 権限を持っていなくても表示できる画面を設定
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/terms").setViewName("terms");
    }

}
