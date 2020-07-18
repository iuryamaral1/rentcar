package br.com.rentcar.model;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableMap;
import static java.util.EnumSet.allOf;

public enum Profile {

    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private Integer id;
    private String role;

    private static final Map<Integer, Profile> profileByIdMap = unmodifiableMap(allOf(Profile.class).stream()
            .collect(Collectors.toMap(Profile::getId, Function.identity())));

    Profile(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Profile getProfileById(Integer id) {
        return profileByIdMap.get(id);
    }
}