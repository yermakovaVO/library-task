package ru.filit.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class GenreUpdateDto extends GenreCreateDto {

	@NotEmpty
	private String id;

	private String name;

	public GenreUpdateDto(String name, String id) {
		super(name);
		this.id = id;
	}

}
