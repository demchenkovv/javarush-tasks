package com.github.demchenkovv.collections.level02.lecture10.task3212.service.impl;

import com.github.demchenkovv.collections.level02.lecture10.task3212.service.Service;

public class EJBServiceImpl implements Service {

    @Override
    public void execute() {
        System.out.println("Executing the EJBService");
    }

    @Override
    public String getName() {
        return "EJBService";
    }

}
