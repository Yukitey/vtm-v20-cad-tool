package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Медицина (Medicine).
 * Отражают знание анатомии, диагностики, хирургии и других медицинских областей.
 */
@Getter
@AllArgsConstructor
public enum MedicineSpecialization implements EnumSpecialization {

    /**
     * Хирургия (Surgery).
     * Навыки проведения операций и сложных вмешательств.
     */
    SURGERY("Хирургия", "Вы умеете делать операции. Применяется для удаления пуль, восстановления органов и спасения жизней."),

    /**
     * Неотложная помощь (Emergency).
     * Оказание первой помощи и быстрая диагностика.
     */
    EMERGENCY("Неотложная помощь", "Вы действуете в критических ситуациях. Применяется для остановки кровотечений и стабилизации состояния."),

    /**
     * Токсикология (Toxicology).
     * Знание ядов, их действия и лечения отравлений.
     */
    TOXICOLOGY("Токсикология", "Вы знаете яды. Применяется для распознавания отравлений, создания антидотов и изучения токсичных веществ."),

    /**
     * Патологическая анатомия (Pathology).
     * Знание болезней, вызывающих изменения в тканях.
     */
    PATHOLOGY("Патологическая анатомия", "Вы понимаете, как болезни меняют тело. Применяется для вскрытий и установления причин смерти."),

    /**
     * Фармацевтика (Pharmacy).
     * Знание лекарств и их взаимодействия.
     */
    PHARMACY("Фармацевтика", "Вы разбираетесь в медикаментах. Применяется для выбора правильных препаратов и изготовления лекарств.");

    private final String displayName;
    private final String description;
}