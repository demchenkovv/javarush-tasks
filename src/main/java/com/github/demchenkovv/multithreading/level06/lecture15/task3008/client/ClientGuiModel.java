package com.github.demchenkovv.multithreading.level06.lecture15.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Графический клиент. Model.
 */
public class ClientGuiModel {
    private final Set<String> allUserNames = new HashSet<>();
    private String newMessage;

    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public void addUser(String newUserName) {
        this.allUserNames.add(newUserName);
    }

    public void deleteUser(String userName) {
        this.allUserNames.remove(userName);
    }
}
