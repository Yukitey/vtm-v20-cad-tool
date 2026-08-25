package com.yukitey.spring.vtmv20.vtmv20cadtool.vampire;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.VampireCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VampireCharacterRepository extends JpaRepository<VampireCharacter, Long> {
}