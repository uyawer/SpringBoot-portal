/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.constants.type;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;

import lombok.Getter;

public enum BloodType {
    A("A型", 0),
    B("B型", 1),
    O("O型", 2),
    AB("AB型", 3),
    ;

    @Getter
    private final String label;

    @Getter
    private final Integer value;

    BloodType(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public static BloodType valueOf(Integer value) {
        return Arrays.stream(values())
            .filter(e -> e.value.equals(value))
            .findFirst()
            .orElse(null);
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BloodType stringValueOf(String value) {
        if (!NumberUtils.isDigits(value)) {
            return null;
        }
        return BloodType.valueOf(Integer.parseInt(value));
    }
}
