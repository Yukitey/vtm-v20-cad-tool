package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.CustomSpecialization;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Кастомная специализация для навыка Фехтование (Melee), позволяющая указать конкретный стиль (например, "Фехтование на шпагах", "Боевой нож").
 */
@Entity
@Table(name = "spec_style_melee")
@NoArgsConstructor
public class StyleMeleeSpecialization extends CustomSpecialization {

    private String styleName;

    public StyleMeleeSpecialization(String styleName, String description) {
        this.styleName = styleName;
        setDisplayName(styleName);
        setDescription(description);
    }
}