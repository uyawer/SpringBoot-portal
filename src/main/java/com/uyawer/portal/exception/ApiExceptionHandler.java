/*
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.exception;

import com.google.common.collect.Lists;
import com.uyawer.portal.helper.utils.DateUtils;
import com.uyawer.portal.model.response.ApiExceptionResponse;
import com.uyawer.portal.model.response.MethodArgumentNotValidResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 例外処理を行うハンドラークラス
 */
@ControllerAdvice
@RestController
public class ApiExceptionHandler {

    /**
     * APIのURLが不正な場合のエラー処理を行う
     *
     * @param ex MethodArgumentTypeMismatch例外
     * @return レスポンスエンティティオブジェクト
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiExceptionResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ApiExceptionResponse exceptionResponse = new ApiExceptionResponse(
            ex.getMessage(),
            getStackTraceLog(ex.getStackTrace()),
            Lists.newArrayList(),
            DateUtils.getLocalDateTimeNow()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * クラスのチェック処理でエラーになった場合の処理を行う
     *
     * @param ex MethodArgumentNotValid例外
     * @return レスポンスエンティティオブジェクト
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ApiExceptionResponse exceptionResponse = getMethodArgumentNotValidExceptionMsg(ex);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * スタックトレースログの文字列を取得する
     *
     * @param stackArray StackTraceElement配列
     * @return スタックトレースログの文字列
     */
    private String getStackTraceLog(StackTraceElement[] stackArray) {
        return Arrays.stream(stackArray)
            .map(element -> String.format("%s;", element))
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
    }

    /**
     * MethodArgumentNotValid例外からエラーメッセージを生成する
     *
     * @param ex MethodArgumentNotValid例外
     * @return エラーメッセージ
     */
    private ApiExceptionResponse getMethodArgumentNotValidExceptionMsg(MethodArgumentNotValidException ex) {
        List<MethodArgumentNotValidResponse> messageList = Lists.newArrayList();
        LocalDateTime now = DateUtils.getLocalDateTimeNow();

        for (FieldError err : ex.getFieldErrors()) {
            MethodArgumentNotValidResponse message = new MethodArgumentNotValidResponse(
                err.getObjectName(),
                err.getField(),
                err.getDefaultMessage()
            );
            messageList.add(message);
        }

        return new ApiExceptionResponse(
            StringUtils.EMPTY,
            StringUtils.EMPTY,
            messageList,
            now
        );
    }
}
