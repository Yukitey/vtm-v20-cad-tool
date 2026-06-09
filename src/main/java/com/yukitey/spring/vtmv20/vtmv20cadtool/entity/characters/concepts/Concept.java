package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.concepts;

/**
 * Интерфейс, определяющий социальное амплуа (концепцию) персонажа.
 */
public interface Concept {
    /** @return Локализованное название для отображения */
    String getDisplayName();

    /** @return Полное описание концепции из книги правил */
    String getDescription();
}