package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.CustomAbility;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Сущность для произвольных знаний (Квалификация), не входящих в основной список.
 * <p>
 * Позволяет игроку создать уникальную область знаний, например "Ядерная физика", "Древние языки" и т.п.
 */
@Entity
@Table(name = "custom_expertise")
@NoArgsConstructor
public class ExpertiseKnowledgeAbility extends CustomAbility {

    public static final String PREFIX = "Expertise";

    @Override
    public String prefix() {
        return PREFIX;
    }
}