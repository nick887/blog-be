package icu.nickxiao.rest.controller;

import icu.nickxiao.rest.biz.IUserBizService;
import icu.nickxiao.rest.request.user.SignInRequest;
import icu.nickxiao.rest.vo.user.SignInVO;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserBizService userBizService;

    @PostMapping("/signIn")
    public SignInVO signIn(@RequestBody SignInRequest request) {
        return userBizService.signIn(request);
    }
}
