package com.yukitey.spring.vtmv20.vtmv20cadtool.health;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.AbstractCharacter;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.HealthState;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.Wound;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.strategy.WoundStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class HealthServiceImpl implements HealthService {

    @Override
    @Transactional
    public boolean applyWound(AbstractCharacter character, Wound wound) {
        return applyWounds(character, wound, 1);
    }

    @Override
    @Transactional
    public boolean applyWounds(AbstractCharacter character, Wound wound, int count) {
        if (character == null || wound == Wound.NONE || count <= 0) return false;
        if (character.getHealthState() == HealthState.DESTROYED) return false;

        List<Wound> wounds = character.getWoundPool();
        WoundStrategy strategy = character.getWoundStrategy();
        if (strategy == null) return false;

        boolean result = strategy.apply(wounds, wound, count);
        if (result) {
            // Сохраняем изменения (в реальном проекте через репозиторий)
            // characterRepository.save(character); // вызывается в сервисе, который использует этот метод
        }
        return result;
    }

    @Override
    public int getModifier(AbstractCharacter character) {
        List<Wound> wounds = character.getWoundPool();
        int lastFilled = -1;
        for (int i = 0; i < wounds.size(); i++) {
            if (wounds.get(i) != Wound.NONE) lastFilled = i;
        }
        if (lastFilled == -1) return 0;
        return getModifierForLevel(lastFilled);
    }

    protected int getModifierForLevel(int index) {
        return switch (index) {
            case 0 -> 0;
            case 1, 2 -> -1;
            case 3, 4 -> -2;
            case 5 -> -5;
            default -> 0;
        };
    }

    private HealthState getVampireState(List<Wound> wounds) {
        long agg = wounds.stream().filter(w -> w == Wound.AGGRAVATED).count();
        if (agg == wounds.size()) return HealthState.DESTROYED;
        if (wounds.stream().noneMatch(w -> w == Wound.NONE)) return HealthState.INCAPACITATED;
        return HealthState.ACTIVE;
    }

    private HealthState getMortalState(List<Wound> wounds) {
        boolean allLethalOrAgg = wounds.stream()
                .allMatch(w -> w == Wound.LETHAL || w == Wound.AGGRAVATED);
        if (allLethalOrAgg && wounds.stream().noneMatch(w -> w == Wound.NONE)) {
            return HealthState.DESTROYED;
        }
        if (wounds.stream().noneMatch(w -> w == Wound.NONE)) {
            return HealthState.INCAPACITATED;
        }
        return HealthState.ACTIVE;
    }

    private HealthState getGhostState(List<Wound> wounds) {
        if (wounds.stream().allMatch(w -> w == Wound.AGGRAVATED)) {
            return HealthState.DESTROYED;
        }
        if (wounds.stream().anyMatch(w -> w != Wound.NONE)) {
            return HealthState.INCAPACITATED; // рассеян
        }
        return HealthState.ACTIVE;
    }

    @Override
    public List<Wound> getWounds(AbstractCharacter character) {
        return Collections.unmodifiableList(character.getWoundPool());
    }

    @Override
    @Transactional
    public boolean heal(AbstractCharacter character, Wound wound) {
        if (character == null || wound == Wound.NONE) return false;
        List<Wound> wounds = character.getWoundPool();
        for (int i = wounds.size() - 1; i >= 0; i--) {
            if (wounds.get(i) == wound) {
                wounds.set(i, Wound.NONE);
                // уплотняем: сдвигаем всё вверх (чтобы не было пустот между ранами)
                compactWounds(wounds);
                return true;
            }
        }
        return false;
    }

    private void compactWounds(List<Wound> wounds) {
        // Сдвигаем все NONE в конец, сохраняя порядок остальных
        List<Wound> compacted = wounds.stream()
                .filter(w -> w != Wound.NONE)
                .toList();
        int size = wounds.size();
        wounds.clear();
        wounds.addAll(compacted);
        while (wounds.size() < size) {
            wounds.add(Wound.NONE);
        }
    }

    @Override
    @Transactional
    public void healAll(AbstractCharacter character) {
        List<Wound> wounds = character.getWoundPool();
        for (int i = 0; i < wounds.size(); i++) {
            wounds.set(i, Wound.NONE);
        }
    }
}