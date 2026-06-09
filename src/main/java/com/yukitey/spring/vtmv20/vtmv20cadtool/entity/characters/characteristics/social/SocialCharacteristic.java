package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.Characteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social.specializations.AppearanceSpecialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social.specializations.CharismaSpecialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social.specializations.ManipulationSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Перечисление социальных характеристик персонажа.
 * Определяют внешнее обаяние, умение убеждать и манипулировать другими.
 */
@Getter
@AllArgsConstructor
public enum SocialCharacteristic implements Characteristic {

    /** Обаяние (Charisma) — естественная притягательность и лидерские качества. */
    CHARISMA("Обаяние", CharismaSpecialization.class),

    /** Манипуляция (Manipulation) — умение заставлять других делать то, что вам нужно. */
    MANIPULATION("Манипуляция", ManipulationSpecialization.class),

    /** Привлекательность (Appearance) — физическая красота и первое визуальное впечатление. */
    APPEARANCE("Привлекательность", AppearanceSpecialization.class);

    /** Локализованное название характеристики. */
    private final String displayName;
    /** Класс перечисления, содержащий специализации. */
    private final Class<? extends EnumSpecialization> specializationClass;
}