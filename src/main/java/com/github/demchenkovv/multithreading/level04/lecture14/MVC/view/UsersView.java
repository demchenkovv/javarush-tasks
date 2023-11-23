package com.github.demchenkovv.multithreading.level04.lecture14.MVC.view;

import com.github.demchenkovv.multithreading.level04.lecture14.MVC.bean.User;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.controller.Controller;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.model.ModelData;

import java.util.List;

// UsersView is a class for displaying to the console
public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        } else {
            System.out.println("All deleted users:");
        }
        List<User> users = modelData.getUsers();
        for (User u : users) {
            System.out.println("\t" + u);
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
