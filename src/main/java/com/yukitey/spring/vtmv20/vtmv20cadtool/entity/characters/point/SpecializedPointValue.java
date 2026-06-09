package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.Specialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.converters.SpecializationConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecializedPointValue extends PointValue {

    @Column(name = "specialization")
    @Convert(converter = SpecializationConverter.class)
    private Specialization specialization;

    public SpecializedPointValue(Integer dots, Specialization spec) {
        super(dots);
        // Логика V20: специализация активна только на 4+ точках
        if (dots != null && dots >= 4 && spec != null) {
            this.specialization = spec;
        }
    }
}