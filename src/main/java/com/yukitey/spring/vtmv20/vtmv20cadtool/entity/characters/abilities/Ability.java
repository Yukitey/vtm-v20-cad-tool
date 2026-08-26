package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.Specialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public sealed interface Ability permits EnumAbility, CustomAbility {

    String name();

    String getDisplayName();

    /**
     * Возвращает класс перечисления, содержащий специализации
     */
    Collection<Class<? extends Specialization>> getSpecializationClasses();

    /**
     * @return Список специализаций, доступных для данной характеристики.
     */
    default List<? extends Specialization> getAvailableSpecializations() {
        final List<Specialization> specializations = new ArrayList<>();

        final Collection<Class<? extends Specialization>> specializationClasses = getSpecializationClasses();
        for (Class<? extends Specialization> specializationClass : specializationClasses) {
            if (specializationClass.isEnum()) {
                specializations.addAll(List.of(specializationClass.getEnumConstants()));
            }
        }

        return specializations;
    }
}