/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.model.entity;

import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@DynamicInsert
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 社員番号 */
    private String number;

    /** ログインID */
    @Column(name = "login_id")
    private String loginId;

    /** 名字 */
    @Column(name = "last_name")
    private String lastName;

    /** 名前 */
    @Column(name = "first_name")
    private String firstName;

    /** 名字カナ */
    @Column(name = "last_name_kana")
    private String lastNameKana;

    /** 名前カナ */
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
    private Integer gender;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime createdAt;

    /** 更新日時 */
    @Column(name = "updated_at")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        EmployeeEntity employee = (EmployeeEntity) o;
        return id != null && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
