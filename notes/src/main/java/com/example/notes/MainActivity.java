package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Note> notesList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotesReader.Init(getApplicationContext());
        notesList = NotesReader.readNotes().getNotes();
        ArrayAdapter<Note> notes = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                notesList);
        listView = findViewById(R.id.list_notes);
        listView.setAdapter(notes);
}