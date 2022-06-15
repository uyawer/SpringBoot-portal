package com.uyawer.portal.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

import com.uyawer.portal.constants.type.RoleType;
import com.uyawer.portal.model.dto.LoginUserDto;
import com.uyawer.portal.model.entity.EmployeeEntity;
import com.uyawer.portal.model.entity.RoleEntity;
import com.uyawer.portal.repository.EmployeesRepository;
import com.uyawer.portal.repository.RolesRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    private final EmployeesRepository employeesRepository;

    private final RolesRepository rolesRepository;

    public LoginUserDetailsService(EmployeesRepository employeesRepository, RolesRepository rolesRepository) {
        this.employeesRepository = employeesRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 従業員情報を取得
        EmployeeEntity employee = employeesRepository.findByLoginId(userName)
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("No user matching the login ID was found. {loginId: " + userName + "}");
            });

        // 権限情報を取得
        RoleEntity role = rolesRepository.findById(employee.getRoleId())
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("Authorization information not found. {employee: " + employee + "}");
            });

        // 権限のリスト
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
