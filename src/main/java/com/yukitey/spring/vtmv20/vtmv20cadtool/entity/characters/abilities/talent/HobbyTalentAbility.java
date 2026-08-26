package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.talent;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.Specialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.CustomAbility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;

/**
 * Сущность для произвольных талантов (Хобби), не входящих в основной список.
 */
@Entity
@Table(name = "custom_hobbies")
@Getter
@Setter
@NoArgsConstructor
public class HobbyTalentAbility extends CustomAbility {

    public static String PREFIX = "Hobby";

    @Override
    public String prefix() {
        return PREFIX;
    }
}