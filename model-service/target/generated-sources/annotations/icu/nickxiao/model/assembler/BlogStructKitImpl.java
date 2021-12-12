package icu.nickxiao.model.assembler;

import icu.nickxiao.model.dto.BlogDto;
import icu.nickxiao.model.dto.BlogDto.BlogDtoBuilder;
import icu.nickxiao.model.entity.Blog;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-12T13:29:06+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.13 (Azul Systems, Inc.)"
)
@Component
public class BlogStructKitImpl implements BlogStructKit {

    @Override
    public BlogDto toDto(Blog entity) {
        if ( entity == null ) {
            return null;
        }

        BlogDtoBuilder blogDto = BlogDto.builder();

        blogDto.id( entity.getId() );
        blogDto.body( entity.getBody() );
        blogDto.likes( entity.getLikes() );
        blogDto.topic( entity.getTopic() );
        blogDto.title( entity.getTitle() );
        blogDto.created( entity.getCreated() );
        blogDto.updated( entity.getUpdated() );
        blogDto.deleted( entity.getDeleted() );

        return blogDto.build();
    }

    @Override
    public Blog toEntity(BlogDto dto) {
        if ( dto == null ) {
            return null;
        }

        Blog blog = new Blog();

        blog.setId( dto.getId() );
        blog.setLikes( dto.getLikes() );
        blog.setTopic( dto.getTopic() );
        blog.setTitle( dto.getTitle() );
        blog.setCreated( dto.getCreated() );
        blog.setUpdated( dto.getUpdated() );
        blog.setDeleted( dto.getDeleted() );
        blog.setBody( dto.getBody() );

        return blog;
    }
}
