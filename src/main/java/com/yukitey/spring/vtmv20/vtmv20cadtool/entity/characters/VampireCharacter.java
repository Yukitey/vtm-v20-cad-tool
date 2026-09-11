package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.clans.Clan;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.clans.ClanFactory;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.clans.VentrueClan;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.enlightenment.paths.EnlightenmentPath;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.enlightenment.paths.EnlightenmentPathFactory;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.enlightenment.paths.HumanityEnlightenmentPath;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.HealthState;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.strategy.VampireWoundStrategy;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.strategy.WoundStrategy;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point.BackgroundPointValue;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.point.SimplePointValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Сущность персонажа-вампира.
 * <p>
 * Наследует все базовые параметры из {@link AbstractCharacter}
 * и добавляет вампирскую специфику:
 * <ul>
 *     <li>Клан и его изъян</li>
 *     <li>Поколение (определяет силу Крови)</li>
 *     <li>Путь Просветления (или Человечность)</li>
 *     <li>Дисциплины (сверхъестественные способности)</li>
 *     <li>Факты биографии (социальные активы)</li>
 *     <li>Запас крови</li>
 * </ul>
 *
 * @see AbstractCharacter
 * @see EnlightenmentPath
 */
@Entity
@Table(name = "vampire_characters")
@Getter
@Setter
public class VampireCharacter extends AbstractCharacter {

    private static final WoundStrategy STRATEGY = new VampireWoundStrategy();

    // === Клан и Поколение ===

    /**
     * Клан вампира.
     * Определяет набор Дисциплин, изъян и культурные особенности.
     */
    @Column(name = "clan_id")
    private String clanId;

    /**
     * Поколение — количество шагов от Каина.
     * Диапазон: от 4 (очень древний) до 15 (слабокровный).
     * Влияет на максимальный запас крови и предел траты крови за ход.
     */
    @Column(name = "generation")
    private Integer generation;

    // === Дисциплины и Факты биографии ===

    @ElementCollection
    @CollectionTable(name = "char_disciplines", joinColumns = @JoinColumn(name = "character_id"))
    @AttributeOverride(name = "dots", column = @Column(name = "discipline_dots_value"))
    private Map<String, SimplePointValue> disciplines = new HashMap<>();

    @ElementCollection
    @CollectionTable(
            name = "char_backgrounds",
            joinColumns = @JoinColumn(name = "character_id")
    )
    @MapKeyColumn(name = "background_id")
    private Map<String, BackgroundPointValue> backgrounds = new HashMap<>();

    // === Путь Просветления ===

    /**
     * Тип Пути Просветления (строковый идентификатор).
     * Например: "HUMANITY", "PATH_OF_CAINE" и т.д.
     */
    @Column(name = "enlightenment_path_id")
    private String enlightenmentPathId;


    /**
     * Транзиентный метод для получения объекта клана через фабрику.
     * <p>
     * Используется для логики, не хранится в БД.
     *
     * @param clanFactory фабрика клана (внедряется через сервис)
     * @return реализация интерфейса Clan
     */
    @Transient
    public Clan getPath(ClanFactory clanFactory) {
        if (clanId == null) {
            return clanFactory.getClan(VentrueClan.ID); // по умолчанию
        }
        return clanFactory.getClan(clanId);
    }

    /**
     * Транзиентный метод для получения объекта Пути через фабрику.
     * <p>
     * Используется для логики, не хранится в БД.
     *
     * @param pathFactory фабрика путей (внедряется через сервис)
     * @return реализация интерфейса EnlightenmentPath
     */
    @Transient
    public EnlightenmentPath getPath(EnlightenmentPathFactory pathFactory) {
        if (enlightenmentPathId == null) {
            return pathFactory.getPath(HumanityEnlightenmentPath.ID); // по умолчанию
        }
        return pathFactory.getPath(enlightenmentPathId);
    }


    /**
     * Текущий запас крови (Blood Pool).
     * Максимальное значение зависит от поколения.
     */
    @Column(name = "blood_pool")
    private Integer bloodPool;


    @Override
    public WoundStrategy getWoundStrategy() {
        return STRATEGY;
    }
}