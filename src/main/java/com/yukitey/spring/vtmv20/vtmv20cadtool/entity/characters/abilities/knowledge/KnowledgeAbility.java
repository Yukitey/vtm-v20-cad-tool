package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.Specialization;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.EnumAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.List;

/**
 * Перечисление Знаний (Knowledges).
 * <p>
 * Знания — это теоретические познания, полученные через обучение и исследования.
 * Броски на Знания без вложенных очков невозможны (сложность 10).
 * <p>
 * Специализация позволяет уточнить область знаний.
 */
@Getter
@AllArgsConstructor
public enum KnowledgeAbility implements EnumAbility {

    /**
     * Гуманитарные науки (Academics).
     * История, литература, искусство, философия.
     */
    ACADEMICS("Гуманитарные науки", AcademicsSpecialization.class),

    /**
     * Естественные науки (Science).
     * Химия, биология, физика, астрономия.
     */
    SCIENCE("Естественные науки", ScienceSpecialization.class),

    /**
     * Законы (Law).
     * Правовые нормы, процедуры, традиции.
     */
    LAW("Законы", LawSpecialization.class),

    /**
     * Информатика (Computer).
     * Программирование, сети, безопасность.
     */
    COMPUTER("Информатика", ComputerSpecialization.class),

    /**
     * Медицина (Medicine).
     * Анатомия, хирургия, токсикология.
     */
    MEDICINE("Медицина", MedicineSpecialization.class),

    /**
     * Оккультизм (Occult).
     * Вампиры, ритуалы, призраки, демонология.
     */
    OCCULT("Оккультизм", OccultSpecialization.class),

    /**
     * Политика (Politics).
     * Государственное устройство, бюрократия, Камарилья.
     */
    POLITICS("Политика", PoliticsSpecialization.class),

    /**
     * Расследование (Investigation).
     * Судебная экспертиза, слежка, поиск информации.
     */
    INVESTIGATION("Расследование", InvestigationSpecialization.class),

    /**
     * Финансы (Finance).
     * Рынки, бухгалтерия, корпоративные финансы, теневой рынок.
     */
    FINANCE("Финансы", FinanceSpecialization.class),

    /**
     * Электроника (Technology).
     * Железо, системы безопасности, телекоммуникации, инженерия.
     */
    TECHNOLOGY("Электроника", TechnologySpecialization.class, ExpertiseKnowledgeSpecialization.class);

    private final String displayName;
    private final Collection<Class<? extends Specialization>> specializationClasses;

    @SafeVarargs
    KnowledgeAbility(String displayName, Class<? extends Specialization>... specializationClasses) {
        this(displayName, List.of(specializationClasses));
    }
}