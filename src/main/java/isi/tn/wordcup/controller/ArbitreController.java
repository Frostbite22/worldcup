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

import isi.tn.wordcup.entities.Arbitre;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.IArbitreService;
import isi.tn.wordcup.services.ImpArbitreService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/arbitre")
public class ArbitreController {
	@Autowired
    private IArbitreService arbitreService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Arbitre> findAll() {
        return arbitreService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse save(@RequestBody Arbitre arbitre) {
        return arbitreService.save(arbitre);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse update(@RequestBody Arbitre domaine) {
        return arbitreService.update(domaine);
    }

   @GetMapping("/{code}")
   @PreAuthorize("hasRole('ROLE_USER')")
    public Arbitre findById(@PathVariable("code") Long id) {
        return arbitreService.findById(id);
    }

    @DeleteMapping("/{id}")
   	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@PathVariable Long id) {
        return arbitreService.delete(id);
    }
}
