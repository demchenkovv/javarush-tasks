package com.github.demchenkovv.multithreading.level04.lecture14.MVC;

import com.github.demchenkovv.multithreading.level04.lecture14.MVC.controller.Controller;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.model.MainModel;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.model.Model;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.view.EditUserView;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();

        // init
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        // inject controller
        usersView.setController(controller);
        editUserView.setController(controller);

        // inject model and views
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        // emulate user events
        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Dudkin", 125L, 80);
        usersView.fireEventShowDeletedUsers();
    }
}