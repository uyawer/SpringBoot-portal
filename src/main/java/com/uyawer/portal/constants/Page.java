package com.uyawer.portal.constants;

/** thymeleafファイルのパスをまとめた定義クラス */
public class Page {

    /** ダッシュボード */
    public static String DASHBOARD = "dashboard";

    /** 従業員: 登録情報確認 */
    public static String EMPLOYEE = "employee/index";

    /** 従業員: 登録情報編集 */
    public static String EMPLOYEE_EDIT = "employee/edit";

    /** 従業員: パスワード変更 */
    public static String EMPLOYEE_PASSWORD = "employee/password";

    /** 管理者: 部署管理 */
    public static String ADMIN_MANAGE_DEPARTMENTS = "admin/manage/departments/index";

    /** 管理者: 部署管理: 登録 */
    public static String ADMIN_MANAGE_DEPARTMENTS_REGISTER = "admin/manage/departments/register";

    /** 管理者: 部署管理: 編集 */
    public static String ADMIN_MANAGE_DEPARTMENTS_EDIT = "admin/manage/departments/edit";

    /** 管理者: 従業員管理 */
    public static String ADMIN_MANAGE_EMPLOYEES = "admin/manage/employees/index";

    /** 管理者: 従業員管理: 登録 */
    public static String ADMIN_MANAGE_EMPLOYEES_REGISTER = "admin/manage/employees/register";

    /** 管理者: 従業員管理: 編集 */
    public static String ADMIN_MANAGE_EMPLOYEES_EDIT = "admin/manage/employees/edit";
}
