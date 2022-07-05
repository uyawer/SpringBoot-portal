/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.service.impl;

import com.uyawer.portal.model.entity.EmployeeEntity;
import com.uyawer.portal.model.form.AdminManageEmployeePostForm;
import com.uyawer.portal.model.form.AdminManageEmployeePutForm;
import com.uyawer.portal.repository.EmployeesRepository;
import com.uyawer.portal.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository employeesRepository;

    public EmployeeServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeesRepository.findByDeleteFlgFalseOrderById();
    }

    @Override
    public EmployeeEntity findById(Long id) {
        Optional<EmployeeEntity> res = employeesRepository.findByIdAndDeleteFlgFalse(id);
        if (res.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IDに一致する従業員情報が見つかりません。 id=" + id);
        }
        return res.get();
    }

    @Override
    public EmployeeEntity register(AdminManageEmployeePostForm form) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setNumber(form.getNumber());
        entity.setLoginId(form.getLoginId());
        entity.setLastName(form.getLastName());
        entity.setFirstName(form.getFirstName());
        entity.setLastNameKana(form.getLastNameKana());
        entity.setFirstNameKana(form.getFirstNameKana());
        entity.setRoleId(1L); // TODO:(uyawer) 権限IDを設定
        entity.setBirthday(form.getBirthdayToLocalDate());
        entity.setGender(form.getGender().getValue());
        entity.setBlood(form.getBlood().getValue());
        entity.setBirthplace(form.getBirthplace());
        // DBに反映
        employeesRepository.save(entity);

        // 登録した従業員情報を返却する
        Long id = entity.getId();
        Optional<EmployeeEntity> res = employeesRepository.findByIdAndDeleteFlgFalse(id);
        if (res.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IDに一致する従業員情報が見つかりません。 id=" + id);
        }
        return res.get();
    }

    @Override
    public EmployeeEntity update(Long id, AdminManageEmployeePutForm form) {
        // 従業員情報を取得
        EmployeeEntity entity = findById(id);
        // 内容を更新
        entity.setNumber(form.getNumber());
        entity.setLoginId(form.getLoginId());
        entity.setLastName(form.getLastName());
        entity.setFirstName(form.getFirstName());
        entity.setLastNameKana(form.getLastNameKana());
        entity.setFirstNameKana(form.getFirstNameKana());
        entity.setBirthday(form.getBirthdayToLocalDate());
        entity.setGender(form.getGender().getValue());
        entity.setBlood(form.getBlood().getValue());
        entity.setBirthplace(form.getBirthplace());
        // DBに反映
        employeesRepository.save(entity);

        // 更新した従業員情報を返却する
        return entity;
    }

    @Override
    public void delete(Long id) {
        // 従業員情報を取得
        EmployeeEntity entity = findById(id);
        // 削除フラグを有効に設定
        entity.enableDeleteFlg();
        // DBに反映
        employeesRepository.save(entity);
    }
}
