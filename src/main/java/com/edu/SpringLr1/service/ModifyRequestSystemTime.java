package com.edu.SpringLr1.service;

import com.edu.SpringLr1.model.Request;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;

public class ModifyRequestSystemTime implements ModifyRequestService {
    @Override
    public void modifyRq(Request request) {
        request.setSystemTime("test");
        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        new RestTemplate().exchange("http://localhost:8082/feedback",
            HttpMethod.POST,
            httpEntity,
            new ParameterizedTypeReference<>() {

            });
    }
}
