package com.danyarmarkin.crypto;

import java.util.ArrayList;

public class Block {

    public ArrayList<Note> notes;
    public String text;

    Block(String text) {
        this.text = text;
        notes = new ArrayList<>();
    }

    Block() {
        text = "";
        notes = new ArrayList<>();
    }

    public void add(Note note) {
        if (notes.size() == 0) {
            note.addText(text);
            notes.add(note);
            text = note.getText();
            return;
        }
        String t = String.valueOf(notes.get(notes.size() - 1).getHash());
        note.addText(t);
        text = note.getText();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
