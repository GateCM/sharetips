/**
 * 
 */
package com.gatecm.tip.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gatecm.tip.constant.ErrorEnum;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO(全局异常处理)
 * @author chenxiaohui
 * @date 2017年12月10日 下午1:35:38
 *
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * bean校验未通过异常
	 *
	 * @see javax.validation.Valid
	 * @see org.springframework.validation.Validator
	 * @see org.springframework.validation.DataBinder
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public MethodParameter validExceptionHandler(MethodArgumentNotValidException e) {
		return e.getParameter();
	}

	/**
	 * 所有异常报错
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public ErrorEnum allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		exception.printStackTrace();
		return ErrorEnum.SYS_EXCEPTION;
	}

}
