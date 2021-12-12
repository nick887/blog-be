package icu.nickxiao.model.service.impl;

import icu.nickxiao.model.assembler.BlogStructKit;
import icu.nickxiao.model.dao.BlogDynamicSqlSupport;
import icu.nickxiao.model.dao.BlogMapper;
import icu.nickxiao.model.dto.BlogDto;
import icu.nickxiao.model.request.BlogQueryData;
import icu.nickxiao.model.service.IBlogModelService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.isNull;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Service
@RequiredArgsConstructor
public class BlogModelServiceImpl implements IBlogModelService {
    private final BlogMapper blogMapper;
    private final BlogStructKit blogStructKit;

    @Override
    public List<BlogDto> query(BlogQueryData query) {
        final QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder;
        builder = select(BlogDynamicSqlSupport.blog.allColumns()).from(BlogDynamicSqlSupport.blog).where();
        if (!query.isAll()) {
            builder.and(BlogDynamicSqlSupport.deleted, isNull());
        }
        builder.orderBy(BlogDynamicSqlSupport.updated);
        builder.limit(query.getLimit())
                .offset(query.getOffset());
        final SelectStatementProvider provider = builder.build()
                .render(RenderingStrategies.MYBATIS3);
        return blogMapper.selectMany(provider).stream().map(blogStructKit::toDto).collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return blogMapper.count(CountDSLCompleter.allRows());
    }
}
