package com.example.fantastic4frontend.service;

import com.example.fantastic4frontend.dto.NiveauDTO;
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
public class NiveauServiceImpl {
    @Value("${resource.niveaux}")
    private String resource;
    @Value("${resource.niveaux}/{id}")
    private String idResource;
    @Autowired
    private RestTemplate restTemplate;

    public List<NiveauDTO> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource, NiveauDTO[].class)).collect(Collectors.toList());
    }
    public NiveauDTO create(NiveauDTO niveau) {
        return restTemplate.postForObject(resource, niveau, NiveauDTO.class);
    }
    public NiveauDTO update(Long id, NiveauDTO niveau) {
        return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(niveau), NiveauDTO.class, id).getBody();
    }
    public void delete(Long id) {
        restTemplate.delete(idResource, id);
    }
}
