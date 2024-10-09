package com.example.noteserver.controller;



import com.example.noteserver.model.Note;
import com.example.noteserver.model.User;
import com.example.noteserver.service.NoteService;
import com.example.noteserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class NoteController {

    private NoteService noteService;
    private UserService userService;

    @Autowired
    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String listNotes(@AuthenticationPrincipal org.springframework.security.core.userdetails.User userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        List<Note> notes = noteService.findByUser(user);
        model.addAttribute("notes", notes);
        return "notes";
    }

    @GetMapping("/note/new")
    public String newNote(Model model) {

        model.addAttribute("noteForm", new Note());
        return "note_form";
    }

    @PostMapping("/note")
    public String saveNote(@ModelAttribute("noteForm") Note note,
                           @AuthenticationPrincipal org.springframework.security.core.userdetails.User userDetails) {
        User user = userService.findByUsername(userDetails.getUsername());
        note.setUser(user);
        noteService.save(note);
        return "redirect:/";
    }

    @GetMapping("/note/edit/{id}")
    public String editNote(@PathVariable Long id, Model model) {
        Note note = noteService.findById(id);
        model.addAttribute("noteForm", note);
        return "note_form";
    }

    @GetMapping("/note/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchNotes(@RequestParam("query") String query,
                              @RequestParam(value = "filterBy", defaultValue = "title") String filterBy,
                              @AuthenticationPrincipal org.springframework.security.core.userdetails.User userDetails,
                              Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        List<Note> notes;

        if (Objects.equals(query, "")){
            notes = noteService.findByUser(user);
        } else if ("category".equalsIgnoreCase(filterBy)) {
            notes = noteService.findByUserAndCategory(user, query);
        } else {
            notes = noteService.findByUserAndTitleContaining(user, query);
        }

        model.addAttribute("notes", notes);
        return "notes";
    }
}
