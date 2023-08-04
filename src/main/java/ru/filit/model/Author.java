package ru.filit.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Author {

//	@NotEmpty
	private Long id;

	private String nickname;

	private String name;

	private String surname;

	private String midname;


}
