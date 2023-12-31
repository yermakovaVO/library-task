package ru.filit.model;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {


	@NotEmpty
	private Long id;

	private String name;

	private LocalDate year;

	private List<BookAuthor> authors;

	private List<BookGenre> genres;


}
