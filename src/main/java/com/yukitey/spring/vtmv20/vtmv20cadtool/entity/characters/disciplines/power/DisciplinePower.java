package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.power;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.Ability;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.Characteristic;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

/**
 * Описание силы дисциплины (статичное).
 * <p>
 * Сила — это конкретное умение, которое становится доступно
 * при достижении определённого уровня владения дисциплиной.
 * <p>
 * Каждая сила может иметь свою стоимость в крови и/или воле,
 * а также требовать проверку определённой комбинации
 * характеристики и способности.
 */
@Data
@Builder
public class DisciplinePower {

    /**
     * Уровень владения дисциплиной, на котором становится доступна сила.
     */
    private int level;

    /**
     * Название силы.
     */
    private String name;

    /**
     * Описание силы и её эффекта.
     */
    private String description;

    /**
     * Правил использования силы.
     * <p>
     * Содержит механику: стоимость активации, необходимые проверки,
     * длительность эффекта, ограничения и особые условия.
     */
    private String rules;

    /**
     * Стоимость активации в пунктах крови.
     * <p>
     * Может быть null, если активация не требует крови.
     */
    @Nullable
    private Integer bloodCost;

    /**
     * Стоимость активации в пунктах воли.
     * <p>
     * Может быть null, если активация не требует воли.
     */
    @Nullable
    private Integer willpowerCost;

    /**
     * Характеристика, используемая для проверки при активации.
     * <p>
     * Может быть null, если проверка не требуется.
     */
    @Nullable
    private Characteristic rollCharacteristic;

    /**
     * Способность, используемая для проверки при активации.
     * <p>
     * Может быть null, если проверка не требуется.
     */
    @Nullable
    private Ability rollAbility;
}