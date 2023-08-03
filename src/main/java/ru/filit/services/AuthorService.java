package ru.filit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.filit.dto.AuthorUpdateDto;
import ru.filit.model.Author;
import ru.filit.model.mapper.AuthorModelMapper;
import ru.filit.repository.AuthorMapper;

@Service
public class AuthorService {

	@Autowired
	AuthorMapper authorMapper;

	public AuthorUpdateDto getAuthorById(String id) {

		Long authorId = Utils.processStringInput(id);
		Author author = authorMapper.getAuthorById(authorId);

		return AuthorModelMapper.authorToAuthorUpdateDto(author);

	}

}
