package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.backgrounds;

/**
 * Интерфейс статического определения факта биографии.
 * <p>
 * Каждый факт биографии имеет уникальный ID, название, описание.
 * <p>
 * Реализации являются Spring-компонентами (синглтонами).
 */
public interface Background {

    /**
     * Уникальный идентификатор факта.
     */
    String getId();

    /**
     * Отображаемое название факта.
     */
    String getDisplayName();

    /**
     * Описание факта и его игровое применение.
     */
    String getDescription();
}