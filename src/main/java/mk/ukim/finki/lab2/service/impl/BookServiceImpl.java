package mk.ukim.finki.lab2.service.impl;

import mk.ukim.finki.lab2.model.Author;
import mk.ukim.finki.lab2.model.Book;
import mk.ukim.finki.lab2.model.dto.BookDto;
import mk.ukim.finki.lab2.model.enumerations.BookCategory;
import mk.ukim.finki.lab2.repository.AuthorRepository;
import mk.ukim.finki.lab2.repository.BookRepository;
import mk.ukim.finki.lab2.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findBookById(Long bookId) {
        return this.bookRepository.findById(bookId);
    }

    @Override
    public Optional<Book> createBook(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor()).get();

        BookCategory category = null;
        for(BookCategory c : BookCategory.values()){
            if(c.name().equals(bookDto.getCategory())){
                category = c;
                break;
            }
        }


        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(),author,category,bookDto.getAvailableCopies())));
    }

    @Override
    public void deleteBook(Long bookId) {
        this.bookRepository.delete(this.findBookById(bookId).get());

    }

    @Override
    public Optional<Book> editBook(Long bookId, BookDto bookDto) {
        Book book = this.findBookById(bookId).get();

        Author author = this.authorRepository.findById(bookDto.getAuthor()).get();

        BookCategory category = null;
        for(BookCategory c : BookCategory.values()){
            if(c.name().equals(bookDto.getCategory())){
                category = c;
                break;
            }
        }
        book.setName(bookDto.getName());
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));

    }


    @Override
    public Optional<Book> markAsTaken(Long bookId) {
        Book book = this.findBookById(bookId).get();

        Integer availableCopies = book.getAvailableCopies();
        if(availableCopies > 0){
            availableCopies-=1;
        }

        book.setAvailableCopies(availableCopies);
        return Optional.of(this.bookRepository.save(book));
    }
}
