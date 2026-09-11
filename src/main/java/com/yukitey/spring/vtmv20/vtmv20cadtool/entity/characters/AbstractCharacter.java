package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.Abilities;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.archetypes.BaseArchetype;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.Characteristics;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.concepts.BaseConcept;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.HealthState;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.Wound;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.strategy.WoundStrategy;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point.SimplePointValue;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.virtue.ConscienceOrConvictionChoice;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.virtue.SelfControlOrInstinctChoice;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.players.Player;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Имя персонажа
     */
    @Column(nullable = false)
    private String name;

    /**
     * Игрок
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    /**
     * Натура: истинная личность персонажа
     */
    @Enumerated(EnumType.STRING)
    private BaseArchetype nature;

    /**
     * Маска: образ, который персонаж являет миру
     */
    @Enumerated(EnumType.STRING)
    private BaseArchetype archetype;

    /**
     * Амплуа: социальная концепция персонажа
     */
    @Enumerated(EnumType.STRING)
    private BaseConcept concept;

    /**
     * Характеристики
     */
    @Embedded
    private Characteristics characteristics = new Characteristics();

    /**
     * Способности
     */
    @Embedded
    private Abilities abilities = new Abilities();

    /**
     * Совесть (Conscience) или Решимость (Conviction).
     * Зависит от этического кодекса или Пути персонажа.
     */
    private ConscienceOrConvictionChoice conscienceOrConviction;

    /**
     * Самообладание (Self-Control) или Инстинкты (Instinct).
     * Определяет способность сдерживать Зверя.
     */
    private SelfControlOrInstinctChoice selfControlOrInstinct;

    /**
     * Храбрость (Courage)
     */
    @AttributeOverride(name = "dots", column = @Column(name = "courage_dots"))
    private SimplePointValue courage;

    /**
     * Сила воли (Willpower)
     */
    @AttributeOverride(name = "dots", column = @Column(name = "willpower_dots"))
    private SimplePointValue willpower;

    @ElementCollection
    @CollectionTable(
            name = "character_wound_pool",
            joinColumns = @JoinColumn(name = "character_id")
    )
    @OrderColumn(name = "wound_index")
    @Enumerated(EnumType.STRING)
    private List<Wound> woundPool = new ArrayList<>(Collections.nCopies(7, Wound.NONE));

    @Transient
    public abstract WoundStrategy getWoundStrategy();

    @Transient
    public HealthState getHealthState() {
        return getWoundStrategy().getHealthState(woundPool);
    }
}