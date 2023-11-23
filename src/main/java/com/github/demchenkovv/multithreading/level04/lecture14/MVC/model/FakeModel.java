package com.github.demchenkovv.multithreading.level04.lecture14.MVC.model;

import com.github.demchenkovv.multithreading.level04.lecture14.MVC.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("А", 1L, 1));
        usersList.add(new User("B", 2L, 1));
        modelData.setUsers(usersList);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
