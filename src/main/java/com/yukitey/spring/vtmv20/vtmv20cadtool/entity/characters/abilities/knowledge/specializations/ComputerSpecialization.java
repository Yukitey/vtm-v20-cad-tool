package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.specializations;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.EnumSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Специализации для знания Информатика (Computer).
 * Отражают знание компьютеров, программного обеспечения и сетей.
 */
@Getter
@AllArgsConstructor
public enum ComputerSpecialization implements EnumSpecialization {

    /**
     * Сети (Networks).
     * Понимание принципов работы компьютерных сетей, Интернета.
     */
    NETWORKS("Сети", "Вы знаете, как связаны устройства. Применяется для поиска информации, взлома сетей и мониторинга трафика."),

    /**
     * Программирование (Programming).
     * Написание кода, создание ПО.
     */
    PROGRAMMING("Программирование", "Вы создаёте программы. Применяется для разработки утилит, взлома ПО и написания скриптов."),

    /**
     * Безопасность (Security).
     * Защита систем, шифрование, обнаружение уязвимостей.
     */
    SECURITY("Безопасность", "Вы знаете, как защитить данные. Применяется для создания защищённых каналов, взлома и предотвращения атак."),

    /**
     * Социальные медиа (Social Media).
     * Использование онлайн-платформ для коммуникации и поиска информации.
     */
    SOCIAL_MEDIA("Социальные медиа", "Вы мастер управления цифровым следом. Применяется для сбора информации, ведения блогов и создания вирусов.");

    private final String displayName;
    private final String description;
}