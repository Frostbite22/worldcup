package isi.tn.wordcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.tn.wordcup.entities.Joueur;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.IJoueurService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/joueur")
public class JoueurController {
	@Autowired
    private IJoueurService joueurService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Joueur> findAll() {
        return joueurService.findAll();
    }

    @PostMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Joueur joueur) {
        return joueurService.save(joueur);
    }

    @PutMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse update(@RequestBody Joueur joueur) {
        return joueurService.update(joueur);
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Joueur findById(@PathVariable("code") Long id) {
        return joueurService.findById(id);
    }

    @DeleteMapping("/{id}")
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return joueurService.delete(id);
    }
}
