package fr.cpe.utils;

import java.util.Objects;

public enum Role {
    ADMIN("ADMIN"), USER("USER"), NONE(null);

    private final String role;

    Role(final String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }

    public static Role getEnumByString(String s) {
        for (Role r : Role.values()) {
            if (Objects.equals(r.role, s)) return r;
            // if (r.role.equals(s)) return r;
        }
        return null;
    }
}
