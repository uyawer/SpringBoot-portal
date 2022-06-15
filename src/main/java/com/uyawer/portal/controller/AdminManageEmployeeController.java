package com.uyawer.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.uyawer.portal.constants.Page;
import com.uyawer.portal.editor.AdminManageEmployeesEditor;
import com.uyawer.portal.model.entity.EmployeeEntity;
import com.uyawer.portal.model.form.AdminManageEmployeeDeleteForm;
import com.uyawer.portal.repository.EmployeesRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = {"/admin/manage/employees"})
public class AdminManageEmployeeController {

    private final EmployeesRepository employeesRepository;

    public AdminManageEmployeeController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ModelAndView get() {
        // 全ての従業員情報を取得
        List<EmployeeEntity> entityList = employeesRepository.findByDeleteFlgFalseOrderById();
        // 画面表示
        return new ModelAndView(Page.ADMIN_MANAGE_EMPLOYEES)
            .addObject("screen", AdminManageEmployeesEditor.convertListScreen(entityList));
    }

    @GetMapping("{id}")
    public ModelAndView get(@PathVariable("id") Long id) {
        // 指定された従業員IDから従業員情報を取得
        EmployeeEntity entity = employeesRepository.findById(id)
            .orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IDに一致する従業員情報が見つかりません。 id=" + id);
            });

        return new ModelAndView(Page.ADMIN_MANAGE_EMPLOYEES_EDIT)
            .addObject("screen", AdminManageEmployeesEditor.convertEditScreen(entity));
    }

    @Transactional
    @DeleteMapping
    public ModelAndView delete(@ModelAttribute("deleteForm") AdminManageEmployeeDeleteForm form) {
        // 指定された従業員IDから従業員情報を取得
        Long id = form.getDeleteEmployeeId();
        EmployeeEntity entity = employeesRepository.findById(id)
            .orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IDに一致する従業員情報が見つかりません。 id=" + id);
            });

        // 削除フラグを有効に設定
        entity.enableDeleteFlg();
        employeesRepository.save(entity);

        // 一覧画面を再表示
        return get();
    }
}
