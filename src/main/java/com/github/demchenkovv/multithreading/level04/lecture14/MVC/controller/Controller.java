package com.github.demchenkovv.multithreading.level04.lecture14.MVC.controller;

import com.github.demchenkovv.multithreading.level04.lecture14.MVC.model.Model;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.view.EditUserView;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.view.UsersView;

// controller cannot contain business logic, only operate with views;
// controller receives a request from the client and notifies Model about it.
public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id) {
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long id, int level) {
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }
}
