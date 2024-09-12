package org.ba.budgetapp2.costants;

public enum Bank {

    INTESA("INTESA"),
    MANUALE("MANUALE");

    private String value;

    Bank(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
