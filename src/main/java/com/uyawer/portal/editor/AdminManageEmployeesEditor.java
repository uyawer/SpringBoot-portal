package com.uyawer.portal.editor;

import com.uyawer.portal.model.dto.EmployeeDto;
import com.uyawer.portal.model.entity.EmployeeEntity;
import com.uyawer.portal.model.screen.AdminManageEmployeeEditScreen;
import com.uyawer.portal.model.screen.AdminManageEmployeeListScreen;

import java.util.List;
import java.util.stream.Collectors;

public class AdminManageEmployeesEditor {

    public static AdminManageEmployeeListScreen convertListScreen(List<EmployeeEntity> entityList) {
        List<EmployeeDto> dtoList = entityList.stream()
            .map(EmployeeDto::new)
            .collect(Collectors.toList());

        AdminManageEmployeeListScreen screen = new AdminManageEmployeeListScreen();
        screen.setEmployeeList(dtoList);
        return screen;
    }

    public static AdminManageEmployeeEditScreen convertEditScreen(EmployeeEntity entity) {
        EmployeeDto dto = new EmployeeDto(entity);

        AdminManageEmployeeEditScreen screen = new AdminManageEmployeeEditScreen();
        screen.setEmployee(dto);
        return screen;
    }
}
