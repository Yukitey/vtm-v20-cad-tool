package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.converters.AbilityConverter;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point.SpecializedPointValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@Embeddable
@Getter
@Setter
public class Abilities {

    @ElementCollection
    @CollectionTable(name = "char_talent_ability", joinColumns = @JoinColumn(name = "character_id"))
    @MapKeyColumn(name = "ability_identifier")
    @AttributeOverrides({
            @AttributeOverride(name = "dots", column = @Column(name = "dots_value")),
            @AttributeOverride(name = "specialization", column = @Column(name = "specialization_value"))
    })
    @Convert(converter = AbilityConverter.class, attributeName = "key")
    private Map<Ability, SpecializedPointValue> talents = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "char_skill_ability", joinColumns = @JoinColumn(name = "character_id"))
    @MapKeyColumn(name = "ability_identifier")
    @AttributeOverrides({
            @AttributeOverride(name = "dots", column = @Column(name = "dots_value")),
            @AttributeOverride(name = "specialization", column = @Column(name = "specialization_value"))
    })
    @Convert(converter = AbilityConverter.class, attributeName = "key")
    private Map<Ability, SpecializedPointValue> skills = new HashMap<>();

    @ElementCollection
    @MapKeyColumn(name = "ability_identifier")
    @AttributeOverrides({
            @AttributeOverride(name = "dots", column = @Column(name = "dots_value")),
            @AttributeOverride(name = "specialization", column = @Column(name = "specialization_value"))
    })
    @CollectionTable(name = "char_knowledge_ability", joinColumns = @JoinColumn(name = "character_id"))
    @Convert(converter = AbilityConverter.class, attributeName = "key")
    private Map<Ability, SpecializedPointValue> knowledges = new HashMap<>();
}