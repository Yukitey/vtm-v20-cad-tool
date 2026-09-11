package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Wound {
    NONE(0),
    LIGHT(1),
    LETHAL(2),
    AGGRAVATED(3);

    private final int severity;
}