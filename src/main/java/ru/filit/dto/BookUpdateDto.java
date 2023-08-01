package ru.filit.dto;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDto extends BookCreateDto {

	@NotEmpty
	private String id;

	private String name;

	private LocalDate year;

	private String authorId;


	public BookUpdateDto(String name, LocalDate year, String id) {
		super(name, year);
		this.id = id;
	}

}
