package com.lysovanra.springdboracle.database.tcdev.entity;

import com.lysovanra.springdboracle.app.configuration.dao.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DEMO")
public class DemoEntity extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}
