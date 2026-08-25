package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Фиксированные специализации для навыка Фехтование (Melee).
 * Для указания конкретного стиля используется кастомная специализация {@link StyleMeleeSpecialization}.
 */
@Getter
@AllArgsConstructor
public enum MeleeSpecialization implements EnumSpecialization {

    /**
     * Мечи (Swords).
     * Владение мечами любого типа.
     */
    SWORDS("Мечи", "Вы искусно владеете мечом. Применяется в дуэлях и массовых сражениях."),

    /**
     * Ножи (Knives).
     * Владение ножами и кинжалами в ближнем бою.
     */
    KNIVES("Ножи", "Вы можете использовать нож как оружие. Применяется для скрытных атак и ближнего боя."),

    /**
     * Импровизированное оружие (Improvised Weapons).
     * Использование подручных предметов в качестве оружия.
     */
    IMPROVISED_WEAPONS("Импровизированное оружие", "Вы способны превратить любой предмет в оружие. Применяется в уличных драках и нестандартных ситуациях."),

    /**
     * Парирование (Parrying).
     * Техники защиты и контратаки с использованием клинка.
     */
    PARRYING("Парирование", "Вы мастерски отражаете удары врага. Применяется для обороны и создания возможностей для контратаки."),

    /**
     * Разоружение (Disarming).
     * Навык выбить оружие из рук противника.
     */
    DISARMING("Разоружение", "Вы обезвреживаете противника, выбив его оружие. Применяется для захвата врага живым и его обезвреживания.");

    private final String displayName;
    private final String description;
}