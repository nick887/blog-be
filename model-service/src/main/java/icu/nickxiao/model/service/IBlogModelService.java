package icu.nickxiao.model.service;

import icu.nickxiao.model.dto.BlogDto;
import icu.nickxiao.model.request.BlogQueryData;
import java.util.List;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
public interface IBlogModelService {
    List<BlogDto> query(BlogQueryData query);

    Long count();
}
