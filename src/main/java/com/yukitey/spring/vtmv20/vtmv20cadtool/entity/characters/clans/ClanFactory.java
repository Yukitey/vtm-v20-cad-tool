package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.clans;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Фабрика для получения реализаций Кланов.
 * <p>
 * Автоматически регистрирует все бины, реализующие интерфейс
 * {@link Clan}, и предоставляет доступ к ним
 * по уникальному идентификатору {@link Clan#getId()}.
 *
 * @see Clan
 * @see com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.VampireCharacter
 */
@Slf4j
@Component
public class ClanFactory {

    private final Map<String, Clan> clanRegistry = new HashMap<>();
    private final List<Clan> clans;

    /**
     * Конструктор фабрики.
     * <p>
     * Spring автоматически внедрит все бины, реализующие интерфейс {@link Clan}.
     *
     * @param clans список всех реализаций кланов
     */
    public ClanFactory(List<Clan> clans) {
        this.clans = clans;
    }

    /**
     * Инициализация фабрики после создания бина.
     * <p>
     * Регистрирует все найденные реализации в реестре
     * по их уникальному идентификатору {@link Clan#getId()}.
     */
    @PostConstruct
    public void init() {
        for (Clan clan : clans) {
            String id = clan.getId();
            if (clanRegistry.containsKey(id)) {
                log.warn("Клан с ID '{}' уже зарегистрирован. Будет использована последняя реализация.", id);
            }
            clanRegistry.put(id, clan);
            log.info("Зарегистрирован клан: {} ({})", clan.getDisplayName(), id);
        }
    }

    /**
     * Возвращает реализацию клана по его уникальному идентификатору.
     *
     * @param id уникальный идентификатор клана (например, "VENTRUE")
     * @return реализация клана
     * @throws IllegalArgumentException если клан с таким ID не зарегистрирован
     */
    public Clan getClan(String id) {
        Clan clan = clanRegistry.get(id);
        if (clan == null) {
            throw new IllegalArgumentException(
                    "Клан с ID '" + id + "' не найден. Доступные кланы: " + clanRegistry.keySet()
            );
        }
        return clan;
    }

    /**
     * Проверяет, зарегистрирован ли клан с указанным идентификатором.
     *
     * @param id уникальный идентификатор клана
     * @return true, если клан зарегистрирован
     */
    public boolean hasClan(String id) {
        return clanRegistry.containsKey(id);
    }

    /**
     * Возвращает список всех зарегистрированных идентификаторов кланов.
     *
     * @return список ID кланов
     */
    public List<String> getAvailableClanIds() {
        return List.copyOf(clanRegistry.keySet());
    }

    /**
     * Возвращает список всех зарегистрированных кланов.
     *
     * @return список реализаций кланов
     */
    public List<Clan> getAllClans() {
        return List.copyOf(clanRegistry.values());
    }
}