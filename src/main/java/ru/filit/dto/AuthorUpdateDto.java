package ru.filit.dto;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthorUpdateDto extends AuthorCreateDto {


	@NotEmpty
	private String id;

	private String name;

	private String surname;

	private String midname;

	private LocalDate birthDate;


	public AuthorUpdateDto(String name, String surname, String midname, LocalDate birthDate, String id) {
		super(name, surname, midname, birthDate);
		this.id = id;
	}

}
