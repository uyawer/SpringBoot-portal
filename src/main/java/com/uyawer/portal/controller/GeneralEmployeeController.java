/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.controller;

import com.uyawer.portal.constants.Page;
import com.uyawer.portal.helper.EmployeesHelper;
import com.uyawer.portal.model.entity.EmployeeEntity;
import com.uyawer.portal.repository.EmployeesRepository;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = {"/general/employees"})
public class GeneralEmployeeController {

    private final EmployeesRepository employeesRepository;

    public GeneralEmployeeController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ModelAndView get() {
        // 全ての従業員情報を取得
        List<EmployeeEntity> entityList = employeesRepository.findByDeleteFlgFalseOrderById();
        // 画面表示
        return new ModelAndView(Page.GENERAL_EMPLOYEES)
            .addObject("employeeList", EmployeesHelper.convertDtoList(entityList));
    }
}
