package org.launchcode.birdistheword.controllers;

import org.launchcode.birdistheword.data.BirdRepository;
import org.launchcode.birdistheword.models.Behavior;
import org.launchcode.birdistheword.models.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("birds")
public class BirdController {

    @Autowired
    private BirdRepository birdRepository;

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
        return "birds/log";
    }

    @PostMapping("log")
    public String processAddBirdForm(@ModelAttribute @Valid Bird newBird,
                                     Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Log Bird");
            model.addAttribute("errorMsg", "Bad data!");
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

    @GetMapping("edit/{birdId}")
    public String displayEditBirdForm(Model model, @PathVariable("birdId") int birdId) {
        Bird bird = birdRepository.findById(birdId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid bird Id: " + birdId));
        model.addAttribute("bird", bird);
        model.addAttribute("behaviors", Behavior.values());
        return "birds/edit";
    }

    @PostMapping("edit/{birdId}")
    public String processEditForm(@PathVariable("birdId") int birdId, @Valid Bird bird, BindingResult result, Model model) {
        if (result.hasErrors()) {
            bird.setId(birdId);
            return "birds/edit";
        }
        birdRepository.save(bird);
        return "redirect:";
    }

}
