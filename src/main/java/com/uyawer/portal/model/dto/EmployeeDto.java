package com.uyawer.portal.model.dto;

import java.time.LocalDate;

import com.uyawer.portal.model.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class EmployeeDto {

    /** ID */
    private Long id;

    /** 社員番号 */
    private String number;

    /** ログインID */
    private String loginId;

    /** 性 */
    private String lastName;

    /** 名 */
    private String firstName;

    /** 性カナ */
    private String lastNameKana;

    /** 名カナ */
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

    /** 性別 */
    private Integer sex;

    /** 血液型 */
    private Integer blood;

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
        this.sex = entity.getSex();
        this.blood = entity.getBlood();
        this.birthplace = entity.getBirthplace();
        this.biography = entity.getBiography();
        this.retirementFlg = entity.isRetirementFlg();
    }
}
