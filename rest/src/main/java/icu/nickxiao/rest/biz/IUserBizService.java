package icu.nickxiao.rest.biz;

import icu.nickxiao.rest.request.user.SignInRequest;
import icu.nickxiao.rest.vo.user.SignInVO;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
public interface IUserBizService {
    SignInVO signIn(SignInRequest request);
}
