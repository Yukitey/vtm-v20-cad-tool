package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для навыка Этикет (Etiquette).
 * Отражают знание правил поведения в различных социальных кругах.
 */
@Getter
@AllArgsConstructor
public enum EtiquetteSpecialization implements EnumSpecialization {

    /**
     * Высшее общество (High Society).
     * Знание светских манер и поведения на балах, приёмах, в аристократических кругах.
     */
    HIGH_SOCIETY("Высшее общество", "Вы легко вращаетесь среди аристократов и богачей. Применяется при посещении балов, приёмов и деловых встреч с элитой."),

    /**
     * Деловые встречи (Business).
     * Правила поведения в корпоративной среде.
     */
    BUSINESS("Деловые встречи", "Вы знаете, как вести себя в офисе и на переговорах. Применяется для заключения сделок и профессионального общения."),

    /**
     * Элизиум (Elysium).
     * Специфические правила поведения в Элизиуме Камарильи.
     */
    ELYSIUM("Элизиум", "Вы знаете, что допустимо в священных местах Камарильи. Применяется при посещении Элизиума, чтобы не оскорбить старейшин."),

    /**
     * Протоколы Шабаша (Sabbat Protocols).
     * Знание правил поведения в Шабаше.
     */
    SABBAT_PROTOCOLS("Протоколы Шабаша", "Вы понимаете законы кровавых обрядов. Применяется при общении с членами Шабаша и соблюдении их обычаев."),

    /**
     * Военный этикет (Military Etiquette).
     * Правила поведения в армии и военизированных структурах.
     */
    MILITARY_ETIQUETTE("Военный этикет", "Вы знаете субординацию и устав. Применяется при общении с военными и в военных организациях.");

    private final String displayName;
    private final String description;
}