package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Финансы (Finance).
 * Отражают знание финансовых рынков, бухгалтерии, налогообложения и управления капиталом.
 */
@Getter
@AllArgsConstructor
public enum FinanceSpecialization implements EnumSpecialization {

    /**
     * Фондовый рынок (Stocks).
     * Инвестиции, торговля акциями, анализ рынка.
     */
    STOCKS("Фондовый рынок", "Вы ориентируетесь в бирже. Применяется для управления инвестициями и прогнозирования курсов."),

    /**
     * Бухгалтерия (Accounting).
     * Ведение финансовой отчётности и аудит.
     */
    ACCOUNTING("Бухгалтерия", "Вы знаете, как работают деньги. Применяется для проверки счетов, выявления хищений и управления бюджетом."),

    /**
     * Корпоративные финансы (Corporate).
     * Управление финансами компаний, бюджетирование.
     */
    CORPORATE_FINANCE("Корпоративные финансы", "Вы понимаете финансовые потоки бизнеса. Применяется для управления предприятиями и оценкой их стоимости."),

    /**
     * Теневой рынок (Underworld).
     * Финансовые схемы преступного мира, отмывание денег.
     */
    UNDERWORLD_FINANCE("Теневой рынок", "Вы знаете, как работают теневые деньги. Применяется для ведения незаконных сделок и сокрытия доходов.");

    private final String displayName;
    private final String description;
}