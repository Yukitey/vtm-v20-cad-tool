package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.archetypes.*;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.*;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.concepts.BaseConcept;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный базовый класс для всех существ Мира Тьмы (V20).
 * Содержит общие атрибуты, анкетные данные и базовые параметры состояния.
 */
@Entity
@Table(name = "abstract_characters")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class AbstractCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Имя персонажа */
    @Column(nullable = false)
    private String name;

    /** Имя игрока */
    private String player;

    /** Название хроники */
    private String chronicle;

    /** Натура: истинная личность персонажа */
    @Enumerated(EnumType.STRING)
    private BaseArchetype nature;

    /** Маска: образ, который персонаж являет миру */
    @Enumerated(EnumType.STRING)
    private BaseArchetype demeanor;

    /** Амплуа: социальная концепция персонажа */
    @Enumerated(EnumType.STRING)
    private BaseConcept concept;

    /** Базовые характеристики */
    @Embedded
    private Characteristics characteristics = new Characteristics();

    // --- Virtues (Добродетели) ---
    /**
     * Совесть (Conscience) или Решимость (Conviction).
     * Зависит от этического кодекса или Пути персонажа.
     */
    private Integer conscienceOrConviction;

    /**
     * Самообладание (Self-Control) или Инстинкты (Instinct).
     * Определяет способность сдерживать Зверя.
     */
    private Integer selfControlOrInstinct;

    /** Храбрость (Courage) */
    private Integer courage;

    /** Сила воли (Willpower) */
    private Integer willpower;
}
