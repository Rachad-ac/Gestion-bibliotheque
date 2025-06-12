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

public enum NationaliteType {
    SENEGAL("Senegal"),
    FRANCE("France"),
    GERMANY("Germany"),
    USA("United States of America"),
    CANADA("Canada"),
    UK("United Kingdom"),
    JAPAN("Japan"),
    CHINA("China"),
    INDIA("India"),
    BRAZIL("Brazil");

    @Getter
    @Setter
    private String description;

    NationaliteType(String description) {
        this.description = description;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static NationaliteType fromValue(Object nationalite) {
        if (nationalite instanceof Map) {
            Map<String, Object> mapNationalite = (Map<String, Object>) nationalite;
            if (mapNationalite.containsKey("name")) {
                return NationaliteType.valueOf(mapNationalite.get("name").toString());
            }
        }
        if (nationalite instanceof String) {
            return NationaliteType.valueOf(nationalite.toString());
        }
        throw new IllegalArgumentException(MessageFormat.format("{0} not found with the value: {1} in [{2}]", SexeType.class, nationalite, values()));
    }

    @JsonValue
    Map<String, Object> getModule() {
        return Map.of(
                "name", name(),
                "description", description
        );
    }

    public static Set<NationaliteType> getAllNationalite() {
        return stream(values())
                .collect(Collectors.toSet());
    }
}
