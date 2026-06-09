package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.archetypes;

/**
 * Интерфейс, определяющий структуру архетипа личности (Натура и Маска).
 * Архетипы описывают глубинную суть персонажа и определяют условия восстановления Силы Воли.
 */
public interface Archetype {
    /**
     * @return Локализованное название архетипа.
     */
    String getDisplayName();

    /**
     * @return Описание философии и мировоззрения архетипа.
     */
    String getDescription();

    /**
     * @return Условие восстановления очков Силы Воли.
     */
    String getWillpowerRegain();
}