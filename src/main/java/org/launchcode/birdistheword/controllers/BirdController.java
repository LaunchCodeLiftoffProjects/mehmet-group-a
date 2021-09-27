package org.launchcode.birdistheword.controllers;

import org.launchcode.birdistheword.data.BirdRepository;
import org.launchcode.birdistheword.data.SpeciesRepository;
import org.launchcode.birdistheword.models.Behavior;
import org.launchcode.birdistheword.models.Bird;
import org.launchcode.birdistheword.models.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("birds")
public class BirdController {

    @Autowired
    private BirdRepository birdRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping
    public String displayAllBirds(Model model) {
        model.addAttribute("title", "All Birds");
        model.addAttribute("birds", birdRepository.findAll());
        return "birds/index";
    }

    @GetMapping("log")
    public String displayAddBirdForm(Model model) {
        model.addAttribute("title", "Log a Bird");
        model.addAttribute("bird", new Bird());
        model.addAttribute("behaviors", Behavior.values());
        model.addAttribute("species", speciesRepository.findAll());
        return "birds/log";
    }

    @PostMapping("log")
    public String processAddBirdForm(@ModelAttribute @Valid Bird newBird,
                                     Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Log Bird");
            return "birds/log";
        }

        birdRepository.save(newBird);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteBirdForm(Model model) {
        model.addAttribute("title", "Delete Bird");
        model.addAttribute("birds", birdRepository.findAll());
        return "birds/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] birdIds) {
        if (birdIds != null) {
            for (int id : birdIds) {
                birdRepository.deleteById(id);
            }
        }
        return "redirect:";
    }


}
