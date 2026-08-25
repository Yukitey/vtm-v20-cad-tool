package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.disciplines.power.DisciplinePower;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Дисциплина Стойкость (Fortitude).
 * <p>
 * Стойкость — это <b>пассивная</b> дисциплина, которая увеличивает
 * выносливость и живучесть вампира.
 * <p>
 * Эффекты Стойкости:
 * <ul>
 *     <li>Каждый уровень добавляет +1 кубик к проверкам на прочность
 *         против обычного (лёгкого и тяжёлого) урона.</li>
 *     <li>Позволяет использовать Стойкость для проверок на прочность
 *         против <b>губительных</b> повреждений (огонь, солнечный свет,
 *         клыки вампиров, когти оборотней).</li>
 * </ul>
 * <p>
 * В отличие от активных дисциплин (например, Доминирование),
 * Стойкость не имеет отдельных сил на каждый уровень.
 *
 * @see Discipline
 */
@Component
public class FortitudeDiscipline implements Discipline {

    public static final String ID = "FORTITUDE";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getDisplayName() {
        return "Стойкость";
    }

    @Override
    public String getDescription() {
        return """
                Стойкость — это пассивная дисциплина, дарующая вампиру
                невероятную живучесть. Каждый уровень Стойкости добавляет
                1 кубик к проверкам на прочность против физических повреждений.
                                
                Кроме того, Стойкость позволяет сопротивляться губительным
                повреждениям (огню, солнечному свету, клыкам и когтям),
                используя проверку Стойкости вместо обычной проверки
                на прочность.
                """;
    }

    @Override
    public List<DisciplinePower> getPowers() {
        // Стойкость — пассивная дисциплина, не имеет сил
        return List.of();
    }
}