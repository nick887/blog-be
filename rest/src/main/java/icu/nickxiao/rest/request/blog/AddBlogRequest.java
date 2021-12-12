package icu.nickxiao.rest.request.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddBlogRequest {
    @NotNull
    private String body;
    @NotNull
    private String topic;
    @NotNull
    private String title;
}
