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
public class SpecializedPointValue implements PointValue {

    /** Количество закрашенных точек */
    @Column(name = "dots")
    private Integer dots = 0;

    @Column(name = "specialization")
    @Convert(converter = SpecializationConverter.class)
    private Specialization specialization;
}