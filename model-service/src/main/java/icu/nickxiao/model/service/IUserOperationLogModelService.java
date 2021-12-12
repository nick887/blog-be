package icu.nickxiao.model.service;

import icu.nickxiao.model.dto.UserOperationLogDto;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
public interface IUserOperationLogModelService {

    /**
     * 增加记录
     *
     * @param dto dto
     * @return 条数
     */
    int add(UserOperationLogDto dto);

    /**
     * 更新
     *
     * @param dto dto
     * @return 条数
     */
    int update(UserOperationLogDto dto);
}
