package ru.filit.model.mapper;

import java.util.ArrayList;
import java.util.List;
import ru.filit.dto.GenreCreateDto;
import ru.filit.dto.GenreUpdateDto;
import ru.filit.dto.GenresDto;
import ru.filit.model.Genre;

public class GenreModelMapper {

	public static Genre createDtoToGenre(GenreCreateDto genreCreateDto) {

		return new Genre(
				null,
				genreCreateDto.getName()
		);

	}

	public static GenreUpdateDto genreToGenreUpdateDto(Genre genre) {

		return new GenreUpdateDto(
				genre.getName(),
				genre.getId().toString()

		);
	}

	public static ru.filit.dto.GenreUpdateDto genreToBookUpdateDto(Genre book) {

		return new ru.filit.dto.GenreUpdateDto(
				book.getName(),
				book.getId().toString()
		);

	}


	public static GenresDto genreListToGenresDto(List<Genre> genre) {
		List<GenreUpdateDto> list = new ArrayList<>();
		for (Genre b : genre) {
			list.add(genreToBookUpdateDto(b));
		}

		return new GenresDto(list);

	}

}
