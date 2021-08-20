package org.launchcode.birdistheword.controllers;

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

    private static Map<String, String> birds = new HashMap<>();

    @GetMapping
    public String displayAllBirds(Model model) {
        model.addAttribute("birds", birds);
        return "birds/index";
    }

    @GetMapping("log")
    public String renderAddBirdForm() {
        return "birds/log";
    }

    @PostMapping("log")
    public String processAddBirdForm(@RequestParam String species, @RequestParam String behavior) {
        birds.put(species, behavior);
        return "redirect:";
    }

}
