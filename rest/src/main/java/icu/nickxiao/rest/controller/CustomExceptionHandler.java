package icu.nickxiao.rest.controller;

import icu.nickxiao.common.ErrorCodeEnum;
import icu.nickxiao.common.exception.BusinessException;
import icu.nickxiao.web.vo.ApiErrorResult;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {
    private final MessageSource messageSource;

    /**
     * 参数校验异常
     *
     * <p>@Valid、@RequestBody校验异常
     *
     * @param e 参数校验异常
     * @return ApiErrorResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {
            BindException.class,
            MethodArgumentNotValidException.class})
    public ApiErrorResult bindException(BindException e, Locale locale) {
        log.info("Validate parameter failed {}.", e.getBindingResult());
        final String errorMsg = e.getFieldErrors().stream().findFirst()
                .map(fieldError -> String.format("%s invalid", fieldError.getField()))
                .orElse(ErrorCodeEnum.PARAMETER_ERROR.name());
        return ApiErrorResult.newInstance(ErrorCodeEnum.PARAMETER_ERROR, errorMsg);
    }

    /**
     * shiro 授权异常
     *
     * <p>未携带token
     *
     * @param e 登录异常
     * @return ApiErrorResult
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException.class)
    public ApiErrorResult authorizationException(AuthorizationException e, Locale locale) {
        log.info("AuthorizationException");
        return ApiErrorResult.newInstance(ErrorCodeEnum.UNAUTHORIZED, this.messageSource, locale);
    }

    /**
     * shiro 认证异常
     *
     * <p>token无效，或权限不足
     *
     * @param e 权限异常
     * @return ApiErrorResult
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthenticationException.class)
    public ApiErrorResult authenticationException(AuthenticationException e, Locale locale) {
        log.info("AuthenticationException");
        return ApiErrorResult.newInstance(ErrorCodeEnum.FORBIDDEN, this.messageSource, locale);
    }

    /**
     * 业务异常
     *
     * @param e      business exception
     * @param locale 本地化
     * @return ApiErrorResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ApiErrorResult businessException(BusinessException e, Locale locale) {
        return ApiErrorResult.newInstance(e.getErrorCode(), this.messageSource, locale, e.getArgs());
    }

    /**
     * 其它客户端异常
     *
     * @param e       参数校验异常
     * @param request 请求
     * @return ApiErrorResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {
            MissingServletRequestParameterException.class,
            ServletRequestBindingException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestPartException.class,
            ConstraintViolationException.class})
    public ApiErrorResult clientException(Exception e, HttpServletRequest request) {
        log.info("Validate parameter failed. method: {} path: {}  params:{} msg:{}",
                request.getMethod(), request.getRequestURI(), request.getParameterMap(), e.getMessage(), e);

        return ApiErrorResult.newInstance(ErrorCodeEnum.PARAMETER_ERROR);
    }

    /**
     * 系统内部异常
     *
     * @param e 参数校验异常
     * @return ApiErrorResult
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiErrorResult unknownException(Exception e, HttpServletRequest request) {
        log.info("Unknown error. method: {} path: {}  params:{} msg:{}",
                request.getMethod(), request.getRequestURI(), request.getParameterMap(), e.getMessage(), e);
        return ApiErrorResult.newInstance(ErrorCodeEnum.INTERNAL_EXCEPTION);
    }
}
