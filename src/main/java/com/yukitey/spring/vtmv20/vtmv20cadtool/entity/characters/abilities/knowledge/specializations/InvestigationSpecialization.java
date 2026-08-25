package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Расследование (Investigation).
 * Отражают навыки сбора и анализа улик, ведения розыска и наблюдения.
 */
@Getter
@AllArgsConstructor
public enum InvestigationSpecialization implements EnumSpecialization {

    /**
     * Судебная экспертиза (Forensics).
     * Анализ улик, ДНК, следов, баллистика.
     */
    FORENSICS("Судебная экспертиза", "Вы находите невидимое. Применяется для анализа улик, снятия отпечатков и определения причин преступлений."),

    /**
     * Слежка (Surveillance).
     * Навыки ведения скрытого наблюдения за объектами.
     */
    SURVEILLANCE("Слежка", "Вы мастер скрытого наблюдения. Применяется для слежки, фиксации перемещений и сбора информации."),

    /**
     * Поиск информации (Research).
     * Умение находить данные в архивах, библиотеках, интернете.
     */
    RESEARCH("Поиск информации", "Вы способны найти любую информацию. Применяется для работы с базами данных, изучения документов и анализа фактов."),

    /**
     * Работа с уликами (Evidence).
     * Сбор и сохранение улик, составление отчётов.
     */
    EVIDENCE("Работа с уликами", "Вы знаете, как обращаться с уликами. Применяется для сбора доказательств и их сохранения.");

    private final String displayName;
    private final String description;
}