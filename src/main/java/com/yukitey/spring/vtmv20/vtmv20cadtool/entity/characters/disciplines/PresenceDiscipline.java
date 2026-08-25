package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.skill.SkillAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.abilities.talent.TalentAbility;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social.SocialCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.power.DisciplinePower;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Дисциплина Величие (Presence).
 * <p>
 * Величие позволяет вампиру управлять эмоциями окружающих,
 * вызывая благоговение, страх, любовь или ненависть.
 * В отличие от Доминирования, Величие не принуждает к действиям —
 * оно изменяет чувства, заставляя жертв действовать по своей воле,
 * но в интересах вампира.
 *
 * @see Discipline
 */
@Component
public class PresenceDiscipline implements Discipline {

    public static final String ID = "PRESENCE";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getDisplayName() {
        return "Величие";
    }

    @Override
    public String getDescription() {
        return """
                Величие — это дисциплина, позволяющая вампиру влиять на эмоции
                окружающих. В отличие от Доминирования, которое принуждает разум,
                Величие меняет чувства. Жертвы этой дисциплины искренне верят,
                что их решения были приняты по собственной воле.
                """;
    }

    @Override
    public List<DisciplinePower> getPowers() {
        return List.of(
                // Уровень 1
                DisciplinePower.builder()
                        .level(1)
                        .name("Благоговение")
                        .description("""
                                Вампир внушает окружающим уважение и желание прислушиваться
                                к его словам. Публика с готовностью принимает его точку зрения,
                                а противоречить становится почти невозможно.""")
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(SkillAbility.PERFORMANCE)
                        .build(),

                // Уровень 2
                DisciplinePower.builder()
                        .level(2)
                        .name("Устрашающий взор")
                        .description("""
                                Один взгляд вампира вселяет в жертву животный ужас.
                                Жертва может бежать в панике или замереть в ступоре,
                                если у неё нет достаточной силы воли.""")
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(TalentAbility.INTIMIDATION)
                        .build(),

                // Уровень 3
                DisciplinePower.builder()
                        .level(3)
                        .name("Очарование")
                        .description("""
                                Вампир вызывает у жертвы сильную эмоциональную привязанность.
                                Жертва считает его другом, возлюбленным или наставником,
                                и готова помочь ему, даже если это противоречит её интересам.""")
                        .rollCharacteristic(SocialCharacteristic.APPEARANCE)
                        .rollAbility(TalentAbility.EMPATHY)
                        .build(),

                // Уровень 4
                DisciplinePower.builder()
                        .level(4)
                        .name("Приглашение")
                        .description("""
                                Вампир может мысленно призвать к себе любое существо,
                                с которым он встречался лично. Жертва интуитивно знает,
                                где находится вампир, и стремится прийти к нему,
                                преодолевая любые препятствия.""")
                        .willpowerCost(1)
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(TalentAbility.SUBTERFUGE)
                        .build(),

                // Уровень 5
                DisciplinePower.builder()
                        .level(5)
                        .name("Преклонение")
                        .description("""
                                Вампир вызывает у окружающих благоговейный трепет,
                                сравнимый с поклонением божеству. Жертвы готовы выполнять
                                любые приказы, считая вас существом высшего порядка.
                                Даже самые сильные духом с трудом могут сопротивляться.""")
                        .willpowerCost(1)
                        .build(),

                // Уровень 6
                DisciplinePower.builder()
                        .level(6)
                        .name("Любовь")
                        .description("""
                                Вампир вызывает у жертвы чувства, аналогичные узам крови.
                                Жертва становится преданной и готовой на всё ради вампира,
                                но без мистической связи уз крови. Эффект временный.""")
                        .bloodCost(1)
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(TalentAbility.SUBTERFUGE)
                        .build(),

                // Уровень 7
                DisciplinePower.builder()
                        .level(7)
                        .name("Парализующий взор")
                        .description("""
                                Вампир может парализовать жертву одним взглядом.
                                Жертва застывает в ступоре от ужаса до конца сцены.
                                Требует 1 пункт воли.""")
                        .willpowerCost(1)
                        .rollCharacteristic(SocialCharacteristic.MANIPULATION)
                        .rollAbility(TalentAbility.INTIMIDATION)
                        .build(),

                // Уровень 8
                DisciplinePower.builder()
                        .level(8)
                        .name("Искра ярости")
                        .description("""
                                Вампир может спровоцировать ярость у одной или нескольких
                                целей. Жертвы впадают в безумную ярость и атакуют всё вокруг,
                                не делая различий между друзьями и врагами.
                                Требует 1 пункт крови.""")
                        .bloodCost(1)
                        .rollCharacteristic(SocialCharacteristic.MANIPULATION)
                        .rollAbility(TalentAbility.SUBTERFUGE)
                        .build(),

                // Уровень 9
                DisciplinePower.builder()
                        .level(9)
                        .name("Сотрудничество")
                        .description("""
                                Вампир вселяет в окружающих дух сотрудничества и единства.
                                Все, кто находится рядом, начинают работать вместе,
                                игнорируя личные конфликты и разногласия.
                                Требует 1 пункт крови.""")
                        .bloodCost(1)
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(TalentAbility.LEADERSHIP)
                        .build(),

                // Уровень 10
                DisciplinePower.builder()
                        .level(10)
                        .name("Пульс города")
                        .description("""
                                Вампир может влиять на эмоциональное состояние целого города.
                                Все жители начинают испытывать те же эмоции, что и сам
                                вампир: страх, радость, гнев или надежду.
                                Эффект длится неделю. Требует 5 пунктов крови и 2 пункта воли.
                                Для активации необходимо находиться в городе и знать его улицы.""")
                        .bloodCost(5)
                        .willpowerCost(2)
                        .rollCharacteristic(SocialCharacteristic.CHARISMA)
                        .rollAbility(TalentAbility.STREETWISE)
                        .build()
        );
    }
}