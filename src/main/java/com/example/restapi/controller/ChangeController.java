package com.example.restapi.controller;

import com.example.restapi.model.UserModel;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChangeController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/user/{status}", method = RequestMethod.GET)
    public UserModel editStatus(@PathVariable("status") String stat) {
        return (UserModel) service.retrieveStatus(stat);
    }
}
