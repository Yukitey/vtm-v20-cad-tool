package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.clans;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.Discipline;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.DominateDiscipline;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.FortitudeDiscipline;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.PresenceDiscipline;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Реализация клана Вентру.
 * <p>
 * Вентру — аристократы и лидеры среди вампиров.
 * Они традиционно занимают высшие позиции в иерархии Камарильи
 * и стремятся к контролю над обществом смертных и Сородичей.
 * <p>
 * Изъян клана — Утончённый вкус: Вентру может питаться только
 * кровью определённой категории смертных (например, аристократов,
 * политиков, успешных бизнесменов). Кровь других категорий
 * не насыщает и вызывает отвращение.
 * <p>
 * Клановые Дисциплины: Доминирование, Стойкость, Величие.
 *
 * @see Clan
 */
@Component
public class VentrueClan implements Clan {

    /**
     * Уникальный идентификатор клана.
     * Используется для ссылок в коде и хранения в БД.
     */
    public static final String ID = "VENTRUE";

    private static final String DISPLAY_NAME = "Вентру";
    private static final String FLAW = """
            Утончённый вкус: Вентру может питаться только кровью
            определённой категории смертных (например, аристократов,
            политиков, успешных бизнесменов или людей определённой
            профессии). Кровь других категорий не восполняет запас
            крови и вызывает у вампира тошноту и отвращение.
            Категория выбирается при создании персонажа и не может
            быть изменена впоследствии.
            """;

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public String getFlaw() {
        return FLAW;
    }

    @Override
    public List<Class<? extends Discipline>> getClanDisciplines() {
        return List.of(
                DominateDiscipline.class,
                FortitudeDiscipline.class,
                PresenceDiscipline.class
        );
    }
}