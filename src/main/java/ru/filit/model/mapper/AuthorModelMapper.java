package ru.filit.model.mapper;

import ru.filit.dto.AuthorUpdateDto;
import ru.filit.model.Author;

public class AuthorModelMapper {

	public static AuthorUpdateDto authorToAuthorUpdateDto(Author author) {

		return new AuthorUpdateDto(
				author.getName(),
				author.getSurname(),
				author.getMidname(),
				author.getBirthDate(),
				author.getId()
		);

	}

}
