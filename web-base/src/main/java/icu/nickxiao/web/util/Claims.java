package icu.nickxiao.web.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Claims {

    /** user id */
    private String id;
    /** user role */
    private String role;

}
