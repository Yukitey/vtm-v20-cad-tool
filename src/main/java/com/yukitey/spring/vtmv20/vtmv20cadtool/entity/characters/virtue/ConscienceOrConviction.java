package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.virtue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConscienceOrConviction {
    CONSCIENCE("Совесть"),
    CONVICTION("Решимость");

    private final String displayName;
}