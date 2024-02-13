package com.example.ibmhackathon3.domain;

public class Form {
    public enum Type {
        Date, Time, Distance, Rating, isMale, isNotMale, All
    };

    public Type type;

    public Form() {
        this.type = Type.All;
    }

    public Form(Type type) {
        this.type = type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Type[] getTypes() {
        return Type.values();
    }

}
