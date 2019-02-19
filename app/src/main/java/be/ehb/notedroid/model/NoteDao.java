package be.ehb.notedroid.model;

import java.util.ArrayList;

public class NoteDao {
    private static final NoteDao ourInstance = new NoteDao();
    ArrayList<Note> noteLijst = new ArrayList<>();

    public static NoteDao getInstance() {
        return ourInstance;
    }

    public ArrayList<Note> getNoteLijst() {
        return noteLijst;
    }
    public void addNote(Note nieuweNote){
        noteLijst.add(nieuweNote);
    }
}
