package com.example.restapi.controller;

import com.example.restapi.model.UserModel;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegister(WebRequest webRequest, Model model) {
        UserModel userModel = new UserModel();
        model.addAttribute("user", userModel);
        return  "register";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String processConfirmationView(@ModelAttribute("user") @Valid UserModel accountDto,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        service.addUser(accountDto.getFirstName(), accountDto.getLastName(), accountDto.getStatus(), accountDto.getEmail(),
                accountDto.getUsername(), accountDto.getPassword());
        return "redirect:/welcome";
    }

}
