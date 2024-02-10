package org.lld.enums;

public enum PlayerType {

    X(1),
    O(-1);
    private final int value;
    private PlayerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return this.name();
    }
}
