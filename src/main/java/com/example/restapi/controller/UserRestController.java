package com.example.restapi.controller;

import com.example.restapi.model.UserModel;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService service;

    /* список имеющихся пользователей */
    @RequestMapping(value = "/show/users", method = RequestMethod.GET)
    public List<UserModel> userLoginList() {
        List<UserModel> users = service.getAllUsers();
        return users;
    }

    /* добавление пользователей */

  /* отображение пользователей по ID */
  //  @RequestMapping(value = "/show/user/{id}", method = RequestMethod.GET)
   // public UserModel userLoginIDList(@PathVariable("id") int user_id) {
     //   return service.addUserLogin();
   // }
//
//    /* изменения статуса у пользователей */
//    @RequestMapping(value = "/show/user/{id}/{status}", method = RequestMethod.GET)
//    public HashMap<String, String> retrieveStatus(@PathVariable("id") int id, @PathVariable("status") String status_user) {
//        UserModel userLogins;
//        userLogins = service.retrieveUser(id);
//        if (userLogins != null) {
//            String statis_iser = userLogins.getStatus();
//            userLogins.setStatus(status_user);
//            service.updateUserLogin(userLogins);
//            return new UserModel(id, statis_iser);
//        }
//        return new UserModel("can't found id = " + id);
//    }


}
