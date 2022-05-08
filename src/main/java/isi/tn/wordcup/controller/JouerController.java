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

import isi.tn.wordcup.entities.Jouer;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.IJouerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/jouer")
@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
public class JouerController {
	@Autowired
    private IJouerService jouerService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Jouer> findAll() {
        return jouerService.findAll();
    }

    @PostMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Jouer jouer) {
        return jouerService.save(jouer);
    }

    @PutMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse update(@RequestBody Jouer jouer) {
        return jouerService.update(jouer);
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Jouer findById(@PathVariable("code") Long id) {
        return jouerService.findById(id);
    }

    @DeleteMapping("/{id}")
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return jouerService.delete(id);
    }
}
