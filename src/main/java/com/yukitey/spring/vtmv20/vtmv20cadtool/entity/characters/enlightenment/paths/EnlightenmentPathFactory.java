package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.enlightenment.paths;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Фабрика для получения реализаций Путей Просветления.
 * <p>
 * Автоматически регистрирует все бины, реализующие интерфейс
 * {@link EnlightenmentPath}, и предоставляет доступ к ним
 * по уникальному идентификатору {@link EnlightenmentPath#getId()}.
 */
@Slf4j
@Component
public class EnlightenmentPathFactory {

    private final Map<String, EnlightenmentPath> pathRegistry = new HashMap<>();
    private final List<EnlightenmentPath> paths;

    /**
     * Конструктор фабрики.
     * <p>
     * Spring автоматически внедрит все бины, реализующие
     * интерфейс {@link EnlightenmentPath}.
     *
     * @param paths список всех реализаций путей
     */
    public EnlightenmentPathFactory(List<EnlightenmentPath> paths) {
        this.paths = paths;
    }

    /**
     * Инициализация фабрики после создания бина.
     * <p>
     * Регистрирует все найденные реализации в реестре
     * по их уникальному идентификатору.
     */
    @PostConstruct
    public void init() {
        for (EnlightenmentPath path : paths) {
            String pathType = path.getId();
            if (pathRegistry.containsKey(pathType)) {
                log.warn("Путь с типом '{}' уже зарегистрирован. " +
                        "Будет использована последняя реализация.", pathType);
            }
            pathRegistry.put(pathType, path);
            log.info("Зарегистрирован путь: {} ({})",
                    path.getDisplayName(), pathType);
        }
    }

    /**
     * Возвращает реализацию пути по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор пути (например, "HUMANITY")
     * @return реализация пути
     * @throws IllegalArgumentException если путь с таким типом не зарегистрирован
     */
    public EnlightenmentPath getPath(String id) {
        EnlightenmentPath path = pathRegistry.get(id);
        if (path == null) {
            throw new IllegalArgumentException(
                    "Путь с типом '" + id + "' не найден. " +
                            "Доступные пути: " + pathRegistry.keySet()
            );
        }
        return path;
    }

    /**
     * Проверяет, зарегистрирован ли путь с указанным идентификатором.
     *
     * @param id уникальный идентификатор пути
     * @return true, если путь зарегистрирован
     */
    public boolean hasPath(String id) {
        return pathRegistry.containsKey(id);
    }

    /**
     * Возвращает список всех зарегистрированных идентификаторов путей.
     *
     * @return список типов путей
     */
    public List<String> getAvailablePathTypes() {
        return List.copyOf(pathRegistry.keySet());
    }

    /**
     * Возвращает список всех зарегистрированных путей.
     *
     * @return список реализаций путей
     */
    public List<EnlightenmentPath> getAllPaths() {
        return List.copyOf(pathRegistry.values());
    }
}