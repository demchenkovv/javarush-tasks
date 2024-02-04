package com.github.demchenkovv.collections.level06.lecture04.task3601;

import java.util.List;

public class Model {

    public List<String> getStringDataList() {
        return new Service().getData();
    }
}
