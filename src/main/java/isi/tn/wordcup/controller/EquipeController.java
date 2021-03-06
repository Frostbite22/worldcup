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
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.IEquipeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/equipe")
public class EquipeController {
	@Autowired
    private IEquipeService equipeService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Equipe equipe) {
        return equipeService.save(equipe);
    }

    @PutMapping
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse update(@RequestBody Equipe equipe) {
        return equipeService.update(equipe);
    }

   @GetMapping("/{code}")
   @PreAuthorize("hasRole('ROLE_USER')")
    public Equipe findById(@PathVariable("code") Long id) {
        return equipeService.findById(id);
    }

    @DeleteMapping("/{id}")
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return equipeService.delete(id);
    }
}
