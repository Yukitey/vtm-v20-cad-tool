package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Гуманитарные науки (Academics).
 * Отражают знание различных областей гуманитарных наук: истории, литературы, философии.
 */
@Getter
@AllArgsConstructor
public enum AcademicsSpecialization implements EnumSpecialization {

    /**
     * История (History).
     * Знание событий прошлого и их интерпретация.
     */
    HISTORY("История", "Вы ориентируетесь в исторических эпохах и личностях. Применяется для анализа текущих событий через призму прошлого, поиска артефактов и древних знаний."),

    /**
     * Литература (Literature).
     * Знание произведений и биографий писателей.
     */
    LITERATURE("Литература", "Вы знакомы с мировой литературой. Применяется для цитирования, поиска скрытых смыслов и понимания культурного кода."),

    /**
     * Искусство (Art).
     * Живопись, скульптура, архитектура, история искусств.
     */
    ART("Искусство", "Вы понимаете язык искусства. Применяется для оценки произведений, выявления подделок и изучения культурных течений."),

    /**
     * Философия (Philosophy).
     * Знание философских учений и школ мысли.
     */
    PHILOSOPHY("Философия", "Вы знакомы с мировоззренческими системами. Применяется для ведения дискуссий, поиска смысла бытия и понимания мотивов персонажей.");

    private final String displayName;
    private final String description;
}