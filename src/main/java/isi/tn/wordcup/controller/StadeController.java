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

import isi.tn.wordcup.entities.Stade;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.IStadeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/stade")
public class StadeController {
	@Autowired
    private IStadeService stadeService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Stade> findAll() {
        return stadeService.findAll();
    }

    @PostMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Stade stade) {
        return stadeService.save(stade);
    }

    @PutMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse update(@RequestBody Stade stade) {
        return stadeService.update(stade);
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Stade findById(@PathVariable("code") Long id) {
        return stadeService.findById(id);
    }

    @DeleteMapping("/{id}")
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return stadeService.delete(id);
    }
}
