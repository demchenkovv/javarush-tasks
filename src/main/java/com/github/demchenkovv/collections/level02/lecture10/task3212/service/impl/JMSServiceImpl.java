package com.github.demchenkovv.collections.level02.lecture10.task3212.service.impl;

import com.github.demchenkovv.collections.level02.lecture10.task3212.service.Service;

public class JMSServiceImpl implements Service {

    @Override
    public void execute() {
        System.out.println("Executing the JMSService");
    }

    @Override
    public String getName() {
        return "JMSService";
    }

}
