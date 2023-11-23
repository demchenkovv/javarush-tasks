package com.github.demchenkovv.multithreading.level04.lecture14.MVC.model;

import com.github.demchenkovv.multithreading.level04.lecture14.MVC.bean.User;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.model.service.UserService;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    // use helpful services
    private UserService userService = new UserServiceImpl();
    // use special object to keep data for view rendering
    private ModelData modelData = new ModelData();

    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        List<User> result = userService.getAllDeletedUsers();
        modelData.setDisplayDeletedUserList(true);
        // refresh model data
        modelData.setUsers(result);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
        loadUsers();
    }

    @Override
    public void deleteUserById(long id) {
        User user = userService.deleteUser(id);
        modelData.setActiveUser(user);
        loadUsers();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        User user = userService.createOrUpdateUser(name, id, level);
        modelData.setActiveUser(user);
        loadUsers();
    }

    private List<User> getAllUsers() {
        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(allUsers);
    }
}
