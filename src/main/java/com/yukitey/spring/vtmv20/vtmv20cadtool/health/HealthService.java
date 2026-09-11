package com.yukitey.spring.vtmv20.vtmv20cadtool.health;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.AbstractCharacter;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.HealthState;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.Wound;

import java.util.List;

/**
 * Сервис для работы со здоровьем персонажа.
 * Вся логика нанесения урона, расчёта модификаторов и состояний вынесена сюда.
 */
public interface HealthService {

    /**
     * Нанести рану персонажу.
     * @param character персонаж (сущность, содержащая список ран)
     * @param wound тип раны
     * @return true, если рана была применена (даже если вызвала конверсию)
     */
    boolean applyWound(AbstractCharacter character, Wound wound);

    /**
     * Нанести несколько ран одного типа.
     */
    boolean applyWounds(AbstractCharacter character, Wound wound, int count);

    /**
     * Получить модификатор здоровья (штраф к действиям).
     */
    int getModifier(AbstractCharacter character);

    /**
     * Получить неизменяемый список ран (для отображения).
     */
    List<Wound> getWounds(AbstractCharacter character);

    /**
     * Лечение (удаление одной раны указанного типа).
     */
    boolean heal(AbstractCharacter character, Wound wound);

    /**
     * Полное излечение всех ран.
     */
    void healAll(AbstractCharacter character);
}