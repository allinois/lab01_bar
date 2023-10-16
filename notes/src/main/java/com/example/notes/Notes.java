package com.example.notes;

import java.util.ArrayList;
import java.util.List;

public class Notes {
    private List<Note> notes;
    public Notes(){
        notes = new ArrayList<>();
    }
    public List<Note> getNotes() {
        return notes;
    }
    public void Add(Note note){
        notes.add(note);
    }
}