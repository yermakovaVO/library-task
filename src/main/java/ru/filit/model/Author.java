package ru.filit.model;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Author {

	@NotEmpty
	private String id;

	private String name;

	private String surname;

	private String midname;

	private LocalDate birthDate;


}
