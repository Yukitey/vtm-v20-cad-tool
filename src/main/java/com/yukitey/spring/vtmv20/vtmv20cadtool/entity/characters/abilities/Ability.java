package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities;

public sealed interface Ability permits EnumAbility, CustomAbility {

    String name();
    String getDisplayName();
}