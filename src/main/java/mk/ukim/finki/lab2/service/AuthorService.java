package mk.ukim.finki.lab2.service;

import mk.ukim.finki.lab2.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findAuthorById(Long authorId);

    Author createAuthor(String name, String surname, Long countryId);

    Author deleteAuthor(Long authorId);

    Author editAuthor(Long authorId, String name, String surname, Long countryId);
}
