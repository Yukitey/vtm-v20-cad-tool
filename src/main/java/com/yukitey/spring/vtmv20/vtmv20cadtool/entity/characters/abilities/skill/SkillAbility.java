package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.Specialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.EnumAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.List;

/**
 * Перечисление Навыков (Skills).
 * <p>
 * Навыки — это приобретённые умения, требующие обучения и практики.
 * Броски на Навыки без вложенных очков увеличивают сложность на 1.
 * <p>
 * Специализация позволяет уточнить сферу применения навыка.
 */
@Getter
@AllArgsConstructor
public enum SkillAbility implements EnumAbility {

    /**
     * Вождение (Drive).
     * Управление транспортными средствами.
     */
    DRIVE("Вождение", DriveSpecialization.class),

    /**
     * Воровство (Larceny).
     * Криминальные навыки: взлом замков, карманные кражи, угон.
     */
    LARCENY("Воровство", LarcenySpecialization.class),

    /**
     * Выживание (Survival).
     * Ориентация, добыча пищи и укрытие в дикой природе.
     */
    SURVIVAL("Выживание", SurvivalSpecialization.class),

    /**
     * Исполнение (Performance).
     * Сценические искусства: пение, танец, актёрское мастерство.
     */
    PERFORMANCE("Исполнение", PerformanceSpecialization.class),

    /**
     * Обращение с животными (Animal Ken).
     * Дрессировка и общение с животными.
     */
    ANIMAL_KEN("Обращение с животными", AnimalKenSpecialization.class),

    /**
     * Ремесло (Crafts).
     * Создание и ремонт предметов. Специализация может быть как фиксированной, так и кастомной.
     */
    CRAFTS("Ремесло", CraftsSpecialization.class, ProfessionSkillSpecialization.class),

    /**
     * Скрытность (Stealth).
     * Незаметное перемещение и уклонение от обнаружения.
     */
    STEALTH("Скрытность", StealthSpecialization.class),

    /**
     * Стрельба (Firearms).
     * Использование огнестрельного оружия.
     */
    FIREARMS("Стрельба", FirearmsSpecialization.class),

    /**
     * Фехтование (Melee).
     * Владение холодным оружием.
     */
    MELEE("Фехтование", MeleeSpecialization.class, StyleMeleeSpecialization.class),

    /**
     * Этикет (Etiquette).
     * Знание правил поведения в различных социальных кругах.
     */
    ETIQUETTE("Этикет", EtiquetteSpecialization.class);

    /** Локализованное название умения для отображения в листе персонажа. */
    private final String displayName;

    /** Классы, содержащие возможные специализации для данного умения. */
    private final Collection<Class<? extends Specialization>> specializationClasses;

    @SafeVarargs
    SkillAbility(String displayName, Class<? extends Specialization>... specializationClasses) {
        this(displayName, List.of(specializationClasses));
    }
}