package icu.nickxiao.common.pojo;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {
    /** 唯一id */
    private long id;
    /** 邮箱 */
    private String email;
    /** 昵称 */
    private String nickname;
    /** 状态 */
    private UserStatusEnum status;
    /** 角色 */
    private Set<String> roles;
    /** 权限 */
    private Set<String> permissions;
}
