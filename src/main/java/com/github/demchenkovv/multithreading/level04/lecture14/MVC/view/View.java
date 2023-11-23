package com.github.demchenkovv.multithreading.level04.lecture14.MVC.view;

import com.github.demchenkovv.multithreading.level04.lecture14.MVC.controller.Controller;
import com.github.demchenkovv.multithreading.level04.lecture14.MVC.model.ModelData;

public interface View {

    void refresh(ModelData modelData);

    void setController(Controller controller);
}
