package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.CustomAbility;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Сущность для произвольных навыков (Профессия), не входящих в основной список.
 * <p>
 * Позволяет игроку создать уникальный навык, например "Водолазное дело", "Повар" и т.п.
 */
@Entity
@Table(name = "custom_professions")
@NoArgsConstructor
public class ProfessionSkillAbility extends CustomAbility {

    public static final String PREFIX = "Profession";

    @Override
    public String prefix() {
        return PREFIX;
    }
}