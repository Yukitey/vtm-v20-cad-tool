package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.mental.MentalCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.physical.PhysicalCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social.SocialCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point.SpecializedPointValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.Map;

/**
 * Группа базовых характеристик персонажа.
 * Объединяет физические, социальные и ментальные параметры.
 */
@Embeddable
@Getter
@Setter
public class Characteristics {

    /**
     * Физические характеристики: Сила, Ловкость, Выносливость.
     */
    @ElementCollection
    @CollectionTable(name = "char_physical_characteristic", joinColumns = @JoinColumn(name = "character_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @AttributeOverrides({
            @AttributeOverride(name = "dots", column = @Column(name = "dots_value")),
            @AttributeOverride(name = "specialization", column = @Column(name = "specialization_value"))
    })
    private Map<PhysicalCharacteristic, SpecializedPointValue> physical = new EnumMap<>(PhysicalCharacteristic.class);

    /**
     * Социальные характеристики: Обаяние, Манипуляция, Привлекательность.
     */
    @ElementCollection
    @CollectionTable(name = "char_social_characteristic", joinColumns = @JoinColumn(name = "character_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @AttributeOverrides({
            @AttributeOverride(name = "dots", column = @Column(name = "dots_value")),
            @AttributeOverride(name = "specialization", column = @Column(name = "specialization_value"))
    })
    private Map<SocialCharacteristic, SpecializedPointValue> social = new EnumMap<>(SocialCharacteristic.class);

    /**
     * Ментальные характеристики: Восприятие, Интеллект, Смекалка.
     */
    @ElementCollection
    @CollectionTable(name = "char_mental_characteristic", joinColumns = @JoinColumn(name = "character_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @AttributeOverrides({
            @AttributeOverride(name = "dots", column = @Column(name = "dots_value")),
            @AttributeOverride(name = "specialization", column = @Column(name = "specialization_value"))
    })
    private Map<MentalCharacteristic, SpecializedPointValue> mental = new EnumMap<>(MentalCharacteristic.class);
}