package com.yukitey.spring.vtmv20.vtmv20cadtool.vampire;

import com.yukitey.spring.vtmv20.vtmv20cadtool.common.dto.SpecializedPointValueDto;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.VampireCharacter;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.mental.MentalCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.physical.PhysicalCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.social.SocialCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.vampire.dto.VampireCharacterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VampireCharacterService {

    private final VampireCharacterRepository repository;

    public Optional<VampireCharacter> find(final String id) {
        return Optional.empty();
    }

    public List<VampireCharacter> findAll() {
        return repository.findAll();
    }

    public VampireCharacterDto createNewVampireTemplate() {
        final VampireCharacterDto template = new VampireCharacterDto();

        template.setPhysicalAttributes(
                Arrays.stream(PhysicalCharacteristic.values())
                        .collect(Collectors.toMap(
                                Function.identity(),
                                characteristic -> new SpecializedPointValueDto(1, null)
                        ))
        );

        template.setSocialAttributes(
                Arrays.stream(SocialCharacteristic.values())
                        .collect(Collectors.toMap(
                                Function.identity(),
                                characteristic -> new SpecializedPointValueDto(1, null)
                        ))
        );

        template.setMentalAttributes(
                Arrays.stream(MentalCharacteristic.values())
                        .collect(Collectors.toMap(
                                Function.identity(),
                                characteristic -> new SpecializedPointValueDto(1, null)
                        ))
        );


        return template;
    }
}