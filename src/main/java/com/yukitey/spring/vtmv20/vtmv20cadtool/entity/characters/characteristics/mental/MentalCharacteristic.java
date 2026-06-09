package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.mental;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.Characteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.mental.specializations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Перечисление ментальных характеристик персонажа.
 * Отражают остроту ума, внимательность и аналитические способности.
 */
@Getter
@AllArgsConstructor
public enum MentalCharacteristic implements Characteristic {

    /** Восприятие (Perception) — способность замечать детали и скрытые вещи. */
    PERCEPTION("Восприятие", PerceptionSpecialization.class),

    /** Интеллект (Intelligence) — способность к анализу, обучению и логике. */
    INTELLIGENCE("Интеллект", IntelligenceSpecialization.class),

    /** Смекалка (Wits) — скорость мышления и умение быстро реагировать в стрессовых ситуациях. */
    WITS("Смекалка",WitsSpecialization.class);

    /** Локализованное название характеристики. */
    private final String displayName;
    /** Класс перечисления, содержащий специализации. */
    private final Class<? extends EnumSpecialization> specializationClass;
}