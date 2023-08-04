package ru.filit.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.filit.dto.GenreCreateDto;
import ru.filit.dto.GenreUpdateDto;
import ru.filit.dto.GenresDto;
import ru.filit.model.Genre;
import ru.filit.model.mapper.GenreModelMapper;
import ru.filit.repository.GenreMapper;

@Service
public class GenreService {

	@Autowired
	GenreMapper genreMapper;

	public GenreUpdateDto getGenreById(String id) {

		Long authorId = Utils.processStringInput(id);
		Genre genre = genreMapper.getGenreById(authorId);

		return GenreModelMapper.genreToGenreUpdateDto(genre);
	}

	public GenresDto getGenres(Integer offset, Integer limit) {

		List<Genre> books = genreMapper.getGenres(offset, limit);
		return GenreModelMapper.genreListToGenresDto(books);
	}

	public void deleteGenreById(String id) {
		Long authorId = Utils.processStringInput(id);
		genreMapper.deleteGenreById(authorId);
	}

	public void updateGenreById(GenreUpdateDto dto) {
		Long authorId = Utils.processStringInput(dto.getId());
		genreMapper.updateGenreById(authorId);
	}

	public void createGenre(GenreCreateDto dto) {
		genreMapper.createGenre(GenreModelMapper.createDtoToGenre(dto));
	}

}
