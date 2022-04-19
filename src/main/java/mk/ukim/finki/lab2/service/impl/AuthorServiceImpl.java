package mk.ukim.finki.lab2.service.impl;

import mk.ukim.finki.lab2.model.Author;
import mk.ukim.finki.lab2.model.Country;
import mk.ukim.finki.lab2.repository.AuthorRepository;
import mk.ukim.finki.lab2.repository.CountryRepository;
import mk.ukim.finki.lab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long authorId) {
        return this.authorRepository.findById(authorId).get();
    }

    @Override
    public Author createAuthor(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).get();

        Author author = new Author(name,surname,country);

        return this.authorRepository.save(author);
    }

    @Override
    public Author deleteAuthor(Long authorId) {
        Author author = this.authorRepository.findById(authorId).get();
        this.authorRepository.delete(author);
        return author;
    }

    @Override
    public Author editAuthor(Long authorId, String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).get();

        Author author = this.authorRepository.findById(authorId).get();

        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);

        return this.authorRepository.save(author);
    }
}
