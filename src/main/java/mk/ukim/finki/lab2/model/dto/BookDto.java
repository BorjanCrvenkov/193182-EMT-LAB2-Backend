package mk.ukim.finki.lab2.model.dto;

import lombok.Data;

@Data
public class BookDto {

    private String name;

    private Long author;

    private String category;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Long author, String category, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}
