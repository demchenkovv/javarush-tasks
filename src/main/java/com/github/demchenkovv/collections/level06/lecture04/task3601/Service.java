package com.github.demchenkovv.collections.level06.lecture04.task3601;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public List<String> getData() {
        List<String> data = new ArrayList<>() {{
            add("First string");
            add("Second string");
            add("Third string");
        }};
        return data;
    }
}
