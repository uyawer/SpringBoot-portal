/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.repository;

import com.uyawer.portal.model.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByIdAndDeleteFlgFalse(
        Long id
    );

    Optional<EmployeeEntity> findByLoginId(
        String loginId
    );

    List<EmployeeEntity> findByDeleteFlgFalseOrderById();
}
