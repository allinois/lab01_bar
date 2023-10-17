package com.example.notes;

import android.content.Context;
import android.content.SharedPreferences;




public class NotesReader {

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor; //
    private static Gson gson;
    public static void Init(Context c){
        preferences = c.getSharedPreferences("notes",
                Context.MODE_PRIVATE);
        editor = preferences.edit();
        gson = new Gson();
    }
    public static Gson getGson() {
        return gson;
    }
    public static Notes readNotes() {
        return gson.fromJson(preferences.getString("data", "{}"),
                Notes.class);
    }
    public static void AddNote(Note note){
        Notes notes = readNotes();
        notes.Add(note);
        editor.putString("data", gson.toJson(notes));
        editor.apply();
    }
    public static void Save(Notes notes){
        editor.putString("data", gson.toJson(notes));
        editor.apply();
    }
}