package com.bibliotheque.gestion.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public enum SexeType {
    MASCULIN("Masculin"),
    FEMININ("Féminin");

    @Getter
    @Setter
    private String description;

    SexeType(String description) {
        this.description = description;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SexeType fromValue(Object sexeType) {
        if (sexeType instanceof Map) {
            Map<String, Object> mapSexType = (Map<String, Object>) sexeType;
            if (mapSexType.containsKey("name")) {
                return SexeType.valueOf(mapSexType.get("name").toString());
            }
        }
        if (sexeType instanceof String) {
            return SexeType.valueOf(sexeType.toString());
        }
        throw new IllegalArgumentException(MessageFormat.format("{0} not found with the value: {1} in [{2}]", SexeType.class, sexeType, values()));
    }

    @JsonValue
    Map<String, Object> getModule() {
        return Map.of(
                "name", name(),
                "description", description
        );
    }

    public static Set<SexeType> getAllSexe() {
        return stream(values())
                .collect(Collectors.toSet());
    }
}
