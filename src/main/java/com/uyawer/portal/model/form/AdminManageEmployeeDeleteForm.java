package com.uyawer.portal.model.form;

import lombok.Data;

@Data
public class AdminManageEmployeeDeleteForm {

    /** 削除対象の従業員ID */
    private Long deleteEmployeeId;
}
