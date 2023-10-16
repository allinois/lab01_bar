package com.example.notes;

public class Note {
    private String name;
    private String text;
    private boolean status;

    public Note(String name, String text, boolean status) {
        this.name = name;
        this.text = text;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setText(String text) {
        this.text = text;
    }
}