package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Фабрика для получения реализаций Дисциплин.
 * <p>
 * Автоматически регистрирует все бины, реализующие интерфейс {@link Discipline}.
 * Дисциплины являются синглтонами — существует ровно один экземпляр
 * описания каждой дисциплины, который используется для всех персонажей.
 * <p>
 * Реализации должны быть помечены аннотацией {@link org.springframework.stereotype.Component}
 * и автоматически обнаружены Spring-контейнером.
 *
 * @see Discipline
 * @see com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.VampireCharacter
 */
@Slf4j
@Component
public class DisciplineFactory {

    private final Map<String, Discipline> disciplineRegistry = new HashMap<>();
    private final List<Discipline> disciplines;

    /**
     * Конструктор фабрики.
     * <p>
     * Spring автоматически внедрит все бины, реализующие интерфейс {@link Discipline}.
     *
     * @param disciplines список всех реализаций дисциплин
     */
    public DisciplineFactory(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    /**
     * Инициализация фабрики после создания бина.
     * <p>
     * Регистрирует все найденные реализации в реестре
     * по их уникальному идентификатору {@link Discipline#getId()}.
     */
    @PostConstruct
    public void init() {
        for (Discipline discipline : disciplines) {
            String id = discipline.getId();
            if (disciplineRegistry.containsKey(id)) {
                log.warn("Дисциплина с ID '{}' уже зарегистрирована. Будет использована последняя реализация.", id);
            }
            disciplineRegistry.put(id, discipline);
            log.info("Зарегистрирована дисциплина: {} ({})", discipline.getDisplayName(), id);
        }
    }

    /**
     * Возвращает реализацию дисциплины по её уникальному идентификатору.
     *
     * @param id уникальный идентификатор дисциплины (например, "CELERITY")
     * @return реализация дисциплины
     * @throws IllegalArgumentException если дисциплина с таким ID не зарегистрирована
     */
    public Discipline getDiscipline(String id) {
        Discipline discipline = disciplineRegistry.get(id);
        if (discipline == null) {
            throw new IllegalArgumentException(
                    "Дисциплина с ID '" + id + "' не найдена. " +
                            "Доступные дисциплины: " + disciplineRegistry.keySet()
            );
        }
        return discipline;
    }

    /**
     * Проверяет, зарегистрирована ли дисциплина с указанным ID.
     *
     * @param id уникальный идентификатор дисциплины
     * @return true, если дисциплина зарегистрирована
     */
    public boolean hasDiscipline(String id) {
        return disciplineRegistry.containsKey(id);
    }

    /**
     * Возвращает список всех зарегистрированных идентификаторов дисциплин.
     *
     * @return список ID дисциплин
     */
    public List<String> getAvailableIds() {
        return List.copyOf(disciplineRegistry.keySet());
    }

    /**
     * Возвращает список всех зарегистрированных дисциплин.
     *
     * @return список реализаций дисциплин
     */
    public List<Discipline> getAllDisciplines() {
        return List.copyOf(disciplineRegistry.values());
    }

    /**
     * Возвращает список основных дисциплин (не путей).
     *
     * @return список основных дисциплин
     */
    public List<Discipline> getMainDisciplines() {
        return disciplineRegistry.values().stream()
                .filter(d -> !d.isPath())
                .collect(Collectors.toList());
    }

    /**
     * Возвращает список путей (дисциплин, являющихся путями).
     *
     * @return список путей
     */
    public List<Discipline> getPaths() {
        return disciplineRegistry.values().stream()
                .filter(Discipline::isPath)
                .collect(Collectors.toList());
    }

    /**
     * Возвращает список путей для указанной родительской дисциплины.
     *
     * @param parentId идентификатор родительской дисциплины
     * @return список путей, принадлежащих родительской дисциплине
     */
    public List<Discipline> getPathsForParent(String parentId) {
        Discipline parent = getDiscipline(parentId);
        return disciplineRegistry.values().stream()
                .filter(d -> d.isPath() && d.getParentDiscipline() != null &&
                        d.getParentDiscipline().getId().equals(parentId))
                .collect(Collectors.toList());
    }
}