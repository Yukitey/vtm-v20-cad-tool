package com.yukitey.spring.vtmv20.vtmv20cadtool.vampire.dto;

import com.yukitey.spring.vtmv20.vtmv20cadtool.common.dto.BackgroundPointValueDto;
import com.yukitey.spring.vtmv20.vtmv20cadtool.common.dto.SpecializedPointValueDto;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.KnowledgeAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.SkillAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.talent.TalentAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.archetypes.BaseArchetype;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.Characteristics;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.mental.MentalCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.physical.PhysicalCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social.SocialCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.concepts.BaseConcept;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

/**
 * DTO для формы создания/редактирования вампира.
 * Использует плоские мапы для характеристик и способностей.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VampireCharacterDto {

    private UUID id;
    private String name;
    private String playerId;
    private BaseArchetype nature;
    private BaseArchetype archetype;
    private BaseConcept concept;

    // === Характеристики (плоские мапы) ===
    private Map<PhysicalCharacteristic, SpecializedPointValueDto> physicalAttributes = new HashMap<>();
    private Map<SocialCharacteristic, SpecializedPointValueDto> socialAttributes = new HashMap<>();
    private Map<MentalCharacteristic, SpecializedPointValueDto> mentalAttributes = new HashMap<>();

    // === Способности (плоские мапы) ===
    private Map<TalentAbility, SpecializedPointValueDto> talents = new HashMap<>();
    private Map<SkillAbility, SpecializedPointValueDto> skills = new HashMap<>();
    private Map<KnowledgeAbility, SpecializedPointValueDto> knowledges = new HashMap<>();

    // === Добродетели ===
    private String conscienceType; // "CONSCIENCE" или "CONVICTION"
    private Integer conscienceDots;
    private String selfControlType; // "SELF_CONTROL" или "INSTINCT"
    private Integer selfControlDots;
    private Integer courageDots;
    private Integer willpowerDots;

    // === Вампирская специфика ===
    private String clanId;
    private Integer generation;
    private String enlightenmentPathId;
    private Integer moralityValue;
    private Integer bloodPool;

    // === Дисциплины ===
    private Map<String, Integer> disciplines = new HashMap<>();

    // === Факты биографии ===
    private Map<String, BackgroundPointValueDto> backgrounds = new HashMap<>();


}