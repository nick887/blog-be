package icu.nickxiao.rest.biz;

import icu.nickxiao.rest.request.blog.AddBlogRequest;
import icu.nickxiao.rest.request.blog.BlogRequest;
import icu.nickxiao.rest.request.blog.DeleteBlogRequest;
import icu.nickxiao.rest.request.blog.UpdateBlogRequest;
import icu.nickxiao.rest.vo.blog.BlogVO;
import icu.nickxiao.rest.vo.blog.BlogsVO;

/**
 * @author nick
 * @version 1.0, 2021/12/12
 * @since 1.0.0
 */
public interface IBlogBizService {
    BlogsVO blogs(BlogRequest request);

    void add(AddBlogRequest request);

    void update(UpdateBlogRequest request);

    void delete(DeleteBlogRequest request);

    BlogVO blog(Long id);
}
