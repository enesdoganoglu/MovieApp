package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {
    /*
        General errors.
     */
    INVALID_PARAMETER(5000,"Parametreler geçersizdir.", BAD_REQUEST),
    USERNAME_NOT_FOUND(5001,"Kullanıcı bulunamadı.", INTERNAL_SERVER_ERROR),
    METHOD_MIS_MATCH_ERROR(5002,"Yanlış kullanıcı adı veya şifre", BAD_REQUEST),
    /*
        Validation errors.
     */
    METHOD_NOT_VALID_ARGUMENT_ERROR(4000,"Method tipi yanlıştır.",BAD_REQUEST),

    /*
        Register errors.
     */
    REGISTER_ERROR_DATA_EXISTS(3000, "Data already exists.", BAD_REQUEST),

    /*
        Authentication errors.
     */
    LOGIN_ERROR_USERNAME_DOES_NOT_EXIST(2001, "Kullanıcı adı bulunamadı.", NOT_FOUND),
    LOGIN_ERROR_WRONG_PASSWORD(2002, "Şifre yanlış", BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
