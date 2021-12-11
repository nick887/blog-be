package icu.nickxiao.rest.controller;

import icu.nickxiao.rest.request.blog.BlogRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nick
 * @version 1.0, 2021/12/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @GetMapping("/")
    public ResponseEntity<Object> getBlogPaged(BlogRequest request){
        List<Blog> blogs = blogService.queryBlogPaged(pageNum, pageSize);
        Map<Object,Object> map=new HashMap<>();
        PageInfo pageInfo=new PageInfo(blogs);
        map.put("total",pageInfo.getTotal());
        map.put("data",blogs);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
