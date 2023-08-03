package ru.filit.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.filit.dto.BookUpdateDto;
import ru.filit.model.Book;
import ru.filit.model.mapper.BookModelMapper;
import ru.filit.repository.BookMapper;

@Service
public class BookService {

	@Autowired
	BookMapper bookMapper;


	public BookUpdateDto getBookById(String id) {

		Long authorId = Utils.processStringInput(id);
		Book book = bookMapper.getBookById(authorId);

		return BookModelMapper.bookToBookUpdateDto(book);

	}

}
