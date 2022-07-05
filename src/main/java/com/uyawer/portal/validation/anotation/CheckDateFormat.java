/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.validation.anotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.uyawer.portal.validation.CheckDateFormatValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CheckDateFormatValidator.class})
public @interface CheckDateFormat {

    String message() default "{com.uyawer.portal.validation.CheckDateFormat.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({FIELD})
    @Retention(RUNTIME)
    @interface List {

        CheckDateFormat[] value();
    }
}
