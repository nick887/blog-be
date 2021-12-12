package icu.nickxiao.web.vo;

import icu.nickxiao.common.ErrorCodeEnum;
import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.context.MessageSource;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Getter
@AllArgsConstructor
public class ApiErrorResult {
    private final int errorCode;
    private final String errorMsg;

    /**
     * 默认返回
     *
     * @param errorCode 错误码
     * @return ApiErrorResult
     */
    public static ApiErrorResult newInstance(ErrorCodeEnum errorCode) {
        return new ApiErrorResult(errorCode.getCode(), errorCode.name());
    }

    /**
     * 指定错误码，错误提示信息
     *
     * @param errorCode 错误码
     * @param errorMsg  提示信息
     * @return ApiErrorResult
     */
    public static ApiErrorResult newInstance(ErrorCodeEnum errorCode, String errorMsg) {
        return new ApiErrorResult(errorCode.getCode(), errorMsg);
    }

    /**
     * 带i18n的错误返回
     *
     * @param errorCode     错误码
     * @param messageSource i18n messageSource
     * @param locale        语言
     * @return ApiErrorResult
     */
    public static ApiErrorResult newInstance(ErrorCodeEnum errorCode, MessageSource messageSource, Locale locale) {
        return newInstance(errorCode, messageSource, locale, null);
    }

    /**
     * 带i18n的错误返回
     *
     * <p>含参数
     *
     * @param errorCode     错误码
     * @param messageSource i18n messageSource
     * @param locale        语言
     * @param args          参数
     * @return ApiErrorResult
     */
    public static ApiErrorResult newInstance(ErrorCodeEnum errorCode, MessageSource messageSource, Locale locale, Object[] args) {
        return new ApiErrorResult(errorCode.getCode(), messageSource.getMessage(errorCode.getI18nKey(), args, locale));
    }
}
