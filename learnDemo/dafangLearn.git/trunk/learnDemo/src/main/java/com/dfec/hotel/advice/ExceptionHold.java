package com.dfec.hotel.advice;

import com.baomidou.mybatisplus.extension.api.R;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ExceptionHold {
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public R handleResourceException(SQLIntegrityConstraintViolationException e){
        String message = e.getMessage();
        int errorCode = e.getErrorCode();
        return R.failed(message).setCode(errorCode);
    }
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R handleResourceException(Exception e){
        return R.failed(e.getMessage()).setCode(-4);
    }
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public R handleAuthException(UnauthorizedException e){
        return  R.failed(e.getMessage()).setCode(1066);
    }
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public R handleAuthException(AuthorizationException e){
        return  R.failed(e.getMessage()).setCode(1066);
    }
}
