package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.talent;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.Specialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.EnumAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.talent.specializations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Перечисление Талантов персонажа.
 * Таланты — это способности, которые являются врожденными или развиваются интуитивно.
 * Броски на Таланты можно выполнять, даже если у персонажа в них 0 точек.
 */
@Getter
@AllArgsConstructor
public enum TalentAbility implements EnumAbility {

    /**
     * Атлетика (Athletics).
     * Охватывает все виды общей физической подготовки: бег, прыжки, метание, плавание.
     */
    ATHLETICS("Атлетика", AthleticsSpecialization.class, SportAthleticsSpecialization.class),

    /**
     * Бдительность (Alertness).
     * Способность замечать происходящее вокруг, чувствовать засады и подмечать детали в окружении.
     */
    ALERTNESS("Бдительность", AlertnessSpecialization.class),

    /**
     * Драка (Brawl).
     * Умение сражаться голыми руками, использовать зубы, когти или подручные предметы в ближнем бою.
     */
    BRAWL("Драка", BrawlSpecialization.class, StyleBrawlSpecialization.class),

    /**
     * Запугивание (Intimidation).
     * Искусство внушать страх, будь то через физическую угрозу или силу личности.
     */
    INTIMIDATION("Запугивание", IntimidationSpecialization.class),

    /**
     * Красноречие (Expression).
     * Способность четко и артистично выражать свои мысли в устной или письменной форме.
     */
    EXPRESSION("Красноречие", ExpressionSpecialization.class),

    /**
     * Лидерство (Leadership).
     * Умение вести за собой людей, вдохновлять их и добиваться подчинения через авторитет.
     */
    LEADERSHIP("Лидерство", LeadershipSpecialization.class),

    /**
     * Уличное чутье (Streetwise).
     * Знание законов улиц, умение общаться с преступным миром и ориентироваться в теневой стороне города.
     */
    STREETWISE("Уличное чутье", StreetwiseSpecialization.class),

    /**
     * Хитрость (Subterfuge).
     * Умение скрывать свои намерения, распознавать ложь и манипулировать чужим восприятием истины.
     */
    SUBTERFUGE("Хитрость", SubterfugeSpecialization.class),

    /**
     * Шестое чувство (Awareness).
     * Интуитивная способность чувствовать присутствие сверхъестественного и мистические возмущения.
     */
    AWARENESS("Шестое чувство", AwarenessSpecialization.class),

    /**
     * Эмпатия (Empathy).
     * Способность понимать чужие эмоции, мотивы и чувствовать состояние собеседника.
     */
    EMPATHY("Эмпатия", EmpathySpecialization.class);

    /** Локализованное название таланта для отображения в листе персонажа. */
    private final String displayName;

    /** Классы, содержащие возможные специализации для данного таланта. */
    private final Collection<Class<? extends Specialization>> specializationClasses;

    @SafeVarargs
    TalentAbility(String displayName, Class<? extends Specialization>... specializationClass) {
       this(displayName, List.of(specializationClass));
    }

    @Override
    public Collection<Class<? extends Specialization>> getSpecializationClasses() {
        return specializationClasses;
    }
}