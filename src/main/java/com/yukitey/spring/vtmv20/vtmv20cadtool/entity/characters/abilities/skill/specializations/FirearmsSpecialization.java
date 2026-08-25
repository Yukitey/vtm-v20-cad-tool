package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для навыка Стрельба (Firearms).
 * Отражают специализацию в использовании различных видов огнестрельного оружия.
 */
@Getter
@AllArgsConstructor
public enum FirearmsSpecialization implements EnumSpecialization {

    /**
     * Пистолеты (Pistols).
     * Стрельба из любых ручных пистолетов и револьверов.
     */
    PISTOLS("Пистолеты", "Вы быстро выхватываете и точно стреляете из пистолета. Применяется в ближнем и среднем бою."),

    /**
     * Винтовки (Rifles).
     * Стрельба из винтовок и снайперских винтовок.
     */
    RIFLES("Винтовки", "Вы метко стреляете с дальних дистанций. Применяется для снайперской стрельбы и охоты."),

    /**
     * Дробовики (Shotguns).
     * Использование дробовиков различных калибров.
     */
    SHOTGUNS("Дробовики", "Вы эффективно используете дробовик в ближнем бою. Применяется для создания плотного огня и пробития брони."),

    /**
     * Быстрое выхватывание (Quick Draw).
     * Навык мгновенного извлечения оружия и первого выстрела.
     */
    QUICK_DRAW("Быстрое выхватывание", "Вы выхватываете пистолет молниеносно. Применяется для дуэлей и внезапных перестрелок."),

    /**
     * Перезарядка (Reloading).
     * Умение быстро перезаряжать оружие.
     */
    RELOADING("Перезарядка", "Вы перезаряжаете оружие в считанные секунды. Применяется в длительных боях, когда дорога каждая секунда.");

    private final String displayName;
    private final String description;
}