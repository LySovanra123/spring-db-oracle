package com.lysovanra.springdboracle.feature.demo.service;

import com.lysovanra.springdboracle.feature.demo.dto.request.DemoRequest;
import com.lysovanra.springdboracle.feature.demo.dto.response.DemoResponse;

import java.util.List;

public interface DemoService {
    List<DemoResponse> findAll();
    DemoResponse findById(Long id);
    DemoResponse create(DemoRequest request);
    DemoResponse update(Long id, DemoRequest request);
    void delete(Long id);
}
