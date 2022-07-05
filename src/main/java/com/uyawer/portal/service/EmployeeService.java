/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.service;

import com.uyawer.portal.model.entity.EmployeeEntity;
import com.uyawer.portal.model.form.AdminManageEmployeePostForm;
import com.uyawer.portal.model.form.AdminManageEmployeePutForm;

import java.util.List;

public interface EmployeeService {

    /**
     * 有効な従業員情報を全て取得する
     *
     * @return 従業員情報のリスト
     */
    List<EmployeeEntity> findAll();

    /**
     * 指定したIDの従業員情報を取得する
     *
     * @param id 従業員情報のID
     * @return 従業員情報
     */
    EmployeeEntity findById(
        Long id
    );

    /**
     * 従業員情報を登録する
     *
     * @param form 入力情報
     * @return 従業員情報
     */
    EmployeeEntity register(
        AdminManageEmployeePostForm form
    );

    /**
     * 指定したIDの従業員情報を更新する
     *
     * @param id 従業員情報のID
     * @param form 入力情報
     * @return 従業員情報
     */
    EmployeeEntity update(
        Long id,
        AdminManageEmployeePutForm form
    );

    /**
     * 指定したIDの従業員情報の削除フラグを有効にする
     *
     * @param id 従業員情報のID
     */
    void delete(
        Long id
    );
}
