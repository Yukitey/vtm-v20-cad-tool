package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Фиксированные специализации для навыка Ремесло (Crafts).
 * Для указания конкретного ремесла используется кастомная специализация {@link ProfessionSkillSpecialization}.
 */
@Getter
@AllArgsConstructor
public enum CraftsSpecialization implements EnumSpecialization {

    /**
     * Столярное дело (Carpentry).
     */
    CARPENTRY("Столярное дело", "Вы умеете создавать и ремонтировать деревянные конструкции и мебель."),

    /**
     * Кожевничество (Leatherworking).
     */
    LEATHERWORKING("Кожевничество", "Вы работаете с кожей, создавая одежду, обувь и аксессуары."),

    /**
     * Кузнечное дело (Smithing).
     */
    SMITHING("Кузнечное дело", "Вы владеете искусством ковки металла, создавая оружие и доспехи."),

    /**
     * Механика (Mechanics).
     */
    MECHANICS("Механика", "Вы разбираетесь в устройстве и ремонте механических устройств, включая автомобили.");

    private final String displayName;
    private final String description;
}