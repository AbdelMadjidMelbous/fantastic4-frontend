package com.example.fantastic4frontend.service;

import com.example.fantastic4frontend.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl {
    @Value("${resource.questions}")
    private String resource;
    @Value("${resource.questions}/{id}")
    private String idResource;
    @Autowired
    private RestTemplate restTemplate;

    public List<QuestionDTO> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource, QuestionDTO[].class)).collect(Collectors.toList());
    }
    public QuestionDTO create(QuestionDTO question) {
        return restTemplate.postForObject(resource, question, QuestionDTO.class);
    }
    public QuestionDTO update(Long id, QuestionDTO question) {
        return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(question), QuestionDTO.class, id).getBody();
    }
    public void delete(Long id) {
        restTemplate.delete(idResource, id);
    }
}
