package com.example.my_portfolio_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Natalie on 7/1/2017.
 */
@Controller
@RequestMapping("")
public class PostController {
    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

}