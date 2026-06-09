package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.converters;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.Specialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.Ability;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.CustomAbility;
import jakarta.persistence.AttributeConverter;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AbilityConverter implements AttributeConverter<Ability, String> {

    private static final Map<String, Ability> ABILITY_CACHE = new HashMap<>();

    static {
        Reflections reflections = new Reflections("com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters");

        Set<Class<? extends Ability>> subTypes = reflections.getSubTypesOf(Ability.class);

        for (Class<? extends Ability> type : subTypes) {
            if (type.isEnum()) {
                for (Ability constant : type.getEnumConstants()) {
                    ABILITY_CACHE.put(constant.name(), constant);
                }
            }
        }
    }

    @Override
    public String convertToDatabaseColumn(Ability ability) {
        return ability.name();
    }

    @Override
    public Ability convertToEntityAttribute(String dbData) {

        return null;
    }
}
