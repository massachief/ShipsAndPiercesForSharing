package ru.oogis.sns.ShipsAndPierces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TableController")
public class Controller {
    @GetMapping
    public String list(){
        return "index";
    }
}
