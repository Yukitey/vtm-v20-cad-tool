package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Политика (Politics).
 * Отражают знание политических систем и процессов на разных уровнях.
 */
@Getter
@AllArgsConstructor
public enum PoliticsSpecialization implements EnumSpecialization {

    /**
     * Городская политика (City).
     * Знание власти в городе, муниципальных структур и теневых игр.
     */
    CITY_POLITICS("Городская политика", "Вы знаете, кто правит на местах. Применяется для влияния на мэрию и городские советы."),

    /**
     * Национальная политика (National).
     * Знание политики стран и федерального правительства.
     */
    NATIONAL_POLITICS("Национальная политика", "Вы понимаете политику на уровне государства. Применяется для лоббирования интересов и понимания законов."),

    /**
     * Бюрократия (Bureaucracy).
     * Знание процедур, правил и бюрократических структур.
     */
    BUREAUCRACY("Бюрократия", "Вы ориентируетесь в бюрократическом лабиринте. Применяется для получения разрешений, доступа к архивам и ускорения процессов."),

    /**
     * Камарилья (Camarilla).
     * Знание политических структур Камарильи.
     */
    CAMARILLA("Камарилья", "Вы знаете законы Камарильи. Применяется для понимания интриг и иерархии в обществе Сородичей.");

    private final String displayName;
    private final String description;
}