package com.uyawer.portal.controller;

import com.uyawer.portal.constants.Page;
import com.uyawer.portal.editor.DashboardEditor;
import com.uyawer.portal.model.screen.DashboardScreen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"/admin/manage/departments"})
public class AdminManageDepartmentsController {

    @GetMapping
    public ModelAndView get() {

        DashboardScreen screen = DashboardEditor.convertScreen("Hello world");

        return new ModelAndView(Page.ADMIN_MANAGE_DEPARTMENTS)
            .addObject("screen", screen);
    }
}
