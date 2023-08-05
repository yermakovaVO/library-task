package ru.filit.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.filit.dto.BookCreateDto;
import ru.filit.dto.BookUpdateDto;
import ru.filit.dto.BooksDto;
import ru.filit.services.BookService;
import ru.filit.services.LoggingService;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	LoggingService loggingService;

	@GetMapping("")
	@Operation(summary = "Возвращает список книг (пагинация + жанр/автор)")
	public ResponseEntity<BooksDto> getBooks(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size,
			@RequestParam(required = false) String genreId,
			@RequestParam(required = false) String authorId) {

		loggingService.logIncomingRequest(page + " " + size + " " + genreId + " " + authorId);

		return new ResponseEntity<>(bookService.getBooks(page, size, genreId, authorId), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Получает книгу по id")
	public ResponseEntity<BookUpdateDto> getBookById(@PathVariable String id) {

		loggingService.logIncomingRequest(id);
		return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
	}

	@PostMapping("")
	@Operation(summary = "Создает книгу")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createBook(@RequestBody BookCreateDto book) {

		loggingService.logIncomingRequest(book.toString());
		bookService.createBook(book);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Обновляет информацию о книге")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateBook(@RequestBody BookUpdateDto book) {

		loggingService.logIncomingRequest(book.toString());
		bookService.updateBookById(book);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Удаляет книгу")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteBook(@PathVariable String id) {

		loggingService.logIncomingRequest(id);
		bookService.deleteBookById(id);
	}

}
