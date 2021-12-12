package icu.nickxiao.rest.controller;

import icu.nickxiao.rest.biz.IBlogBizService;
import icu.nickxiao.rest.request.blog.AddBlogRequest;
import icu.nickxiao.rest.request.blog.BlogRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import icu.nickxiao.rest.request.blog.DeleteBlogRequest;
import icu.nickxiao.rest.request.blog.UpdateBlogRequest;
import icu.nickxiao.rest.vo.blog.BlogVO;
import icu.nickxiao.rest.vo.blog.BlogsVO;

import lombok.RequiredArgsConstructor;

/**
 * @author nick
 * @version 1.0, 2021/12/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
    private final IBlogBizService blogBizService;

    @PostMapping("")
    public BlogsVO blogs(@RequestBody BlogRequest request) {
        return blogBizService.blogs(request);
    }

    @GetMapping("/{id}")
    public BlogVO blog(@PathVariable Long id) {
        System.out.println(id);
        return blogBizService.blog(id);
    }

    @PostMapping("/add")
    @RequiresAuthentication
    public void add(@RequestBody AddBlogRequest request) {
        blogBizService.add(request);
    }

    @PostMapping("/update")
    @RequiresAuthentication
    public void update(@RequestBody UpdateBlogRequest request) {
        blogBizService.update(request);
    }

    @PostMapping("/delete")
    @RequiresAuthentication
    public void delete(@RequestBody DeleteBlogRequest request) {
        blogBizService.delete(request);
    }
}
