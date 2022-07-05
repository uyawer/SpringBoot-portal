/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.service.impl;

import com.uyawer.portal.constants.type.RoleType;
import com.uyawer.portal.model.dto.LoginUserDto;
import com.uyawer.portal.model.entity.EmployeeEntity;
import com.uyawer.portal.model.entity.RoleEntity;
import com.uyawer.portal.repository.EmployeesRepository;
import com.uyawer.portal.repository.RolesRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class LoginUserDetailsServiceImpl implements UserDetailsService {

    private final EmployeesRepository employeesRepository;

    private final RolesRepository rolesRepository;

    public LoginUserDetailsServiceImpl(EmployeesRepository employeesRepository, RolesRepository rolesRepository) {
        this.employeesRepository = employeesRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 従業員情報を取得
        Optional<EmployeeEntity> employeeOptional = employeesRepository.findByLoginId(userName);
        if (employeeOptional.isEmpty()) {
            throw new UsernameNotFoundException("No user matching the login ID was found. {loginId: " + userName + "}");
        }

        // 権限情報を取得
        EmployeeEntity employee = employeeOptional.get();
        Optional<RoleEntity> roleOptional = rolesRepository.findById(employee.getRoleId());
        if (roleOptional.isEmpty()) {
            throw new UsernameNotFoundException("Authorization information not found. {employee: " + employee + "}");
        }

        // 権限のリスト
        RoleEntity role = roleOptional.get();
        Collection<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(RoleType.GUEST.getRoleName());
        if (role.isGeneralFlg()) {
            authorityList.add(new SimpleGrantedAuthority(RoleType.GENERAL.getRoleName()));
        }
        if (role.isManagerFlg()) {
            authorityList.add(new SimpleGrantedAuthority(RoleType.MANAGER.getRoleName()));
        }
        if (role.isAdminFlg()) {
            authorityList.add(new SimpleGrantedAuthority(RoleType.ADMIN.getRoleName()));
        }

        return new LoginUserDto(employee, authorityList);
    }
}
