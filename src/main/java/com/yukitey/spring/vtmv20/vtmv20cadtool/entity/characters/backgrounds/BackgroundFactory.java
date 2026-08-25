package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.backgrounds;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Фабрика для получения определений фактов биографии.
 * <p>
 * Автоматически регистрирует все бины, реализующие интерфейс {@link Background}.
 * <p>
 * Реализации должны быть помечены аннотацией {@link org.springframework.stereotype.Component}
 * и автоматически обнаружены Spring-контейнером.
 *
 * @see Background
 */
@Slf4j
@Component
public class BackgroundFactory {

    private final Map<String, Background> registry = new HashMap<>();
    private final List<Background> backgrounds;

    public BackgroundFactory(List<Background> backgrounds) {
        this.backgrounds = backgrounds;
    }

    @PostConstruct
    public void init() {
        for (Background background : backgrounds) {
            String id = background.getId();
            if (registry.containsKey(id)) {
                log.warn("Факт биографии с ID '{}' уже зарегистрирован. Будет использована последняя реализация.", id);
            }
            registry.put(id, background);
            log.info("Зарегистрирован факт биографии: {} ({})", background.getDisplayName(), id);
        }
    }

    /**
     * Возвращает определение факта биографии по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор факта (например, "RESOURCES")
     * @return реализация интерфейса {@link Background}
     * @throws IllegalArgumentException если факт с таким ID не зарегистрирован
     */
    public Background getBackground(String id) {
        Background background = registry.get(id);
        if (background == null) {
            throw new IllegalArgumentException(
                    "Факт биографии с ID '" + id + "' не найден. " +
                            "Доступные факты: " + registry.keySet()
            );
        }
        return background;
    }

    /**
     * Проверяет, зарегистрирован ли факт биографии с указанным идентификатором.
     *
     * @param id уникальный идентификатор факта
     * @return true, если факт зарегистрирован
     */
    public boolean hasBackground(String id) {
        return registry.containsKey(id);
    }

    /**
     * Возвращает список всех зарегистрированных идентификаторов фактов биографии.
     *
     * @return список ID фактов
     */
    public List<String> getAvailableIds() {
        return List.copyOf(registry.keySet());
    }

    /**
     * Возвращает список всех зарегистрированных фактов биографии.
     *
     * @return список реализаций {@link Background}
     */
    public List<Background> getAll() {
        return List.copyOf(registry.values());
    }
}