package icu.nickxiao.model.assembler;

import icu.nickxiao.model.dto.UserDto;
import icu.nickxiao.model.dto.UserOperationLogDto;
import icu.nickxiao.model.entity.User;
import icu.nickxiao.model.entity.UserOperationLog;

import org.mapstruct.Mapper;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */

@Mapper(componentModel = "spring")
public interface UserStructKit {
    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}
