package com.yukitey.spring.vtmv20.vtmv20cadtool.vampire;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.Characteristics;
import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.characteristics.physical.PhysicalCharacteristic;
import com.yukitey.spring.vtmv20.vtmv20cadtool.vampire.dto.VampireCharacterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/vampires")
@RequiredArgsConstructor
public class VampireCharacterController {

    private final VampireCharacterService vampireCharacterService;

    @RequestMapping
    public String vampires(final Model model) {
        model.addAttribute("title", "Вампиры");
        model.addAttribute("description", "Все персонажи типа «Вампир»");

        return "vampire/index";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable final String id, final Model model) {
        model.addAttribute("title", "Вампиры");
        model.addAttribute("description", "Все персонажи типа «Вампир»");

        return "vampire/index";
    }

    @RequestMapping("/add")
    public String add(final Model model) {
        model.addAttribute("title", "Создание вампира");
        model.addAttribute("description", "Создание персонажа типа «Вампир»");

        model.addAttribute("vampireCharacter", vampireCharacterService.createNewVampireTemplate());

        return "vampire/add";
    }

    @PostMapping("/add")
    public String create(
            @ModelAttribute("vampireCharacter") final VampireCharacterDto vampireCharacter,
            final BindingResult bindingResult,
            final Model model
    ) {

        return "vampire/add";
    }
}