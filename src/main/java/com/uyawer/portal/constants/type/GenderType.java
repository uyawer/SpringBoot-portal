/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.constants.type;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;

import lombok.Getter;

public enum GenderType {
    Mem("男性", 0),
    Women("女性", 1),
    ;

    @Getter
    private final String label;

    @Getter
    private final Integer value;

    GenderType(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public static GenderType valueOf(Integer value) {
        return Arrays.stream(values())
            .filter(e -> e.value.equals(value))
            .findFirst()
            .orElse(null);
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static GenderType stringValueOf(String value) {
        if (!NumberUtils.isDigits(value)) {
            return null;
        }
        return GenderType.valueOf(Integer.parseInt(value));
    }
}
