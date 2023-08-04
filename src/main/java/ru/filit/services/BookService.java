package ru.filit.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.filit.dto.BookCreateDto;
import ru.filit.dto.BookUpdateDto;
import ru.filit.dto.BooksDto;
import ru.filit.model.Book;
import ru.filit.model.mapper.BookModelMapper;
import ru.filit.repository.BookAuthorMapper;

@Service
public class BookService {

	@Autowired
	BooksDbService booksDbService;

	@Autowired
	BookAuthorMapper bookAuthorMapper;

	public BooksDto getBooks(Integer page, Integer size, String genreId, String authorId) {
		//В ТЗ один жанр и один автор
		Long genreLongId = null;
		Long authorLongId = null;
		if (genreId != null) {
			genreLongId = Utils.processStringInput(genreId);
		}
		if (authorId != null) {
			authorLongId = Utils.processStringInput(authorId);
		}
		//	требований не было, пусть будет 10. Без пагинации совсем - рест приложение это нехорошо
		if (page == null && size == null) {
			page = 1;
			size = 10;
		}
		Pageable pageable = PageRequest.of(page, size);

		List<Book> books = booksDbService.getBookById(
				authorLongId,
				genreLongId,
				Long.valueOf(page),
				Long.valueOf(size)
		);
		return BookModelMapper.bookListToBooksDto(books, pageable);

	}

	public BookUpdateDto getBookById(String id) {
		Long bookId = Utils.processStringInput(id);
		Book book = booksDbService.getBookById(bookId);
		return BookModelMapper.bookToBookUpdateDto(book);
	}

	@Transactional
	public void createBook(BookCreateDto dto) {
		booksDbService.createBook(BookModelMapper.createDtoToBook(dto), dto.getAuthors(), dto.getGenres());
	}

	@Transactional
	public void updateBookById(BookUpdateDto dto) {
		Utils.processStringInput(dto.getId());
		booksDbService.updateBook(BookModelMapper.updateDtoToBook(dto), dto.getAuthors(), dto.getGenres());
	}

	@Transactional
	public void deleteBookById(String id) {
		Long bookId = Utils.processStringInput(id);
		booksDbService.deleteBookById(bookId);
	}


}
