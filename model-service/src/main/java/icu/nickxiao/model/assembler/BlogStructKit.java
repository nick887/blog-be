package icu.nickxiao.model.assembler;

import icu.nickxiao.model.dto.BlogDto;
import icu.nickxiao.model.entity.Blog;

import org.mapstruct.Mapper;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Mapper(componentModel = "spring")
public interface BlogStructKit {
    BlogDto toDto(Blog entity);

    Blog toEntity(BlogDto dto);
}
