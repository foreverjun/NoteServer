package com.example.noteserver.repository;

import com.example.noteserver.model.Note;
import com.example.noteserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(User user);
    List<Note> findByUserAndCategory(User user, String category);
    List<Note> findByUserAndTitleContaining(User user, String title);
}
