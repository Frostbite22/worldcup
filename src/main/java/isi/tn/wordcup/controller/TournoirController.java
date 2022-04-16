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

import isi.tn.wordcup.entities.Equipe;
import isi.tn.wordcup.entities.Tournoir;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.ITournoirService;
import isi.tn.wordcup.services.ImpEquipeService;
import isi.tn.wordcup.services.ImpTournoirService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tournoir")
@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
public class TournoirController {
	@Autowired
    private ITournoirService tournoirService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Tournoir> findAll() {
        return tournoirService.findAll();
    }

    @PostMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Tournoir tournoir) {
        return tournoirService.save(tournoir);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Tournoir tournoir) {
        return tournoirService.update(tournoir);
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Tournoir findById(@PathVariable("code") Long id) {
        return tournoirService.findById(id);
    }

    @DeleteMapping("/{id}")
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return tournoirService.delete(id);
    }
}
