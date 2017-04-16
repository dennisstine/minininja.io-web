package io.minininja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main index controller.
 *
 * Created by Dennis on 4/14/2017.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public ModelAndView index() {

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("fragmentInclude", "fragments/home");
        return mav;
    }
}
