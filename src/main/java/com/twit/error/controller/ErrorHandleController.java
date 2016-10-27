package com.twit.error.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorHandleController {
    // 401 Error
    @RequestMapping(value = "/401", method = RequestMethod.GET)
    public String unauthorised(Model model) {
        return "/errorr/401";
    }
}
