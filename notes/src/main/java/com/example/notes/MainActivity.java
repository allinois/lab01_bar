package com.example.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    List<Note> noteList;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotesReader.Init(getApplicationContext());
        noteList = NotesReader.readNotes().getNotes();
        ArrayAdapter<Note> notes = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, noteList);
        listView = findViewById(R.id.list_notes);
        listView.setAdapter(notes);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent i1 = new Intent(getApplicationContext(), ShowNoteActivity.class);
                i1.putExtra("data", NotesReader.getGson().toJson(noteList.get(i)));
                i1.putExtra("isEdit", true);
                startActivity(i1);
            }
        });


    }

    @Override
    protected void onResume() {
        noteList = NotesReader.readNotes().getNotes();
        ArrayAdapter<Note> notes = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, noteList);
        listView.setAdapter(notes);
        super.onResume();
    }
    public void AddClick(View w){
        Intent i1 = new Intent(getApplicationContext(), ShowNoteActivity.class);
        i1.putExtra("isEdit", false);
        startActivity(i1);
    }
}