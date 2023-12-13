package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Реализация поведенческого паттерна "Команда" (Действие, Транзакция, Action, Command) <p>
 * Команда — это поведенческий паттерн проектирования, который превращает запросы в объекты,
 * позволяя передавать их как аргументы при вызове методов, ставить запросы в очередь,
 * логировать их, а также поддерживать отмену операций. <p>
 * <a href="https://refactoring.guru/ru/design-patterns/command">refactoring.guru</a>
 */
public class CommandExecutor {
    private static final Map<Operation, Command> ALL_KNOWN_COMMANDS_MAP = new HashMap<>();

    static {
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXIT, new ExitCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.ADD, new ZipAddCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.CONTENT, new ZipContentCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.CREATE, new ZipCreateCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXTRACT, new ZipExtractCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.REMOVE, new ZipRemoveCommand());
    }

    private CommandExecutor() {
    }

    public static void execute(Operation operation) {
        try {
            Command command = ALL_KNOWN_COMMANDS_MAP.get(operation);
            command.execute();
        } catch (Exception ex) {
            System.out.println("CommandExecutor#execute(Operation operation): " + ex.getMessage());
        }
    }
}
