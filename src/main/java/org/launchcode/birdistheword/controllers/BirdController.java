package org.launchcode.birdistheword.controllers;

import org.launchcode.birdistheword.models.Bird;
import org.launchcode.birdistheword.repository.BirdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("birds")
public class BirdController {

    @Autowired
    private BirdRepo birdRepo;

    @GetMapping
    public String displayAllBirds(Model model) {
        model.addAttribute("birds", birdRepo.findAll());
        return "birds/index";
    }

    @GetMapping("log")
    public String renderAddBirdForm() {
        return "birds/log";
    }

    @PostMapping("log")
    public String processAddBirdForm(@RequestParam String species,
                                     @RequestParam String behavior,
                                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateSeen) {
        birdRepo.save(new Bird(species, behavior, dateSeen));
        return "redirect:";
    }

}
