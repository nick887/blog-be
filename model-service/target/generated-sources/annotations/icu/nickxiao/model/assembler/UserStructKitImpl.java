package icu.nickxiao.model.assembler;

import icu.nickxiao.model.dto.UserDto;
import icu.nickxiao.model.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-12T17:47:42+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.13 (Azul Systems, Inc.)"
)
@Component
public class UserStructKitImpl implements UserStructKit {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setEmail( dto.getEmail() );
        user.setNickname( dto.getNickname() );
        user.setStatus( dto.getStatus() );
        user.setRole( dto.getRole() );
        user.setPassword( dto.getPassword() );
        user.setCreated( dto.getCreated() );
        user.setUpdated( dto.getUpdated() );

        return user;
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setEmail( entity.getEmail() );
        userDto.setNickname( entity.getNickname() );
        userDto.setStatus( entity.getStatus() );
        userDto.setRole( entity.getRole() );
        userDto.setPassword( entity.getPassword() );
        userDto.setCreated( entity.getCreated() );
        userDto.setUpdated( entity.getUpdated() );

        return userDto;
    }
}
