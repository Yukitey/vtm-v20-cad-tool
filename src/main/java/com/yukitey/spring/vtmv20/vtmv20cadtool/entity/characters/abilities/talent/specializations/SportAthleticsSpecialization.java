package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.talent.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.CustomSpecialization;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Кастомная специализация для таланта Атлетика, позволяющая указать конкретный вид спорта.
 */
@Entity
@Table(name = "spec_sport_athletics")
@Getter
@Setter
@NoArgsConstructor
public class SportAthleticsSpecialization extends CustomSpecialization {

    /** Название вида спорта (например, "Футбол", "Фехтование") */
    private String sportName;

    public SportAthleticsSpecialization(String sportName, String description) {
        this.sportName = sportName;
        this.setDisplayName(sportName);
        this.setDescription(description);
    }
}