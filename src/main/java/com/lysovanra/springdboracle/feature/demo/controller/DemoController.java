package com.lysovanra.springdboracle.feature.demo.controller;

import com.lysovanra.springdboracle.feature.demo.dto.request.DemoRequest;
import com.lysovanra.springdboracle.feature.demo.dto.response.DemoResponse;
import com.lysovanra.springdboracle.feature.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping
    public List<DemoResponse> findAll() {
        return demoService.findAll();
    }

    @GetMapping("/{id}")
    public DemoResponse findById(@PathVariable Long id) {
        return demoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DemoResponse create(@RequestBody DemoRequest request) {
        return demoService.create(request);
    }

    @PutMapping("/{id}")
    public DemoResponse update(@PathVariable Long id, @RequestBody DemoRequest request) {
        return demoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        demoService.delete(id);
    }
}
