package icu.nickxiao.rest.biz.impl;

import icu.nickxiao.model.assembler.BlogStructKit;
import icu.nickxiao.model.dao.BlogMapper;
import icu.nickxiao.model.dto.BlogDto;
import icu.nickxiao.model.request.BlogQueryData;
import icu.nickxiao.model.service.IBlogModelService;
import icu.nickxiao.rest.biz.IBlogBizService;
import icu.nickxiao.rest.request.blog.AddBlogRequest;
import icu.nickxiao.rest.request.blog.BlogRequest;
import icu.nickxiao.rest.request.blog.DeleteBlogRequest;
import icu.nickxiao.rest.request.blog.UpdateBlogRequest;
import icu.nickxiao.rest.vo.blog.BlogVO;
import icu.nickxiao.rest.vo.blog.BlogsVO;
import icu.nickxiao.util.UidGeneratorUtil;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Service
@RequiredArgsConstructor
public class BlogBizServiceImpl implements IBlogBizService {
    private final RedissonClient redisson;
    private final IBlogModelService blogModelService;
    private final BlogMapper blogMapper;

    private final BlogStructKit blogStructKit;

    @Override
    public BlogsVO blogs(BlogRequest request) {
        List<BlogDto> blogs = blogModelService.query(BlogQueryData.builder()
                .limit(request.getLimit())
                .offset(request.getOffset())
                .all(false)
                .build());
        Long total = blogModelService.count();

        return BlogsVO.builder()
                .blogs(blogs)
                .total(total)
                .build();
    }

    @Override
    public void add(AddBlogRequest request) {
        blogMapper.insertSelective(blogStructKit.toEntity(BlogDto.builder()
                .id(UidGeneratorUtil.generateUid())
                .body(request.getBody())
                .title(request.getTitle())
                .topic(request.getTopic())
                .build()));
    }

    @Override
    public void update(UpdateBlogRequest request) {
        blogMapper.updateByPrimaryKeySelective(blogStructKit.toEntity(BlogDto.builder()
                .id(request.getId())
                .topic(request.getTopic())
                .title(request.getTitle())
                .body(request.getBody())
                .build()));
    }

    @Override
    public void delete(DeleteBlogRequest request) {
        blogMapper.updateByPrimaryKeySelective(blogStructKit.toEntity(BlogDto.builder()
                .id(request.getId())
                .deleted(LocalDateTime.now())
                .build()));
    }

    @Override
    public BlogVO blog(Long id) {
        return BlogVO.builder()
                .blog(blogMapper.selectByPrimaryKey(id).map(blogStructKit::toDto).get())
                .build();
    }
}
