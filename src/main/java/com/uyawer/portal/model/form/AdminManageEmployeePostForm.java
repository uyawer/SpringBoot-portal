/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.model.form;

import com.uyawer.portal.constants.MessageConstants;
import com.uyawer.portal.constants.type.BloodType;
import com.uyawer.portal.constants.type.GenderType;
import com.uyawer.portal.helper.utils.DateUtils;
import com.uyawer.portal.validation.anotation.CheckDateFormat;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AdminManageEmployeePostForm {

    /** 社員番号 */
    @NotBlank(message = MessageConstants.ERR_MSG_REQUIRED_INPUT_TEXT_FIELDS)
    private String number;

    /** ログインID */
    @NotBlank(message = MessageConstants.ERR_MSG_REQUIRED_INPUT_TEXT_FIELDS)
    private String loginId;

    /** 名字 */
    @NotBlank(message = MessageConstants.ERR_MSG_REQUIRED_INPUT_TEXT_FIELDS)
    private String lastName;

    /** 名前 */
    @NotBlank(message = MessageConstants.ERR_MSG_REQUIRED_INPUT_TEXT_FIELDS)
    private String firstName;

    /** 名字カナ */
    @NotBlank(message = MessageConstants.ERR_MSG_REQUIRED_INPUT_TEXT_FIELDS)
    private String lastNameKana;

    /** 名前カナ */
    @NotBlank(message = MessageConstants.ERR_MSG_REQUIRED_INPUT_TEXT_FIELDS)
    private String firstNameKana;

    /** 生年月日 */
    @CheckDateFormat(message = MessageConstants.ERR_MSG_INPUT_FORMAT_INVALID)
    private String birthday;

    /** 性別 */
    @NotNull(message = MessageConstants.ERR_MSG_REQUIRED_SELECT_FIELDS)
    private GenderType gender;

    /** 血液型 */
    @NotNull(message = MessageConstants.ERR_MSG_REQUIRED_SELECT_FIELDS)
    private BloodType blood;

    /** 出身地 */
    private String birthplace;

    public LocalDate getBirthdayToLocalDate() {
        return DateUtils.toLocalDate(birthday);
    }
}
