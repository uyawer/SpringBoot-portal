/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.constants.type;

/** 権限区分 */
public enum RoleType {

    GUEST, // ゲスト(BPなど)
    GENERAL, // 社員
    MANAGER, // マネージャー
    ADMIN, // 管理者
    ;

    public String getRoleName() {
        return "ROLE_" + name();
    }
}
