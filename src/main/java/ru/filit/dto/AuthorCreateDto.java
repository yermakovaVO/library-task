package ru.filit.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorCreateDto {


	private String name;

	private String surname;

	private String midname;

	private LocalDate birthDate;


}
