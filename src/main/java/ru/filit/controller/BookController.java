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
import ru.filit.model.Book;
import ru.filit.services.BookService;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("books")
	@Operation(summary = "Возвращает список книг (пагинация + жанр/автор)")
	public ResponseEntity<BooksDto> getBooks(@RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) String genreId,
			@RequestParam(required = false) String authorId) {
		BooksDto booksDto = new BooksDto();
		return new ResponseEntity<>(booksDto, HttpStatus.OK);
	}

	@GetMapping("books/{id}")
	@Operation(summary = "Получает книгу по id")
	public ResponseEntity<BookUpdateDto> getBookById(@PathVariable String id) {
		BookUpdateDto dto = bookService.getBookById(id);//todo
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping("books")
	@Operation(summary = "Создает книгу")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createBook(@RequestBody BookCreateDto book) { //todo

	}

	@PutMapping("books/{id}")
	@Operation(summary = "Обновляет информацию о книге")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateBook(@PathVariable String id) {

	}

	@DeleteMapping("books/{id}")
	@Operation(summary = "Удаляет книгу")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteBook(@PathVariable String id) {

	}

}
