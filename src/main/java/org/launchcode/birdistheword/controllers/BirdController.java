package org.launchcode.birdistheword.controllers;

import org.launchcode.birdistheword.data.BirdData;
import org.launchcode.birdistheword.models.Behavior;
import org.launchcode.birdistheword.models.Bird;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("birds")
public class BirdController {

    @GetMapping
    public String displayAllBirds(Model model) {
        model.addAttribute("title", "All Birds");
        model.addAttribute("birds", BirdData.getAll());
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

        BirdData.add(newBird);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteBirdForm(Model model) {
        model.addAttribute("title", "Delete Bird");
        model.addAttribute("birds", BirdData.getAll());
        return "birds/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] birdIds) {
        if (birdIds != null) {
            for (int id : birdIds) {
                BirdData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{birdId}")
    public String displayEditBirdForm(Model model, @PathVariable int birdId) {
        Bird birdToEdit = BirdData.getById(birdId);
        model.addAttribute("bird", birdToEdit);
        String title = "Edit Bird " + birdToEdit.getSpecies() + " (id=" + birdToEdit.getId() +")";
        model.addAttribute("title", title);
        return "birds/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int birdId, String species, Behavior behavior, String dateSeen) {
        Bird birdToEdit = BirdData.getById(birdId);
        birdToEdit.setSpecies(species);
        birdToEdit.setBehavior(behavior);
        birdToEdit.setDateSeen(dateSeen);
        return "redirect:";
    }

}
