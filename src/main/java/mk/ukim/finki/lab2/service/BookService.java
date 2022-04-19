package mk.ukim.finki.lab2.service;

import mk.ukim.finki.lab2.model.Book;
import mk.ukim.finki.lab2.model.dto.BookDto;
import mk.ukim.finki.lab2.model.enumerations.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Page<Book> findAllWithPagination(Pageable pageable);

    Optional<Book> findBookById(Long bookId);

    Optional<Book> createBook(BookDto bookDto);

    void deleteBook(Long bookId);

    Optional<Book> editBook(Long bookId, BookDto bookDto);

    Optional<Book> markAsTaken(Long bookId);
}
