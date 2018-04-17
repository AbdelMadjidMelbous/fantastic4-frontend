package com.example.fantastic4frontend.service;


import com.example.fantastic4frontend.dto.ModuleDTO;
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
public class ModuleServiceImpl {
    @Value("${resource.modules}")
    private String resource;
    @Value("${resource.modules}/{id}")
    private String idResource;
    @Autowired
    private RestTemplate restTemplate;

    public List<ModuleDTO> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource, ModuleDTO[].class)).collect(Collectors.toList());
    }
    public ModuleDTO create(ModuleDTO module) {
        return restTemplate.postForObject(resource, module, ModuleDTO.class);
    }
    public ModuleDTO update(Long id, ModuleDTO module) {
        return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(module), ModuleDTO.class, id).getBody();
    }
    public void delete(Long id) {
        restTemplate.delete(idResource, id);
    }
}
