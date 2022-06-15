package com.uyawer.portal.model.screen;

import com.uyawer.portal.model.dto.EmployeeDto;

import java.util.List;

import lombok.Data;

@Data
public class AdminManageEmployeeListScreen {

    private List<EmployeeDto> employeeList;
}
