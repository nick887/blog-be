package icu.nickxiao.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nick
 * @version 1.0, 2021/12/12
 * @since 1.0.0
 */
@RequestMapping("/")
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "welcome to nick blog!";
    }
}
