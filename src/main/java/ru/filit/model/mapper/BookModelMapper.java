package ru.filit.model.mapper;


import ru.filit.model.Book;

public class BookModelMapper {

	public static ru.filit.dto.BookUpdateDto bookToBookUpdateDto(Book book) {

		return new ru.filit.dto.BookUpdateDto(
				book.getName(),
				book.getYear(),
				book.getId()
		);

	}

}
