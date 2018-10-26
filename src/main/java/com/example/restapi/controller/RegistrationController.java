package com.example.restapi.controller;

import com.example.restapi.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegistrationController {
    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegister(WebRequest webRequest, Model model) {
        UserModel userModel = new UserModel();
        model.addAttribute("user", userModel);
        return  "register";
    }
}
