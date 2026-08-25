package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Базовое числовое значение параметра в точках.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimplePointValue implements PointValue {

    /** Количество закрашенных точек */
    @Column(name = "dots")
    private Integer dots = 0;
}