package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Абстрактный класс для всех специализаций, которые не являются перечислениями.
 * Позволяет создавать расширяемые и уникальные специализации с собственным ID.
 */
@Entity
@Table(name = "custom_specializations")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public non-sealed abstract class CustomSpecialization implements Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String displayName;

    @Column(length = 1000)
    private String description;

    /**
     * Для кастомных объектов name() возвращает строковое представление ID
     * или уникальный технический код.
     */
    @Override
    public String name() {
        return "CUSTOM_" + id;
    }
}