package icu.nickxiao.rest.controller;

import icu.nickxiao.rest.biz.IBlogBizService;
import icu.nickxiao.rest.request.blog.AddBlogRequest;
import icu.nickxiao.rest.request.blog.BlogRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/")
    public BlogsVO blogs(BlogRequest request) {
        return blogBizService.blogs(request);
    }

    @GetMapping("/{id}")
    public BlogVO blog(@PathVariable Long id) {
        return blogBizService.blog(id);
    }

    @PostMapping("/add")
    public void add(AddBlogRequest request) {
        blogBizService.add(request);
    }

    @PostMapping("/update")
    public void update(UpdateBlogRequest request) {
        blogBizService.update(request);
    }

    @PostMapping("/delete")
    public void delete(DeleteBlogRequest request) {
        blogBizService.delete(request);
    }
}
