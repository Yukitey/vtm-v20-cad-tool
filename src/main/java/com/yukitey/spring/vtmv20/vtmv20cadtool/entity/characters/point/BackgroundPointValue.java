package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BackgroundPointValue implements PointValue{

    /**
     * Количество закрашенных точек
     */
    @Column(name = "dots")
    private Integer dots = 0;

    @Nullable
    @Column(name = "definition")
    private String definition;
}