package mk.ukim.finki.lab2.web;

import mk.ukim.finki.lab2.model.enumerations.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins =  "http://localhost:3000")
@RequestMapping("/api/categories")
public class BookCategoryRestController {

    @GetMapping
    public List<BookCategory> findAll(){
        return Arrays.asList(BookCategory.values());
    }

}
