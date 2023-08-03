package ru.filit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.filit.dto.GenreUpdateDto;
import ru.filit.model.Genre;
import ru.filit.model.mapper.GenreModelMapper;
import ru.filit.repository.GenreMapper;

@Service
public class GenreService {

	@Autowired
	GenreMapper authorMapper;


	public GenreUpdateDto getGenreById(String id) {

		Long authorId = Utils.processStringInput(id);
		Genre genre = authorMapper.getGenreById(authorId);

		return GenreModelMapper.genreToGenreUpdateDto(genre);

	}

}
