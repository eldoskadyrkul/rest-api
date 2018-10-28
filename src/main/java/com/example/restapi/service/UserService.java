package com.example.restapi.service;


import com.example.restapi.model.UserModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final Log LOG = LogFactory.getLog(UserService.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static int count = 2;

    /* добавление пользователя */
    public void addUser(String firstName, String lastName, String status, String email, String username, String password) {
        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(new UserModel(++count, firstName, lastName, status, email, username, password));
    }

    /* изменение статуса */
    public List<UserModel> retrieveStatus(String status) {
        List<UserModel> users = new ArrayList<>();
        List<UserModel> filteredStat = new ArrayList<>();
        for (UserModel userModel : users) {
            if (userModel.getStatus().equalsIgnoreCase(status)) {
                filteredStat.add(userModel);
            }
        }
        return filteredStat;
    }

    /* изменение пользователя */
    public void updateUserLogin(UserModel userLogin) {
//        users.remove(userLogin);
//        users.add(userLogin);
    }

    /* удаление пользователя */
    public void deleteUserLogin(int user_id) {
//        Iterator<UserModel> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            UserModel userLogin = iterator.next();
//            if (userLogin.getId() == user_id) {
//                iterator.remove();
//            }
//        }
    }

    /* валидация пользователя */
    public boolean validateUser(UserModel userLogin, String user, String pwd) {
        return user.equalsIgnoreCase(userLogin.getUsername()) && pwd.equalsIgnoreCase(userLogin.getPassword());
    }

    /* получение всех юзеров */
    public List<UserModel> getAllUsers() {
        try {
            File file = ResourceUtils.getFile("classpath:users.json");
            return OBJECT_MAPPER.readValue(file, new TypeReference<List<UserModel>>() {});
        } catch (FileNotFoundException e) {
            LOG.error("can't find users.json", e);
        } catch (IOException e) {
            LOG.error("can't read users.json", e);
        }
        return new ArrayList<>();
    }

//    /* поиск по идентификационному номеру */
//    public UserModel retrieveUser(int user_id) {
//        for (UserModel user :
//                users)
//        {
//            if (user.getId() == user_id) {
//                return user;
//            }
//        }
//        return null;
//    }
}
