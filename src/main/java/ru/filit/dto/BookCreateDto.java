package ru.filit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class BookCreateDto {

	private String name;

	private List<Long> authors;

	private List<Long> genres;
	private String year;


	@Override
	public String toString() {
		return " BookCreateDto{"
				+ " name: " + this.name +
				" year: " + this.year
//				+ " authors: " + this.authors
				+ '}';

	}

}
