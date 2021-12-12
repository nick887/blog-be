package icu.nickxiao.common.exception;

import icu.nickxiao.common.ErrorCodeEnum;
import lombok.Getter;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Getter
public class BusinessException extends RuntimeException {
    /** 错误码 */
    private final ErrorCodeEnum errorCode;
    /** i18n参数 */
    private final Object[] args;

    /**
     * 构造方法
     *
     * @param errorCode 错误码
     * @param args      i18n参数
     */
    public BusinessException(ErrorCodeEnum errorCode, Object... args) {
        super(errorCode.getCode() + "," + errorCode.name(), null, true, false);
        this.errorCode = errorCode;
        this.args = args;
    }
}
