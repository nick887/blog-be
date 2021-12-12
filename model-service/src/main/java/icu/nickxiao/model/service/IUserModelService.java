package icu.nickxiao.model.service;

import icu.nickxiao.model.dto.UserDto;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
public interface IUserModelService {
    UserDto find(String email);
}
