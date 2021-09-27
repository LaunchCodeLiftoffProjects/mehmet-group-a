package org.launchcode.birdistheword.controllers;


import org.launchcode.birdistheword.data.SpeciesRepository;
import org.launchcode.birdistheword.models.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("species")
public class SpeciesController {

    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping
    public String displayAllSpecies(Model model) {
        model.addAttribute("title", "All Species");
        model.addAttribute("species", speciesRepository.findAll());
        return "species/index";
    }

    @GetMapping("create")
    public String displayAddSpeciesForm(Model model) {
        model.addAttribute("title", "Add Species");
        model.addAttribute(new Species());
        return "species/create";
    }

    @PostMapping("create")
    public String processAddSpeciesForm(@ModelAttribute @Valid Species newSpecies, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Species");
            model.addAttribute(new Species());
            return "species/create";
        }

        speciesRepository.save(newSpecies);
        return "redirect:";
    }

}
