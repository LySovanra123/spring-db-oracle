package com.lysovanra.springdboracle.feature.demo.service.impl;

import com.lysovanra.springdboracle.database.tcdev.entity.DemoEntity;
import com.lysovanra.springdboracle.database.tcdev.repository.DemoRepository;
import com.lysovanra.springdboracle.feature.demo.dto.request.DemoRequest;
import com.lysovanra.springdboracle.feature.demo.dto.response.DemoResponse;
import com.lysovanra.springdboracle.feature.demo.service.DemoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DemoResponse> findAll() {
        return demoRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DemoResponse findById(Long id) {
        return toResponse(getEntity(id));
    }

    @Override
    public DemoResponse create(DemoRequest request) {
        DemoEntity entity = new DemoEntity();
        entity.setName(request.name());
        entity.setDescription(request.description());
        return toResponse(demoRepository.save(entity));
    }

    @Override
    public DemoResponse update(Long id, DemoRequest request) {
        DemoEntity entity = getEntity(id);
        entity.setName(request.name());
        entity.setDescription(request.description());
        return toResponse(demoRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        demoRepository.delete(getEntity(id));
    }

    private DemoEntity getEntity(Long id) {
        return demoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demo not found with id: " + id));
    }

    private DemoResponse toResponse(DemoEntity entity) {
        return new DemoResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCreatedDate(),
                entity.getUpdatedDate()
        );
    }
}
