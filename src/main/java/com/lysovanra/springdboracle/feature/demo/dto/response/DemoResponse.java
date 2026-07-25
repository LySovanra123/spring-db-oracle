package com.lysovanra.springdboracle.feature.demo.dto.response;

import java.time.LocalDateTime;

public record DemoResponse(
        Long id,
        String name,
        String description,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
