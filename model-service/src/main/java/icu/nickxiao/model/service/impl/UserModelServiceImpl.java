package icu.nickxiao.model.service.impl;

import icu.nickxiao.model.assembler.UserStructKit;
import icu.nickxiao.model.dao.UserDynamicSqlSupport;
import icu.nickxiao.model.dao.UserMapper;
import icu.nickxiao.model.dto.UserDto;
import icu.nickxiao.model.service.IUserModelService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Service
@RequiredArgsConstructor
public class UserModelServiceImpl implements IUserModelService {
    private final UserMapper userMapper;
    private final UserStructKit userStructKit;

    @Override
    public UserDto find(String email) {
        return userMapper.selectOne(c ->
                        c.where(UserDynamicSqlSupport.email, isEqualTo(email)))
                .map(userStructKit::toDto).get();
    }
}
