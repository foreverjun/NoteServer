package com.example.noteserver.service;

import com.example.noteserver.model.Note;
import com.example.noteserver.model.User;

import java.util.List;

public interface NoteService {
    void save(Note note);
    void delete(Long id);
    Note findById(Long id);
    List<Note> findByUser(User user);
    List<Note> findByUserAndTitleContaining(User user, String title);
    List<Note> findByUserAndCategory(User user, String category);
}
