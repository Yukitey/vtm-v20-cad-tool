package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.virtue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SelfControlOrInstinct {
    SELF_CONTROL("Самообладание"),
    INSTINCT("Инстинкты");

    private final String displayName;
}