package mk.ukim.finki.lab2.web;

import mk.ukim.finki.lab2.model.Author;
import mk.ukim.finki.lab2.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins =  "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }
}
