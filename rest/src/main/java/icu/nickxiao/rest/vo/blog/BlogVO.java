package icu.nickxiao.rest.vo.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author nick
 * @version 1.0, 2021/12/12
 * @since 1.0.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogVO {
    private int total;
    private List<Blog>;
}
