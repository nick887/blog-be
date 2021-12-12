package icu.nickxiao.rest.controller;

import icu.nickxiao.common.pojo.Constants;
import icu.nickxiao.model.dto.UserOperationLogDto;
import icu.nickxiao.model.service.IUserOperationLogModelService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@RestControllerAdvice
@RequiredArgsConstructor
public class InterceptResponse implements ResponseBodyAdvice<Object> {

    private final IUserOperationLogModelService userOperationLogModelService;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @SneakyThrows
    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ObjectMapper mapper = new ObjectMapper();
        String requestId = MDC.get(Constants.KEY_REQUEST_ID);
        Long requestIdL = Long.parseLong(requestId);
        String response = mapper.writeValueAsString(body);
        System.out.println(response.length());
        userOperationLogModelService.update(UserOperationLogDto.builder()
                .requestId(requestIdL)
                .responseBody(response.length() > 1024 ? response.substring(0, 1024) : response)
                .build());
        return body;
    }
}
