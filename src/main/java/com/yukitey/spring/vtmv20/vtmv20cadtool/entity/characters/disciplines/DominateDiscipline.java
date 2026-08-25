package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.knowledge.KnowledgeAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.talent.TalentAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.mental.MentalCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social.SocialCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.power.DisciplinePower;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Дисциплина Доминирование (Dominate).
 * <p>
 * Доминирование позволяет вампиру управлять разумом других существ,
 * отдавая приказы, стирая воспоминания и даже вселяясь в тела.
 *
 * @see Discipline
 */
@Component
public class DominateDiscipline implements Discipline {

    public static final String ID = "DOMINATE";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getDisplayName() {
        return "Доминирование";
    }

    @Override
    public String getDescription() {
        return """
                Доминирование — это дисциплина, позволяющая вампиру управлять сознанием
                других существ. Взглянув в глаза жертвы, вампир может отдать приказ,
                который будет выполнен беспрекословно. Более искушённые мастера могут
                изменять воспоминания, создавать гипнотические установки и даже вселяться
                в тела смертных.                      
                """;
    }

    @Override
    public List<DisciplinePower> getPowers() {
        return List.of(
                // Уровень 1
                DisciplinePower.builder()
                        .level(1)
                        .name("Приказ")
                        .description("""
                                Простой односложный приказ, которому жертва должна немедленно подчиниться.
                                Приказы: беги, согласись, упади, замри, следуй за мной.
                                Нельзя приказать навредить себе.""")
                        .rollCharacteristic(SocialCharacteristic.MANIPULATION)
                        .rollAbility(TalentAbility.INTIMIDATION)
                        .build(),

                // Уровень 2
                DisciplinePower.builder()
                        .level(2)
                        .name("Внушение")
                        .description("""
                                Внушение позволяет вампиру запрограммировать жертву на выполнение
                                действия по триггеру или после задержки. Можно создать сложное
                                поведение или установить условный рефлекс.""")
                        .rollCharacteristic(SocialCharacteristic.MANIPULATION)
                        .rollAbility(TalentAbility.LEADERSHIP)
                        .build(),

                // Уровень 3
                DisciplinePower.builder()
                        .level(3)
                        .name("Забвение")
                        .description("""
                                Вампир может изменять, стирать или создавать ложные воспоминания.
                                Позволяет удалить следы своего присутствия или встроить
                                убедительную фальшивую память.""")
                        .rollCharacteristic(SocialCharacteristic.MANIPULATION)
                        .rollAbility(TalentAbility.SUBTERFUGE)
                        .build(),

                // Уровень 4
                DisciplinePower.builder()
                        .level(4)
                        .name("Порабощение")
                        .description("""
                                Полное подчинение воли жертвы. Требует длительного воздействия,
                                но в итоге жертва становится послушным инструментом воли вампира.
                                Освободиться можно только ценой огромных усилий.""")
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(TalentAbility.LEADERSHIP)
                        .build(),

                // Уровень 5
                DisciplinePower.builder()
                        .level(5)
                        .name("Вселение")
                        .description("""
                                Вампир может покинуть своё тело и вселиться в тело смертного,
                                полностью подавив его сознание. В этом состоянии можно
                                пользоваться ментальными дисциплинами через тело жертвы.""")
                        .willpowerCost(1)
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(TalentAbility.INTIMIDATION)
                        .build(),

                // Уровень 6
                DisciplinePower.builder()
                        .level(6)
                        .name("Верность")
                        .description("""
                                Жертвы Доминирования этого вампира становятся практически
                                неуязвимы для ментальных атак со стороны других Сородичей.
                                Любая попытка применить Доминирование или иное ментальное
                                воздействие против его слуг требует дополнительных усилий.""")
                        .bloodCost(1)
                        .rollCharacteristic(SocialCharacteristic.MANIPULATION)
                        .rollAbility(TalentAbility.LEADERSHIP)
                        .build(),

                // Уровень 7
                DisciplinePower.builder()
                        .level(7)
                        .name("Смирение плоти")
                        .description("""
                                Вампир может управлять телом своей жертвы, не затрагивая разум.
                                Можно остановить сердце, ослепить, оглушить или парализовать
                                жертву одним касанием или взглядом.""")
                        .bloodCost(1)
                        .willpowerCost(1)
                        .rollCharacteristic(SocialCharacteristic.MANIPULATION)
                        .rollAbility(KnowledgeAbility.MEDICINE)
                        .build(),

                // Уровень 8
                DisciplinePower.builder()
                        .level(8)
                        .name("Безраздельное господство")
                        .description("""
                                Вампир может использовать любую силу Доминирования на любом
                                знакомом ему существе, где бы оно ни находилось. Достаточно
                                знать имя или иметь мысленный образ жертвы.""")
                        .willpowerCost(2)
                        .rollCharacteristic(MentalCharacteristic.PERCEPTION)
                        .rollAbility(TalentAbility.EMPATHY)
                        .build(),

                // Уровень 9
                DisciplinePower.builder()
                        .level(9)
                        .name("Голос Крови")
                        .description("""
                                Вампир может мысленно общаться и отдавать приказы всем
                                своим потомкам (тем, кого он обратил). Эти приказы
                                воспринимаются как собственные мысли, и их невозможно
                                отследить или блокировать.""")
                        .willpowerCost(1)
                        .bloodCost(1)
                        .rollCharacteristic(SocialCharacteristic.MANIPULATION)
                        .rollAbility(TalentAbility.LEADERSHIP)
                        .build(),

                // Уровень 10
                DisciplinePower.builder()
                        .level(10)
                        .name("Абсолютное доминирование")
                        .description("""
                                Власть вампира над разумом становится абсолютной.
                                Он может мгновенно поработить любого смертного или вампира
                                младшего поколения, не встречая сопротивления. Даже старейшины
                                старших поколений подчиняются с трудом.""")
                        .willpowerCost(3)
                        .bloodCost(3)
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(TalentAbility.LEADERSHIP)
                        .build()
        );
    }
}