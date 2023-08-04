package ru.filit.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.filit.dto.AuthorCreateDto;
import ru.filit.dto.AuthorUpdateDto;
import ru.filit.dto.AuthorsDto;
import ru.filit.model.Author;
import ru.filit.model.mapper.AuthorModelMapper;
import ru.filit.repository.AuthorMapper;
import ru.filit.repository.BookMapper;

@Service
public class AuthorService {

	@Autowired
	AuthorMapper authorMapper;

	@Autowired
	BookMapper bookMapper;


	/**
	 * Отдает список книг. В случае, если выбраны offset limit - сделает пагинацию
	 * Если выбраны genreId и/или authorId - отфильтрует по ним
	 */
	public AuthorsDto getAuthors(Long offset, Long limit) {

		List<Author> authors = authorMapper.getAuthors(offset, limit);
		return AuthorModelMapper.authorListToAuthorsDto(authors);

	}


	@Transactional
	public void deleteAuthorById(String id) {
		Long authorId = Utils.processStringInput(id);
		authorMapper.deleteAuthorById(authorId);
	}

	public void updateAuthorById(AuthorUpdateDto dto) {
		authorMapper.updateAuthorById(AuthorModelMapper.updateDtoToAuthor(dto));
	}

	public void createAuthor(AuthorCreateDto dto) {
		authorMapper.createAuthor(AuthorModelMapper.createDtoToAuthor(dto));
	}

	public AuthorUpdateDto getAuthorById(String id) {

		Long authorId = Utils.processStringInput(id);
		Author author = authorMapper.getAuthorById(authorId);
		return AuthorModelMapper.authorToAuthorUpdateDto(author);
	}

}
