package ru.filit.model.mapper;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;
import ru.filit.dto.BookCreateDto;
import ru.filit.dto.BookUpdateDto;
import ru.filit.dto.BooksDto;
import ru.filit.model.Book;

public class BookModelMapper {

	public static Book createDtoToBook(BookCreateDto book) {

		return new Book(
				null,
				book.getName(),
				LocalDate.parse(book.getYear()), null, null
		);
	}

	public static Book updateDtoToBook(BookUpdateDto dto) {

		Book book = createDtoToBook(dto);
		book.setId(Long.valueOf(dto.getId()));
		return book;


	}

	public static ru.filit.dto.BookUpdateDto bookToBookUpdateDto(Book book) {
		List<Long> authors = new ArrayList<>();
		book.getAuthors().forEach(author -> authors.add(author.getAuthorId()));
		List<Long> genres = new ArrayList<>();
		book.getGenres().forEach(author -> genres.add(author.getGenreId()));

		return new BookUpdateDto(
				book.getId().toString(),
				book.getName(),
				String.valueOf(book.getYear().getYear()),
				authors, genres
		);


	}

	public static BooksDto bookListToBooksDto(List<Book> book, Pageable pageable) {
		List<BookUpdateDto> list = new ArrayList<>();
		for (Book b : book) {
			list.add(bookToBookUpdateDto(b));

		}
		BooksDto dto = new BooksDto(list);
		dto.setSize(pageable.getPageSize());
		dto.setPage(pageable.getPageNumber());
		return dto;

	}

}
