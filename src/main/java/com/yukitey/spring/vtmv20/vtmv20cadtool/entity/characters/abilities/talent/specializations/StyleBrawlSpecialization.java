package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.talent.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.CustomSpecialization;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Кастомная специализация для таланта Драка, позволяющая указать конкретную технику или стиль боя.
 */
@Entity
@Table(name = "spec_style_brawl")
@Getter
@Setter
@NoArgsConstructor
public class StyleBrawlSpecialization extends CustomSpecialization {

    /** Название стиля (например, "Тайский бокс", "Джиу-джитсу", "Уличный бокс") */
    private String styleName;

    public StyleBrawlSpecialization(String styleName, String description) {
        this.styleName = styleName;
        this.setDisplayName(styleName);
        this.setDescription(description);
    }
}