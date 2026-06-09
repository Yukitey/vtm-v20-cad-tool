package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Абстрактная база для создания уникальных способностей персонажа (Хобби, Профессиональные навыки и т.д.).
 * <p>
 * В отличие от стандартных способностей (Enum), кастомные способности сохраняются в базе данных
 * как отдельные сущности. Это позволяет игрокам и мастерам расширять список талантов, навыков
 * и познаний согласно нуждам конкретной Хроники.
 * </p>
 *
 * @see Ability
 */
@Entity
@Table(name = "custom_abilities")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract non-sealed class CustomAbility implements Ability {

    /**
     * Уникальный идентификатор записи в базе данных.
     * Позволяет ссылаться на одну и ту же кастомную способность у разных персонажей.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Публичное название способности для отображения в листе персонажа.
     * Например: "Метание карт", "Горловое пение" или "Ремонт антиквариата".
     */
    @Column(nullable = false)
    private String displayName;

    /**
     * Подробное описание предназначения способности.
     * Здесь фиксируется, в каких ситуациях мастер может запросить бросок,
     * и какие сложности (Difficulty) обычно применяются.
     */
    @Column(length = 1000)
    private String description;

    /**
     * Формирует технический идентификатор для хранения в картах способностей персонажа.
     *
     * @return строковый ключ для мапы или БД.
     */
    public String name() {
        return String.format("CUSTOM_ABILITY_%s_%s", prefix().toUpperCase(), id);
    }

    public abstract String prefix();
}