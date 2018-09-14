package ru.mgusev.questbook.model;

public class Condition {

    private String type;
    private int id;
    private int count;

    public Condition(String type, int id, int count) {
        this.type = type;
        this.id = id;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }
}