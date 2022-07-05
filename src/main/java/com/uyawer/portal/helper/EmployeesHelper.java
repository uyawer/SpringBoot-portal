/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.helper;

import com.google.common.collect.Lists;
import com.uyawer.portal.model.dto.EmployeeDto;
import com.uyawer.portal.model.entity.EmployeeEntity;

import java.util.List;

public class EmployeesHelper {

    public static List<EmployeeDto> convertDtoList(EmployeeEntity entity) {
        return Lists.newArrayList(convertDto(entity));
    }

    public static List<EmployeeDto> convertDtoList(List<EmployeeEntity> entityList) {
        return entityList.stream()
            .map(EmployeesHelper::convertDto)
            .toList();
    }

    public static EmployeeDto convertDto(EmployeeEntity entity) {
        return new EmployeeDto(entity);
    }
}
