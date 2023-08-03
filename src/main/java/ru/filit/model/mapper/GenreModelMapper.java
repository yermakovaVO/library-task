package ru.filit.model.mapper;

import ru.filit.dto.GenreUpdateDto;
import ru.filit.model.Genre;

public class GenreModelMapper {

	public static GenreUpdateDto genreToGenreUpdateDto(Genre genre) {

		return new GenreUpdateDto(
				genre.getName(),
				genre.getId()

		);

	}

}
