package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Электроника (Technology).
 * Отражают знание компьютерного железа, систем безопасности, телекоммуникаций.
 */
@Getter
@AllArgsConstructor
public enum TechnologySpecialization implements EnumSpecialization {

    /**
     * Компьютерное железо (Hardware).
     * Сборка, ремонт и модернизация компьютеров.
     */
    HARDWARE("Компьютерное железо", "Вы знаете, как работает железо. Применяется для ремонта и сборки ПК, серверов и устройств."),

    /**
     * Системы безопасности (Security Systems).
     * Знание сигнализаций, замков и систем видеонаблюдения.
     */
    SECURITY_SYSTEMS("Системы безопасности", "Вы понимаете, как работает защита. Применяется для обхода систем и их установки."),

    /**
     * Телекоммуникации (Telecom).
     * Знание кабельных сетей, беспроводной связи, радиосвязи.
     */
    TELECOM("Телекоммуникации", "Вы знаете, как передаётся информация. Применяется для настройки связи, прослушки и глушения сигналов."),

    /**
     * Инженерия (Engineering).
     * Прикладное применение науки для создания устройств.
     */
    ENGINEERING("Инженерия", "Вы создаёте новые технологии. Применяется для разработки прототипов и улучшения электроники.");

    private final String displayName;
    private final String description;
}