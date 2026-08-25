package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.CustomSpecialization;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * Кастомная специализация для знания Квалификация (Expertise), позволяющая указать конкретную область знаний.
 */
@Entity
@Table(name = "spec_expertise_knowledge")
@NoArgsConstructor
public class ExpertiseKnowledgeSpecialization extends CustomSpecialization {

    private String expertiseName;

    public ExpertiseKnowledgeSpecialization(String expertiseName, String description) {
        this.expertiseName = expertiseName;
        setDisplayName(expertiseName);
        setDescription(description);
    }
}