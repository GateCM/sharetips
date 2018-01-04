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
import com.gatecm.tip.service.Rrs;

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
	 * 所有异常报错
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public Rrs allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		exception.printStackTrace();
		return new Rrs(false, ErrorEnum.SYS_EXCEPTION);
	}

}
