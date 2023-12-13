package com.github.demchenkovv.multithreading.level07.lecture15.task3110.command;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.ConsoleHelper;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        try {
            ConsoleHelper.writeMessage("До встречи!");
        } catch (Exception ignored) {
        }
    }
}
