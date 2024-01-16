package com.github.demchenkovv.collections.level03.lecture05.task3311;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class RealBean {
    protected final int id;
    protected final String name;

    protected Map<String, Object> additionalMap = new HashMap<>();

    @JsonCreator
    public RealBean(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Аннотация @JsonAnyGetter позволяет сериализовать Map как обычные свойства класса, без вложенности.
    // @JsonAnyGetter позволяет методу getter возвращать Map, который затем используется для сериализации
    // дополнительных свойств JSON аналогично другим свойствам.
    // Как и в случае с JsonAnySetter, только одно свойство должно быть аннотировано этой аннотацией; если
    // аннотировано несколько методов, может быть выброшено исключение.
    @JsonAnyGetter
    public Map<String, Object> getAdditionalMap() {
        return additionalMap;
    }

    // @JsonAnySetter позволяет использовать метод setter для Map, который затем используется для
    // десериализации дополнительных свойств JSON аналогично другим свойствам.
    @JsonAnySetter
    public void setAdditionalMap(String name, Object value) {
        additionalMap.put(name, value);
    }
}