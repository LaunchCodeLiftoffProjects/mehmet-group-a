package org.launchcode.birdistheword.controllers;

import org.launchcode.birdistheword.data.BirdData;
import org.launchcode.birdistheword.models.Bird;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "birds/log";
    }

    @PostMapping("log")
    public String processAddBirdForm(@ModelAttribute Bird newBird) {
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

}
