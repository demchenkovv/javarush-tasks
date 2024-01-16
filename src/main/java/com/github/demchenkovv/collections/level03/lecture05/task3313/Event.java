package com.github.demchenkovv.collections.level03.lecture05.task3313;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Event {
    public String name;

    // @JsonFormat используется для указания формата при сериализации или десериализации.
    // В основном он используется с полями даты.
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, /* будет сериализовано и десериализовано как строка */
            pattern = "dd-MM-yyyy hh:mm:ss",
            timezone = "Europe/Moscow")
    public Date eventDate;

    public Event(String name) {
        this.name = name;
        eventDate = new Date();
    }
}