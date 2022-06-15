package com.uyawer.portal.model.screen;

import java.util.List;

import com.uyawer.portal.model.dto.EmployeeDto;
import lombok.Data;

@Data
public class AdminManageEmployeeListScreen {

    private List<EmployeeDto> employeeList;
}
