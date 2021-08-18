package org.launchcode.birdistheword.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String displayLandingPage() {
        return "index";
    }

}
