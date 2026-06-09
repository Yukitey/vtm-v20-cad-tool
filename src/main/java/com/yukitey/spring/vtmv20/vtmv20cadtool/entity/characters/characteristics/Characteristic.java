package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;

import java.util.List;

/**
 * Общий интерфейс для всех типов характеристик персонажа.
 */
public interface Characteristic {
    /** @return Локализованное название для отображения */
    String getDisplayName();

    /** Возвращает класс перечисления, содержащий специализации */
    Class<? extends EnumSpecialization> getSpecializationClass();

    /**
     * @return Список специализаций, доступных для данной характеристики.
     */
    default List<? extends EnumSpecialization> getAvailableSpecializations(){
      return List.of(getSpecializationClass().getEnumConstants());
    }
}