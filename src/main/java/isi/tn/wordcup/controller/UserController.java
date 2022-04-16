package isi.tn.wordcup.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.tn.wordcup.entities.User;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.services.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody User utilisateur) {
        return userService.save(utilisateur);
    }

    @PutMapping
    public MessageResponse update(@RequestBody User utilisateur) {
        return userService.update(utilisateur);
    }

    @GetMapping("/{code}")
    public User findById(@PathVariable("code") Long code) {
        return userService.findById(code);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long code) {
        return userService.delete(code);
    }
}