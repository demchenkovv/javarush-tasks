package com.github.demchenkovv.collections.level03.lecture05.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = Motorbike.class, name = "motorbike"),
        @JsonSubTypes.Type(value = RacingBike.class, name = "racingbike")
})
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}