package icu.nickxiao.common.pojo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author nick
 * @version 1.0, 2021/12/12
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final int DEFAULT_LIMIT = 20;
    /** jwt claim userId key */
    public static final String USER_ID = "id";

    /** shiro judge role字段 */
    public static final String SHIRO_ROLE_JUDGE = "JUDGE";
    /** shiro admin role字段 */
    public static final String SHIRO_ROLE_ADMIN = "ADMIN";
    /** shiro user role字段 */
    public static final String SHIRO_ROLE_USER = "USER";
    /** jwt claim role key */
    public static final String ROLE = "role";

    /** shiro attribute auth user */
    public static final String SHIRO_ATTRIBUTE_AUTH_USER = "auth_user";

    /** requestId key */
    public static final String KEY_REQUEST_ID = "X-Request-Id";
}
