package org.ba.budgetapp2.costants;

public enum Bank {

    INTESA("intesa");

    private String value;

    Bank(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
