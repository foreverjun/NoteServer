package com.example.noteserver.service;

import com.example.noteserver.model.Note;
import com.example.noteserver.model.User;
import com.example.noteserver.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Note> findByUser(User user) {
        return noteRepository.findByUser(user);
    }
    @Override
    public List<Note> findByUserAndTitleContaining(User user, String title) {
        return noteRepository.findByUserAndTitleContaining(user, title);
    }
    @Override
    public List<Note> findByUserAndCategory(User user, String category) {
        return noteRepository.findByUserAndCategory(user, category);
    }
}

