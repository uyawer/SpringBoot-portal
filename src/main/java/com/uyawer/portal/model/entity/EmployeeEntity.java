package com.uyawer.portal.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    /** ID */
    @Id
    private Long id;

    /** 社員番号 */
    private String number;

    /** ログインID */
    @Column(name = "login_id")
    private String loginId;

    /** 性 */
    @Column(name = "last_name")
    private String lastName;

    /** 名 */
    @Column(name = "first_name")
    private String firstName;

    /** 性カナ */
    @Column(name = "last_name_kana")
    private String lastNameKana;

    /** 名カナ */
    @Column(name = "first_name_kana")
    private String firstNameKana;

    /** パスワード */
    private String password;

    /** パスワードリセットフラグ */
    @Column(name = "password_reset_flg")
    private boolean passwordResetFlg;

    /** 役職 */
    private String position;

    /** 部署ID */
    @Column(name = "department_id")
    private Long departmentId;

    /** 権限ID */
    @Column(name = "role_id")
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
    @Column(name = "retirement_flg")
    private boolean retirementFlg;

    /** 作成日時 */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /** 更新日時 */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /** 削除フラグ */
    @Column(name = "delete_flg")
    private boolean deleteFlg;

    /**
     * 削除フラグを有効にします
     */
    public void enableDeleteFlg() {
        this.deleteFlg = true;
    }
}
