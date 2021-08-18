package org.launchcode.birdistheword.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("birds")
public class BirdController {

    @GetMapping
    public String displayAllBirds(Model model) {
        List<String> birds = new ArrayList<>();
        birds.add("Cardinal");
        birds.add("Bluejay");
        birds.add("Cooper's Hawk");
        birds.add("Grackle");
        model.addAttribute("birds", birds);
        return "birds/index";
    }

}
