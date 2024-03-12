package com.example.demo.service.api.utils;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.IOException;

@Component
public class APIHandler {
    private final RestTemplate restTemplate;

    public APIHandler(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://jsonplaceholder.typicode.com"));
    }

    public <T, R> ResponseEntity<R> callAPI(
            String apiEndpoint,
            HttpMethod httpMethod,
            HttpHeaders httpHeaders,
            T requestBody,
            Class<R> classToConvertBodyTo
    ) {
        HttpEntity<T> requestEntity = new HttpEntity<>(requestBody, httpHeaders);

        try {
            return restTemplate.exchange(
                    apiEndpoint,
                    httpMethod,
                    requestEntity,
                    classToConvertBodyTo
            );
        } catch (RestClientException e) {
            e.printStackTrace();

            throw e;
        }
    }
}