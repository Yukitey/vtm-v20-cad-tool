package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.converters;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.Specialization;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Converter
public class SpecializationConverter implements AttributeConverter<Specialization, String> {

    private static final Map<String, Specialization> SPECIALIZATION_CACHE = new HashMap<>();

    static {
        // Сканируем пакет, где лежат твои специализации
        Reflections reflections = new Reflections("com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters");

        // Находим все Enum, реализующие интерфейс Specialization
        Set<Class<? extends Specialization>> subTypes = reflections.getSubTypesOf(Specialization.class);

        for (Class<? extends Specialization> type : subTypes) {
            if (type.isEnum()) {
                for (Specialization constant : type.getEnumConstants()) {
                    SPECIALIZATION_CACHE.put(constant.name(), constant);
                }
            }
        }
    }

    public static Specialization getCachedSpecialization(String name) {
        return SPECIALIZATION_CACHE.get(name);
    }

    @Override
    public String convertToDatabaseColumn(Specialization specialization) {
        if (specialization == null) return null;
        // Сохраняем имя константы Enum в базу
        return specialization instanceof Enum ? ((Enum<?>) specialization).name() : null;
    }

    @Override
    public Specialization convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        return SPECIALIZATION_CACHE.get(dbData);
    }
}