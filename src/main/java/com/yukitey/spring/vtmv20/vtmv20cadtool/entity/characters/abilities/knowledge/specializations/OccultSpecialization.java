package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Оккультизм (Occult).
 * Отражают знание мистических и сверхъестественных явлений, ритуалов и сущностей.
 */
@Getter
@AllArgsConstructor
public enum OccultSpecialization implements EnumSpecialization {

    /**
     * Вампиры (Vampires).
     * Знание происхождения, кланов и дисциплин.
     */
    VAMPIRES("Вампиры", "Вы знаете природу Сородичей. Применяется для распознавания кланов и понимания их слабостей."),

    /**
     * Ритуалы (Rituals).
     * Знание магических обрядов и церемоний.
     */
    RITUALS("Ритуалы", "Вы знакомы с тауматургией и её ритуалами. Применяется для проведения обрядов и противодействия чародейству."),

    /**
     * Призраки (Wraiths).
     * Знание духов, Подземного Мира и некромантии.
     */
    WRAITHS("Призраки", "Вы понимаете природу мёртвых. Применяется для общения с призраками и понимания загробного мира."),

    /**
     * Демонология (Demonology).
     * Знание демонов и инфернальных сущностей.
     */
    DEMONOLOGY("Демонология", "Вы знаете демонов. Применяется для распознавания их присутствия и понимания их природы.");

    private final String displayName;
    private final String description;
}