package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.strategy;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.HealthState;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.Wound;

import java.util.List;

/**
 * Стратегия применения и лечения ран для различных типов существ.
 * <p>
 * Реализации определяют правила вставки/конверсии урона и удаления ран.
 * </p>
 */
public interface WoundStrategy {
    /**
     * Применяет рану (или несколько ран одного типа) к пулу.
     *
     * @param woundPool текущее состояние (изменяемый список)
     * @param wound тип наносимой раны
     * @param count количество ран одного типа
     * @return true, если раны были применены
     */
    boolean apply(List<Wound> woundPool, Wound wound, int count);

    /**
     * Лечит указанное количество ран заданного типа, удаляя их снизу вверх.
     *
     * @param woundPool текущий список ран (изменяемый)
     * @param wound     тип раны для лечения
     * @param count     количество ран для лечения
     * @return true, если хотя бы одна рана была удалена
     */
    default boolean heal(List<Wound> woundPool, Wound wound, int count) {
        int removed = 0;
        // Идём с конца списка (самая нижняя рана)
        for (int i = woundPool.size() - 1; i >= 0 && removed < count; i--) {
            if (woundPool.get(i) == wound) {
                woundPool.set(i, Wound.NONE);
                removed++;
            }
        }
        return removed > 0;
    }

    /**
     * Полностью излечивает все раны, заполняя пул значением {@link Wound#NONE}.
     *
     * @param woundPool текущий список ран (изменяемый)
     */
    default void healAll(List<Wound> woundPool) {
        for (int i = 0; i < woundPool.size(); i++) {
            woundPool.set(i, Wound.NONE);
        }
    }

    /**
     * Определяет текущее состояние здоровья на основе пула ран.
     * <p>
     * Каждая стратегия обязана реализовать этот метод,
     * так как правила состояния зависят от типа существа.
     * </p>
     *
     * @param woundPool текущий список ран
     * @return состояние здоровья
     */
    HealthState getHealthState(List<Wound> woundPool);
}