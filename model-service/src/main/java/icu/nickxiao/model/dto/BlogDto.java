package icu.nickxiao.model.dto;

import java.time.LocalDateTime;
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
public class BlogDto {
    Long id;
    String body;
    Long likes;
    String topic;
    Long visit_count;
    String title;
    LocalDateTime created;
    LocalDateTime updated;
    LocalDateTime deleted;
}
