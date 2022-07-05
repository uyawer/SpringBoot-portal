/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.validation;

import com.uyawer.portal.validation.anotation.CheckDateFormat;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDateFormatValidator implements ConstraintValidator<CheckDateFormat, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        try {
            LocalDate.parse(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}