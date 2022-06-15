package com.uyawer.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uyawer.portal.constants.Page;
import com.uyawer.portal.editor.DashboardEditor;
import com.uyawer.portal.model.screen.DashboardScreen;

@Controller
@RequestMapping(path = {"/"})
public class DashboardController {

    @GetMapping
    public ModelAndView get() {

        DashboardScreen screen = DashboardEditor.convertScreen("Hello world");

        return new ModelAndView(Page.DASHBOARD)
            .addObject("screen", screen);
    }
}
