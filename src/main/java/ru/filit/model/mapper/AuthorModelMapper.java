package ru.filit.model.mapper;

import java.util.ArrayList;
import java.util.List;
import ru.filit.dto.AuthorCreateDto;
import ru.filit.dto.AuthorUpdateDto;
import ru.filit.dto.AuthorsDto;
import ru.filit.model.Author;

public class AuthorModelMapper {

	public static Author updateDtoToAuthor(AuthorUpdateDto author) {
		Author auth = createDtoToAuthor(author);
		auth.setId(Long.valueOf(author.getId()));
		return auth;

	}

	public static Author createDtoToAuthor(AuthorCreateDto author) {

		return new Author(
				null,
				author.getName(),
				author.getSurname(),
				author.getMidname(),
				author.getNickname()

		);

	}

	public static AuthorUpdateDto authorToAuthorUpdateDto(Author author) {

		return new AuthorUpdateDto(
				author.getNickname(),
				author.getName(),
				author.getSurname(),
				author.getMidname(),
				author.getId().toString()
		);

	}

	public static AuthorsDto authorListToAuthorsDto(List<Author> author) {
		List<AuthorUpdateDto> list = new ArrayList<>();
		for (Author a : author) {
			list.add(authorToAuthorUpdateDto(a));
		}

		return new AuthorsDto(list);

	}

}
