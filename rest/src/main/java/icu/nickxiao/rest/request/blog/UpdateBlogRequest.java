package icu.nickxiao.rest.request.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlogRequest {
    @NotNull
    private Long id;
    @NotNull
    private String body;
    @NotNull
    private String topic;
    @NotNull
    private String title;
}
