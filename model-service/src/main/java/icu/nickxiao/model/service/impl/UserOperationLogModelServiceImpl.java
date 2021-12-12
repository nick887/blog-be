package icu.nickxiao.model.service.impl;

import icu.nickxiao.model.assembler.UserOperationLogStructKit;
import icu.nickxiao.model.dao.UserOperationLogMapper;
import icu.nickxiao.model.dto.UserOperationLogDto;
import icu.nickxiao.model.entity.UserOperationLog;
import icu.nickxiao.model.service.IUserOperationLogModelService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Service
@RequiredArgsConstructor
public class UserOperationLogModelServiceImpl implements IUserOperationLogModelService {

    private final UserOperationLogStructKit userOperationLogStructKit;

    private final UserOperationLogMapper userOperationLogMapper;

    @Override
    public int add(UserOperationLogDto dto) {
        UserOperationLog entity = userOperationLogStructKit.toEntity(dto);
        return userOperationLogMapper.insertSelective(entity);
    }

    @Override
    public int update(UserOperationLogDto dto) {
        UserOperationLog entity = userOperationLogStructKit.toEntity(dto);
        return this.userOperationLogMapper.updateByPrimaryKeySelective(entity);
    }
}
