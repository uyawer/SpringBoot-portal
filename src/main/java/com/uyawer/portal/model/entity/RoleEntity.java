/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.model.entity;

import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "roles")
public class RoleEntity {

    /** ID */
    @Id
    private Long id;

    /** 一般フラグ */
    @Column(name = "general_flg")
    private boolean generalFlg;

    /** マネージャーフラグ */
    @Column(name = "manager_flg")
    private boolean managerFlg;

    /** 管理者フラグ */
    @Column(name = "admin_flg")
    private boolean adminFlg;

    /** 作成日時 */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /** 更新日時 */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /** 削除フラグ */
    @Column(name = "delete_flg")
    private boolean deleteFlg;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        RoleEntity that = (RoleEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
