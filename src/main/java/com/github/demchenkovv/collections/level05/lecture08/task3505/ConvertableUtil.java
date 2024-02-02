package com.github.demchenkovv.collections.level05.lecture08.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    // Key - объекты метода getKey, который возвращает ключ.
    // Value - элементы переданного списка, которые наследуются от Convertable, параметризованные ключом.

    public static <K, V extends Convertable<K>> Map<K, V> convert(List<V> list) {
        Map<K, V> result = new HashMap<>();
        for (V element : list) {
            result.put(element.getKey(), element);
        }
        return result;
    }
}