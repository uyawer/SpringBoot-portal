/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.controller;

import com.uyawer.portal.constants.Page;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/"})
public class DashboardController {

    @Transactional(readOnly = true)
    @GetMapping
    public ModelAndView get() {
        return new ModelAndView(Page.DASHBOARD)
            .addObject("message", "Hello world");
    }
}
