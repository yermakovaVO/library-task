package ru.filit.model;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.filit.dto.BookCreateDto;

@Getter
@Setter
@AllArgsConstructor
public class Book  {


	@NotEmpty
	private String id;

	private String name;

	private LocalDate year;

	private String authorId;




}
