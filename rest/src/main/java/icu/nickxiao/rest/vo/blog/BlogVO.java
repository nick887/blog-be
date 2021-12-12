package icu.nickxiao.rest.vo.blog;

import icu.nickxiao.model.dto.BlogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogVO {
    private BlogDto blog;
}
