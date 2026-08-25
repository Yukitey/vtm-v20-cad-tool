package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Законы (Law).
 * Отражают знание юридических норм и процедур в различных областях права.
 */
@Getter
@AllArgsConstructor
public enum LawSpecialization implements EnumSpecialization {

    /**
     * Уголовное право (Criminal Law).
     * Знание наказаний за преступления, процедуры расследований.
     */
    CRIMINAL_LAW("Уголовное право", "Вы знаете, что грозит за преступления. Применяется для оценки рисков, построения защиты и поиска лазеек."),

    /**
     * Договорное право (Contracts).
     * Знание гражданских договоров, обязательств, контрактов.
     */
    CONTRACTS("Договорное право", "Вы разбираетесь в юридических соглашениях. Применяется для составления контрактов и поиска скрытых условий."),

    /**
     * Судебные процедуры (Procedures).
     * Знание судебного процесса и формальностей.
     */
    PROCEDURES("Судебные процедуры", "Вы знаете, как проходит суд. Применяется для манипуляции процессом, подачи апелляций и ведения дел."),

    /**
     * Традиции Сородичей (Traditions).
     * Знание законов Камарильи и Шабаша.
     */
    TRADITIONS("Традиции Сородичей", "Вы знакомы с шестью Традициями. Применяется при общении с Принцем, для понимания политических последствий и соблюдения Маскарада.");

    private final String displayName;
    private final String description;
}