package icu.nickxiao.rest.biz.impl;

import icu.nickxiao.common.ErrorCodeEnum;
import icu.nickxiao.common.exception.BusinessException;
import icu.nickxiao.common.pojo.CommonConfig;
import icu.nickxiao.model.dto.UserDto;
import icu.nickxiao.model.service.IUserModelService;
import icu.nickxiao.rest.biz.IUserBizService;
import icu.nickxiao.rest.request.user.SignInRequest;
import icu.nickxiao.rest.vo.user.SignInVO;
import icu.nickxiao.web.util.Claims;
import icu.nickxiao.web.util.JwtUtil;
import java.time.Duration;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Service
@RequiredArgsConstructor
public class UserBizServiceImpl implements IUserBizService {
    private final IUserModelService userModelService;

    private final CommonConfig commonConfig;

    @Override
    public SignInVO signIn(SignInRequest request) {
        System.out.println(request);
        UserDto user = userModelService.find(request.getEmail());
        if (user.getPassword().equals(request.getPassword())) {
            return SignInVO.builder()
                    .token(JwtUtil.sign(Claims.builder()
                                    .role(user.getRole())
                                    .id(user.getId().toString()).build(),
                            commonConfig.getSecretKey(),
                            Duration.ofHours(commonConfig.getJwtTokenExpireHours()))
                    )
                    .build();
        } else {
            throw new BusinessException(ErrorCodeEnum.FORBIDDEN);
        }
    }
}
