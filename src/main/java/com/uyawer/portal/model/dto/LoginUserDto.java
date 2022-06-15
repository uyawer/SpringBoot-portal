package com.uyawer.portal.model.dto;

import com.uyawer.portal.model.entity.EmployeeEntity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Collection;

import lombok.Getter;

@Getter
public class LoginUserDto extends User {

    /** ID */
    private final Long id;

    /** 社員番号 */
    private final String number;

    /** 性 */
    private final String lastName;

    /** 名 */
    private final String firstName;

    /** 性カナ */
    private final String lastNameKana;

    /** 名カナ */
    private final String firstNameKana;

    /** パスワードリセットフラグ */
    private final boolean passwordResetFlg;

    /** 役職 */
    private final String position;

    /** 部署ID */
    private final Long departmentId;

    /** 権限ID */
    private final Long roleId;

    /** 生年月日 */
    private final LocalDate birthday;

    /** 性別 */
    private final Integer sex;

    /** 血液型 */
    private final Integer blood;

    /** 出身地 */
    private final String birthplace;

    /** 自己紹介 */
    private final String biography;

    /** 退職フラグ */
    private final boolean retirementFlg;

    private final String fullName;

    public LoginUserDto(EmployeeEntity entity, Collection<? extends GrantedAuthority> authorities) {
        super(entity.getLoginId(), entity.getPassword(), authorities);
        this.id = entity.getId();
        this.number = entity.getNumber();
        this.lastName = entity.getLastName();
        this.firstName = entity.getFirstName();
        this.lastNameKana = entity.getLastNameKana();
        this.firstNameKana = entity.getFirstNameKana();
        this.fullName = String.format("%s %s", entity.getLastName(), entity.getFirstName());
        this.passwordResetFlg = entity.isPasswordResetFlg();
        this.position = entity.getPosition();
        this.departmentId = entity.getDepartmentId();
        this.roleId = entity.getRoleId();
        this.birthday = entity.getBirthday();
        this.sex = entity.getSex();
        this.blood = entity.getBlood();
        this.birthplace = entity.getBirthplace();
        this.biography = entity.getBiography();
        this.retirementFlg = entity.isRetirementFlg();
    }
}
