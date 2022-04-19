package mk.ukim.finki.lab2.model;

import mk.ukim.finki.lab2.model.dto.BookDto;
import mk.ukim.finki.lab2.model.enumerations.BookCategory;
import mk.ukim.finki.lab2.service.AuthorService;
import mk.ukim.finki.lab2.service.BookService;
import mk.ukim.finki.lab2.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData(){
        Random random = new Random();

        Country france = this.countryService.createCountry("France", "Europe");
        Country germany = this.countryService.createCountry("Germany", "Europe");
        Country uk = this.countryService.createCountry("United Kingdom", "Europe");

        Author victorHugo = this.authorService.createAuthor("Victor","Hugo",france.getId());
        Author annaMaria = this.authorService.createAuthor("Anna Maria", "van Schurman",germany.getId());
        Author patrick = this.authorService.createAuthor("Patrick","Leigh Fermor",uk.getId());

        BookDto book1 = new BookDto("Toilers of the Sea", victorHugo.getId(), BookCategory.NOVEL.name(), random.nextInt(10) + 1 );
        this.bookService.createBook(book1);

        BookDto book2 = new BookDto("Ninety-Three", victorHugo.getId(),BookCategory.NOVEL.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book2);

        BookDto book3 = new BookDto("Les Miserables",  victorHugo.getId(), BookCategory.HISTORY.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book3);

        BookDto book4 = new BookDto("The Hunchback of Notre-Dame", victorHugo.getId(), BookCategory.DRAMA.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book4);

        BookDto book5 = new BookDto("The Man Who Laughs", victorHugo.getId(), BookCategory.NOVEL.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book5);

        BookDto book6 = new BookDto("Letters and Poems to and from Her Mentor and Other Members", annaMaria.getId(), BookCategory.CLASSICS.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book6);

        BookDto book7 = new BookDto("A Time of Gifts",  patrick.getId(), BookCategory.NOVEL.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book7);

        BookDto book8 = new BookDto("Between the Woods and the Water", patrick.getId(), BookCategory.BIOGRAPHY.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book8);

        BookDto book9 = new BookDto("The Broken Road", patrick.getId(), BookCategory.NOVEL.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book9);

        BookDto book10 = new BookDto("Roumeli", patrick.getId(), BookCategory.NOVEL.name(), random.nextInt(10) + 1);
        this.bookService.createBook(book10);

    }

}
