package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.strategy;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.HealthState;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.health.Wound;

import java.util.List;

public class VampireWoundStrategy implements WoundStrategy {
    @Override
    public boolean apply(List<Wound> woundPool, Wound wound, int count) {
        if (wound == Wound.NONE || count <= 0) return false;

        for (int i = 0; i < count; i++) {
            if (woundPool.stream().allMatch(w -> w == Wound.LIGHT)) {
                if (wound == Wound.AGGRAVATED) {
                    insertWound(woundPool, wound);
                } else {
                    convertTopLightToLethal(woundPool);
                }
            } else {
                insertWound(woundPool, wound);
            }
        }
        return true;
    }

    private void insertWound(List<Wound> pool, Wound wound) {
        int idx = 0;
        while (idx < pool.size() &&
                pool.get(idx) != Wound.NONE &&
                pool.get(idx).getSeverity() > wound.getSeverity()) {
            idx++;
        }
        pool.add(idx, wound);
        pool.remove(pool.size() - 1);
    }

    private void convertTopLightToLethal(List<Wound> pool) {
        for (int i = 0; i < pool.size(); i++) {
            if (pool.get(i) == Wound.LIGHT) {
                pool.set(i, Wound.LETHAL);
                return;
            }
        }
    }

    public HealthState getHealthState(List<Wound> woundPool) {
        long agg = woundPool.stream().filter(w -> w == Wound.AGGRAVATED).count();
        long lethal = woundPool.stream().filter(w -> w == Wound.LETHAL).count();
        long light = woundPool.stream().filter(w -> w == Wound.LIGHT).count();

        if (agg == woundPool.size()) {
            return HealthState.DESTROYED;
        }

        if (lethal == woundPool.size() && agg == 0) {
            return HealthState.INCAPACITATED;
        }

        if (light == woundPool.size()) {
            return HealthState.INCAPACITATED;
        }

        if (woundPool.stream().anyMatch(w -> w != Wound.NONE)) {
            return HealthState.ACTIVE;
        }

        return HealthState.ACTIVE;
    }
}