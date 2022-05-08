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

import isi.tn.wordcup.entities.Groupe;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.IGroupeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/groupe")
@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
public class GroupeController {
	@Autowired
    private IGroupeService groupeService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Groupe> findAll() {
        return groupeService.findAll();
    }

    @PostMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Groupe groupe) {
        return groupeService.save(groupe);
    }

    @PutMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse update(@RequestBody Groupe groupe) {
        return groupeService.update(groupe);
    }

   @GetMapping("/{code}")
   @PreAuthorize("hasRole('ROLE_USER')")
    public Groupe findById(@PathVariable("code") Long id) {
        return groupeService.findById(id);
    }

    @DeleteMapping("/{id}")
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return groupeService.delete(id);
    }
}
