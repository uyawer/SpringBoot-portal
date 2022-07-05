/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.controller;

import com.uyawer.portal.helper.EmployeesHelper;
import com.uyawer.portal.model.dto.EmployeeDto;
import com.uyawer.portal.model.entity.EmployeeEntity;
import com.uyawer.portal.model.form.AdminManageEmployeePostForm;
import com.uyawer.portal.model.form.AdminManageEmployeePutForm;
import com.uyawer.portal.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = {"/api/admin/manage/employees"})
public class AdminManageEmployeeApiController {

    private final EmployeeService employeeService;

    public AdminManageEmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long id) {
        // 指定された従業員IDから従業員情報を取得
        EmployeeEntity entity = employeeService.findById(id);
        // DTOに変換して返却
        return new ResponseEntity<>(EmployeesHelper.convertDto(entity), HttpStatus.OK);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<EmployeeDto> post(@Validated @RequestBody AdminManageEmployeePostForm form) {
        // TODO:(uyawer) 重複チェック
        // 指定された従業員IDの従業員情報を更新
        EmployeeEntity entity = employeeService.register(form);
        // 更新後の従業員情報をDTOに変換して返却
        return new ResponseEntity<>(EmployeesHelper.convertDto(entity), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> put(@PathVariable("id") Long id, @Validated @RequestBody AdminManageEmployeePutForm form) {
        // 指定された従業員IDの従業員情報を更新
        EmployeeEntity entity = employeeService.update(id, form);
        // 更新後の従業員情報をDTOに変換して返却
        return new ResponseEntity<>(EmployeesHelper.convertDto(entity), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping({"{id}"})
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        // 指定された従業員IDの従業員情報を削除フラグする
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
