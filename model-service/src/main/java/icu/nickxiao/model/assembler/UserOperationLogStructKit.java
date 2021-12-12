package icu.nickxiao.model.assembler;

import icu.nickxiao.model.dto.UserOperationLogDto;
import icu.nickxiao.model.entity.UserOperationLog;

import org.mapstruct.Mapper;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Mapper(componentModel = "spring")
public interface UserOperationLogStructKit {
    UserOperationLog toEntity(UserOperationLogDto dto);
    UserOperationLogDto toDto(UserOperationLog entity);
}
