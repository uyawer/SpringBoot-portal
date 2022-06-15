package com.uyawer.portal.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
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
}
