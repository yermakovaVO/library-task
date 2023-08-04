package ru.filit.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookUpdateDto extends BookCreateDto {

	@NotEmpty
	private String id;


	public BookUpdateDto(String id, String name, String year, List<Long> authors, List<Long> genres) {
		super(				name, authors, genres, year
		);
		this.id = id;
	}

	@Override
	public String toString() {
		return " BookCreateDto{"
				+ " id: " + this.id
				+ " name: " + super.getName()
				+ " year: " + super.getYear()
//				+ " authors: " + getAuthors()
				+ '}';
	}


}
