package icu.nickxiao.rest.vo.blog;

import icu.nickxiao.model.dto.BlogDto;
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
public class BlogsVO {
    private Long total;
    private List<BlogDto> blogs;
}
