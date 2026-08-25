package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для навыка Исполнение (Performance).
 * Отражают различные виды сценического искусства и публичных выступлений.
 */
@Getter
@AllArgsConstructor
public enum PerformanceSpecialization implements EnumSpecialization {

    /**
     * Танец (Dance).
     * Различные стили танца от классического до современного.
     */
    DANCE("Танец", "Ваше тело говорит языком движения. Применяется для выступления на сцене, соблазнения или самовыражения в ритуальных танцах."),

    /**
     * Пение (Singing).
     * Вокальное мастерство в различных жанрах.
     */
    SINGING("Пение", "Ваш голос завораживает. Применяется для исполнения песен, оперных арий или ритуальных песнопений."),

    /**
     * Игра на гитаре (Guitar).
     * Мастерство игры на акустической или электрической гитаре.
     */
    GUITAR("Гитара", "Вы создаёте музыку. Применяется для аккомпанемента, сольных выступлений или создания настроения."),

    /**
     * Актёрское мастерство (Acting).
     * Перевоплощение в персонажей на сцене или в кино.
     */
    ACTING_PERFORMANCE("Актёрское мастерство", "Вы способны стать кем угодно. Применяется для театральных постановок, киносъёмок и ролевых игр."),

    /**
     * Импровизация (Improvisation).
     * Спонтанные выступления без подготовки.
     */
    IMPROVISATION_PERFORMANCE("Импровизация", "Вы можете выступить в любой момент. Применяется для уличных представлений, поэтических вечеров и импровизированных сцен.");

    private final String displayName;
    private final String description;
}