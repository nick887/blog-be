package icu.nickxiao.model.assembler;

import icu.nickxiao.model.dto.BlogDto;
import icu.nickxiao.model.entity.Blog;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-12T13:56:30+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.3 (AdoptOpenJDK)"
)
@Component
public class BlogStructKitImpl implements BlogStructKit {

    @Override
    public BlogDto toDto(Blog entity) {
        if ( entity == null ) {
            return null;
        }

        BlogDto blogDto = new BlogDto();

        blogDto.setId( entity.getId() );
        blogDto.setBody( entity.getBody() );
        blogDto.setLikes( entity.getLikes() );
        blogDto.setTopic( entity.getTopic() );
        blogDto.setVisitCount( entity.getVisitCount() );
        blogDto.setTitle( entity.getTitle() );
        blogDto.setCreated( entity.getCreated() );
        blogDto.setUpdated( entity.getUpdated() );
        blogDto.setDeleted( entity.getDeleted() );

        return blogDto;
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
        blog.setVisitCount( dto.getVisitCount() );
        blog.setTitle( dto.getTitle() );
        blog.setCreated( dto.getCreated() );
        blog.setUpdated( dto.getUpdated() );
        blog.setDeleted( dto.getDeleted() );
        blog.setBody( dto.getBody() );

        return blog;
    }
}
