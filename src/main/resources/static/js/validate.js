/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

/**
 * 入力必須項目で入力されているか
 * @param inputTextField inputフィールドのDOM要素
 * @param errorField inputフィールドのエラーのDOM要素
 */
function validRequiredTextField(inputTextField, errorField) {
  console.log(inputTextField)
  if (!!inputTextField.val()) {
    inputTextField.removeClass('is-invalid')
    errorField.text('')
  } else {
    inputTextField.addClass('is-invalid')
    errorField.text('必須項目が入力されていません')
  }
}

/**
 * 選択必須項目で選択されているか
 * @param selectField selectフィールドのDOM要素
 * @param errorField inputフィールドのエラーのDOM要素
 */
function validRequiredSelectField(selectField, errorField) {
  if (!!selectField.val()) {
    selectField.removeClass('is-invalid')
    errorField.text('')
  } else {
    selectField.addClass('is-invalid')
    errorField.text('必須項目が選択されていません')
  }
}

function validRequiredDateField(dateField, errorField) {
  const regex = /^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])$/;
  const res = !!dateField.val() && regex.test(dateField.val())
  if (res) {
    dateField.removeClass('is-invalid')
    errorField.text('')
  } else {
    dateField.addClass('is-invalid')
    errorField.text('入力形式が正しくありません')
  }
}
