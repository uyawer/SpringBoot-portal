/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.model.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse {

    /** メッセージ */
    private String message;

    /** メッセージ詳細 */
    private String details;

    /** フィールドエラーリスト */
    private List<MethodArgumentNotValidResponse> notValidList;

    /** 発生日時 */
    private LocalDateTime timestamp;
}
