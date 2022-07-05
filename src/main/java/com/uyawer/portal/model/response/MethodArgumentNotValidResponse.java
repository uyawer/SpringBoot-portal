/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MethodArgumentNotValidResponse {

    /** オブジェクト名 */
    private String objectName;

    /** フィールド名 */
    private String fieldName;

    /** メッセージ */
    private String message;
}
