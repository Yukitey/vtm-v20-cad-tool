package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.enlightenment.paths;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.virtue.ConscienceOrConviction;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.virtue.SelfControlOrInstinct;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Реализация Пути Человечности (Humanity).
 * <p>
 * Это базовый и наиболее распространённый путь для вампиров.
 * Он основан на сохранении человеческих ценностей, морали
 * и сострадания к смертным.
 * <p>
 * Столп: Нормальность (Normality) — способность сливаться
 * с человеческим обществом и сохранять человеческие черты.
 * <p>
 * Добродетели: Совесть (Conscience) + Самообладание (Self-Control).
 * <p>
 * Иерархия грехов соответствует главе 7 книги правил V20.
 */
@Component
public class HumanityEnlightenmentPath implements EnlightenmentPath {

    public static final String ID = "HUMANITY";
    private static final String DISPLAY_NAME = "Человечность (Humanity)";
    private static final String PILLAR = "Нормальность (Normality)";
    private static final String DESCRIPTION = """
            Человечность — это моральный компас, который позволяет вампиру
            сохранять связь с тем, кем он был при жизни.
            Этот путь основан на эмпатии, сострадании и уважении к жизни.
            Вампиры, следующие этим путём, стараются минимизировать вред,
            причиняемый смертным, и сохранять человеческие ценности.
            """;

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public String getPillar() {
        return PILLAR;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public ConscienceOrConviction getMoralityChoice() {
        return ConscienceOrConviction.CONSCIENCE;
    }

    @Override
    public SelfControlOrInstinct getControlChoice() {
        return SelfControlOrInstinct.SELF_CONTROL;
    }

    @Override
    public List<EnlightenmentPathSin> getSinHierarchy() {
        return List.of(
                // Ранг 10 — Самый лёгкий проступок
                EnlightenmentPathSin.builder()
                        .gravityRank(10)
                        .description("Эгоистичные помыслы")
                        .example("Подумать о своей выгоде в ущерб другим, не переходя к действиям")
                        .build(),

                // Ранг 9
                EnlightenmentPathSin.builder()
                        .gravityRank(9)
                        .description("Эгоистичные поступки")
                        .example("Отказать в помощи нуждающемуся, когда это не требует значительных усилий")
                        .build(),

                // Ранг 8
                EnlightenmentPathSin.builder()
                        .gravityRank(8)
                        .description("Причинение вреда другому существу")
                        .example("Случайно ранить человека во время охоты или в драке")
                        .build(),

                // Ранг 7
                EnlightenmentPathSin.builder()
                        .gravityRank(7)
                        .description("Воровство")
                        .example("Украсть деньги у смертного или присвоить чужую собственность")
                        .build(),

                // Ранг 6
                EnlightenmentPathSin.builder()
                        .gravityRank(6)
                        .description("Непредумышленные преступления")
                        .example("Осушение сосуда из-за сильного голода, когда персонаж теряет контроль")
                        .build(),

                // Ранг 5
                EnlightenmentPathSin.builder()
                        .gravityRank(5)
                        .description("Умышленное уничтожение чужой собственности")
                        .example("Поджечь дом врага или разгромить его офис")
                        .build(),

                // Ранг 4
                EnlightenmentPathSin.builder()
                        .gravityRank(4)
                        .description("Преступления в состоянии аффекта")
                        .example("Убийство или осушение сосуда в приступе ярости, когда персонаж не контролирует себя")
                        .build(),

                // Ранг 3
                EnlightenmentPathSin.builder()
                        .gravityRank(3)
                        .description("Предумышленные преступления")
                        .example("Преднамеренное убийство или осушение сосуда в здравом уме и холодной крови")
                        .build(),

                // Ранг 2
                EnlightenmentPathSin.builder()
                        .gravityRank(2)
                        .description("Бессмысленные преступления")
                        .example("Бездумные убийства ради забавы, питание не ради насыщения, а ради удовольствия")
                        .build(),

                // Ранг 1 — Самый тяжёлый грех
                EnlightenmentPathSin.builder()
                        .gravityRank(1)
                        .description("Самые гнусные и изуверские преступления")
                        .example("Пытки, каннибализм, диаблери, массовые убийства невинных")
                        .build()
        );
    }
}