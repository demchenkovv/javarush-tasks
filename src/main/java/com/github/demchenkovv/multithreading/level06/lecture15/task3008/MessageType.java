package com.github.demchenkovv.multithreading.level06.lecture15.task3008;

/**
 * MessageType отвечает за тип сообщений пересылаемых между клиентом и сервером.
 */
public enum MessageType {
    NAME_REQUEST,   // запрос имени
    USER_NAME,      // имя пользователя
    NAME_ACCEPTED,  // имя принято
    TEXT,           // текстовое сообщение
    USER_ADDED,     // пользователь добавлен
    USER_REMOVED;   // пользователь удален
}
