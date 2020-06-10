package com.berg.exception;

import com.berg.message.MessageConstant;
import com.berg.message.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex) {
		Result r;
		if(ex instanceof AppException){
			AppException e = (AppException)ex;
			r = new Result(e.getErrorCode(), e.getErrorMsg(),null);
			log.error(e.getErrorMsg());
		}else if(ex instanceof MethodArgumentNotValidException){
			log.error("请求参数错误",ex);
			MethodArgumentNotValidException e = (MethodArgumentNotValidException)ex;
			String errMsg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
			r = new Result(MessageConstant.PARAMETER_ERROR_CODE, errMsg,null);
		}else if(ex instanceof AuthenticationException){
			log.error("授权错误",ex);
			AuthenticationException e = (AuthenticationException)ex;
			String errMsg = e.getMessage();
			r = new Result(MessageConstant.UNAUTH_ERROR_CODE, errMsg,null);
		}else if (ex instanceof UnauthorizedException){
			log.error("授权错误",ex);
			UnauthorizedException e = (UnauthorizedException)ex;
			r = new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE, "您没有对应的权限操作，请联系管理员授权",null);
		}
		else{
			log.error("运行异常",ex);
			r = new Result(MessageConstant.SYSTEM_ERROR_CODE,"运行异常",ex.getMessage());
		}
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}
}
