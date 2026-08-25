package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.clans;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.Discipline;

import java.util.List;

/**
 * Интерфейс клана вампира.
 * <p>
 * Клан — это наследственная линия вампиров, ведущая происхождение
 * от одного из Предтеч (вампиров Третьего поколения).
 * Каждый клан обладает уникальными особенностями, изъяном и набором Дисциплин.
 *
 * @see ClanFactory
 * @see com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.VampireCharacter
 */
public interface Clan {

    /**
     * Возвращает уникальный строковый идентификатор клана.
     * <p>
     * Этот идентификатор используется для хранения в базе данных
     * и для получения конкретной реализации через {@link ClanFactory}.
     *
     * @return уникальный строковый идентификатор клана
     */
    String getId();

    /**
     * Возвращает отображаемое имя клана для пользовательского интерфейса.
     * <p>
     *
     * @return читаемое название клана
     */
    String getDisplayName();

    /**
     * Возвращает описание изъяна (недостатка) клана.
     * <p>
     * Изъян — это уникальная слабость, присущая всем членам клана.
     * Она может быть как физической (например, уродство Носферату),
     * так и психологической (вспыльчивость Бруха) или поведенческой
     * (привязанность к родной земле у Цимисхов).
     *
     * @return подробное описание кланового изъяна
     */
    String getFlaw();

    List<Class<? extends Discipline>> getClanDisciplines();
}