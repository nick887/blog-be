package icu.nickxiao.rest.request;

import icu.nickxiao.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * @author nick
 * @version 1.0, 2021/12/12
 * @since 1.0.0
 */
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageRequest {

    /** 偏移 */
    @Min(0)
    private int offset = 0;

    /** 条数限制 */
    @Max(100)
    @Min(1)
    @Builder.Default
    private int limit = Constants.DEFAULT_LIMIT;

}