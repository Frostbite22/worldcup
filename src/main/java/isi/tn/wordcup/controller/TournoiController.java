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

import isi.tn.wordcup.entities.Tournoi;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.ITournoiService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tournoi")
@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
public class TournoiController {
	@Autowired
    private ITournoiService tournoiService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Tournoi> findAll() {
        return tournoiService.findAll();
    }

    @PostMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Tournoi tournoi) {
        return tournoiService.save(tournoi);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Tournoi tournoi) {
        return tournoiService.update(tournoi);
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Tournoi findById(@PathVariable("code") Long id) {
        return tournoiService.findById(id);
    }

    @DeleteMapping("/{id}")
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return tournoiService.delete(id);
    }
}
