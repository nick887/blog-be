package icu.nickxiao.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOperationLogDto {
    private Long requestId;
    private String method;
    private String requestBody;
    private String responseBody;
    private Long userId;
    private int status;
    private String requestParams;
    private String url;
}
