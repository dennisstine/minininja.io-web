package io.minininja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main index controller.
 *
 * Created by Dennis on 4/14/2017.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index() {
        return "index";
    }
}
