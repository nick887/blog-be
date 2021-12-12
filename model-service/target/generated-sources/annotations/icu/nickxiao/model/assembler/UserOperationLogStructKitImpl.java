package icu.nickxiao.model.assembler;

import icu.nickxiao.model.dto.UserOperationLogDto;
import icu.nickxiao.model.entity.UserOperationLog;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-12T13:28:43+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.13 (Azul Systems, Inc.)"
)
@Component
public class UserOperationLogStructKitImpl implements UserOperationLogStructKit {

    @Override
    public UserOperationLog toEntity(UserOperationLogDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserOperationLog userOperationLog = new UserOperationLog();

        userOperationLog.setRequestId( dto.getRequestId() );
        userOperationLog.setMethod( dto.getMethod() );
        userOperationLog.setUserId( dto.getUserId() );
        userOperationLog.setStatus( dto.getStatus() );
        userOperationLog.setRequestBody( dto.getRequestBody() );
        userOperationLog.setResponseBody( dto.getResponseBody() );
        userOperationLog.setRequestParams( dto.getRequestParams() );

        return userOperationLog;
    }

    @Override
    public UserOperationLogDto toDto(UserOperationLog entity) {
        if ( entity == null ) {
            return null;
        }

        UserOperationLogDto userOperationLogDto = new UserOperationLogDto();

        userOperationLogDto.setRequestId( entity.getRequestId() );
        userOperationLogDto.setMethod( entity.getMethod() );
        userOperationLogDto.setRequestBody( entity.getRequestBody() );
        userOperationLogDto.setResponseBody( entity.getResponseBody() );
        userOperationLogDto.setUserId( entity.getUserId() );
        if ( entity.getStatus() != null ) {
            userOperationLogDto.setStatus( entity.getStatus() );
        }
        userOperationLogDto.setRequestParams( entity.getRequestParams() );

        return userOperationLogDto;
    }
}
