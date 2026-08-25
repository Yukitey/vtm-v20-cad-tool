package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для навыка Скрытность (Stealth).
 * Отражают мастерство незаметного передвижения и уклонения от обнаружения.
 */
@Getter
@AllArgsConstructor
public enum StealthSpecialization implements EnumSpecialization {

    /**
     * Тени (Shadows).
     * Использование теней для укрытия.
     */
    SHADOWS("Тени", "Вы сливаетесь с темнотой. Применяется для скрытного перемещения в ночи, в заброшенных зданиях или других тёмных местах."),

    /**
     * Бесшумный шаг (Silence).
     * Движение без звука.
     */
    SILENCE("Бесшумный шаг", "Вы способны передвигаться совершенно бесшумно. Применяется для подкрадывания к жертве или для обхода патрулей."),

    /**
     * Города (Urban Stealth).
     * Скрытность в городских условиях.
     */
    URBAN_STEALTH("Города", "Вы знаете, как потеряться в толпе. Применяется для преследования целей на улицах, в метро и вокзалах."),

    /**
     * Толпы (Crowds).
     * Использование скоплений людей для маскировки.
     */
    CROWDS_STEALTH("Толпы", "Вы легко затеряетесь в толпе. Применяется для скрытного наблюдения или ухода от преследователей на массовых мероприятиях."),

    /**
     * Естественная среда (Natural Environment).
     * Скрытность в лесах, горах и других природных ландшафтах.
     */
    NATURAL_ENVIRONMENT("Естественная среда", "Вы используете природу как укрытие. Применяется для засад, выслеживания и передвижения по дикой местности.");

    private final String displayName;
    private final String description;
}