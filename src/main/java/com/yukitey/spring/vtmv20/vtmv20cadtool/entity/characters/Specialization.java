package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters;

/**
 * Интерфейс, определяющий специализацию для характеристики или способности.
 * Реализуется перечислениями (Enum) для конкретных параметров персонажа.
 */
public sealed interface Specialization permits EnumSpecialization, CustomSpecialization {

    /**
     * @return Локализованное название специализации (на русском).
     */
    String getDisplayName();

    /**
     * @return Техническое имя специализации (имя константы Enum) для хранения в БД.
     */
    String name();

    /** @return Подробное описание того, как и когда применяется эта специализация */
    String getDescription();
}