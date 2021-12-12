package icu.nickxiao.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {
    /** 超时 */
    TIMEOUT(2),
    /** 参数错误 */
    PARAMETER_ERROR(400),
    /** 未授权 */
    UNAUTHORIZED(401),
    /** 权限被禁；授权失效等 */
    FORBIDDEN(403),
    /** 资源不存在 */
    NOT_FOUND(404),
    /** http method不被允许 */
    METHOD_NOT_ALLOWED(405),
    /** 服务繁忙 */
    SERVER_BUSY(429),
    /** 内部异常 */
    INTERNAL_EXCEPTION(500);

    /** 响应码 */
    int code;

    /** 获取i18n key */
    public String getI18nKey() {
        return String.format("error_code.%s", this.name().toLowerCase());
    }
}
