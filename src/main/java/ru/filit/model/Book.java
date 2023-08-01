package ru.filit.model;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import ru.filit.dto.BookCreateDto;

@Getter
@Setter
public class Book extends BookCreateDto {


	@NotEmpty
	private String id;

	private String name;

	private LocalDate year;

	private String authorId;


	public Book(String name, LocalDate year) {
		super(name, year);
	}

}
