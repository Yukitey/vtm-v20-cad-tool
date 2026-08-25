package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.CustomSpecialization;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Кастомная специализация для навыка Ремесло (Crafts) или Профессия, позволяющая указать конкретное ремесло или профессию.
 */
@Entity
@Table(name = "spec_profession_skill")
@NoArgsConstructor
public class ProfessionSkillSpecialization extends CustomSpecialization {

    private String professionName;

    public ProfessionSkillSpecialization(String professionName, String description) {
        this.professionName = professionName;
        setDisplayName(professionName);
        setDescription(description);
    }
}