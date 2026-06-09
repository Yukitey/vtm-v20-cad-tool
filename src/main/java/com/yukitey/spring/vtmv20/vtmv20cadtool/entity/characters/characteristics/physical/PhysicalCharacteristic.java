package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.physical;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.Characteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.physical.specializations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Перечисление физических характеристик персонажа.
 * Отвечают за действия, связанные с телом, координацией и выносливостью.
 */
@Getter
@AllArgsConstructor
public enum PhysicalCharacteristic implements Characteristic {

    /** Сила (Strength) — физическая мощь и способность поднимать тяжести. */
    STRENGTH("Сила", StrengthSpecialization.class),

    /** Ловкость (Dexterity) — координация, скорость реакции и гибкость. */
    DEXTERITY("Ловкость", DexteritySpecialization.class),

    /** Выносливость (Stamina) — устойчивость к повреждениям и физическая стойкость. */
    STAMINA("Выносливость", StaminaSpecialization.class);

    /** Локализованное название характеристики. */
    private final String displayName;
    /** Класс перечисления, содержащий специализации. */
    private final Class<? extends EnumSpecialization> specializationClass;
}