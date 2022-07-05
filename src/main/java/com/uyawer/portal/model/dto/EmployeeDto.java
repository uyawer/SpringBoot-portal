/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.model.dto;

import com.uyawer.portal.constants.type.BloodType;
import com.uyawer.portal.constants.type.GenderType;
import com.uyawer.portal.helper.utils.DateUtils;
import com.uyawer.portal.model.entity.EmployeeEntity;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeDto {

    /** ID */
    private Long id;

    /** 社員番号 */
    private String number;

    /** ログインID */
    private String loginId;

    /** 名字 */
    private String lastName;

    /** 名前 */
    private String firstName;

    /** 名字カナ */
    private String lastNameKana;

    /** 名前カナ */
    private String firstNameKana;

    /** フルネーム */
    private String fullName;

    /** パスワード */
    private String password;

    /** パスワードリセットフラグ */
    private boolean passwordResetFlg;

    /** 役職 */
    private String position;

    /** 部署ID */
    private Long departmentId;

    /** 権限ID */
    private Long roleId;

    /** 生年月日 */
    private LocalDate birthday;

    /** 年齢 */
    private Integer age;

    /** 性別 */
    private GenderType genderType;

    /** 血液型 */
    private BloodType bloodType;

    /** 出身地 */
    private String birthplace;

    /** 自己紹介 */
    private String biography;

    /** 退職フラグ */
    private boolean retirementFlg;

    public EmployeeDto(EmployeeEntity entity) {
        this.id = entity.getId();
        this.number = entity.getNumber();
        this.loginId = entity.getLoginId();
        this.lastName = entity.getLastName();
        this.firstName = entity.getFirstName();
        this.lastNameKana = entity.getLastNameKana();
        this.firstNameKana = entity.getFirstNameKana();
        this.fullName = String.format("%s %s", entity.getLastName(), entity.getFirstName());
        this.password = null; // パスワードはhashで持っているが渡さない
        this.passwordResetFlg = entity.isPasswordResetFlg();
        this.position = entity.getPosition();
        this.departmentId = entity.getDepartmentId();
        this.roleId = entity.getRoleId();
        this.birthday = entity.getBirthday();
        this.age = DateUtils.calcAge(entity.getBirthday());
        this.genderType = GenderType.valueOf(entity.getGender());
        this.bloodType = BloodType.valueOf(entity.getBlood());
        this.birthplace = entity.getBirthplace();
        this.biography = entity.getBiography();
        this.retirementFlg = entity.isRetirementFlg();
    }

    public String getAgeLabel() {
        if (this.age == null) {
            return StringUtils.EMPTY;
        }
        return String.format("%d歳", age);
    }

    public String getGenderTypeLabel() {
        if (this.genderType == null) {
            return StringUtils.EMPTY;
        }
        return this.genderType.getLabel();
    }

    public Integer getGenderTypeValue() {
        if (this.genderType == null) {
            return null;
        }
        return this.genderType.getValue();
    }

    public String getBloodTypeLabel() {
        if (this.bloodType == null) {
            return StringUtils.EMPTY;
        }
        return this.bloodType.getLabel();
    }

    public Integer getBloodTypeValue() {
        if (this.bloodType == null) {
            return null;
        }
        return this.bloodType.getValue();
    }
}
