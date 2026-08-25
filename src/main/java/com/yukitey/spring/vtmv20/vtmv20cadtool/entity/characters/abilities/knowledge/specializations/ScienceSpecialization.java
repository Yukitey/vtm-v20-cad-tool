package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Естественные науки (Science).
 * Отражают знания в области естественных наук: химии, биологии, физики, астрономии.
 */
@Getter
@AllArgsConstructor
public enum ScienceSpecialization implements EnumSpecialization {

    /**
     * Химия (Chemistry).
     * Знание химических элементов, реакций и составов веществ.
     */
    CHEMISTRY("Химия", "Вы понимаете природу веществ. Применяется для анализа образцов, создания ядов или взрывчатых веществ и проведения экспериментов."),

    /**
     * Биология (Biology).
     * Знание живых организмов, анатомии, генетики.
     */
    BIOLOGY("Биология", "Вы знаете строение живых существ. Применяется для изучения животных, генетических экспериментов и медицинских исследований."),

    /**
     * Физика (Physics).
     * Законы природы, механика, оптика, электричество.
     */
    PHYSICS("Физика", "Вы понимаете фундаментальные законы мира. Применяется для создания механизмов, расчётов и прогнозирования природных явлений."),

    /**
     * Астрономия (Astronomy).
     * Знание звёздного неба, планет и космоса.
     */
    ASTRONOMY("Астрономия", "Вы ориентируетесь в космосе. Применяется для навигации, изучения мифов и предсказаний, а также для наблюдений за планетами.");

    private final String displayName;
    private final String description;
}