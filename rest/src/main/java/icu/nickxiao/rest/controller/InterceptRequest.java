package icu.nickxiao.rest.controller;

import icu.nickxiao.common.pojo.Constants;
import icu.nickxiao.model.dto.UserOperationLogDto;
import icu.nickxiao.model.service.IUserOperationLogModelService;
import java.io.IOException;
import java.lang.reflect.Type;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class InterceptRequest implements RequestBodyAdvice {
    private final IUserOperationLogModelService userOperationLogModelService;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @SneakyThrows
    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        ObjectMapper mapper = new ObjectMapper();
        String requestId = MDC.get(Constants.KEY_REQUEST_ID);
        Long requestIdL = Long.parseLong(requestId);
        String request = mapper.writeValueAsString(body);
        userOperationLogModelService.update(UserOperationLogDto.builder()
                .requestId(requestIdL)
                .requestBody(request.length() > 1024 ? request.substring(0, 1024) : request)
                .build());
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
