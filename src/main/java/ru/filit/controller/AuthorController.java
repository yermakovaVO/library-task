package ru.filit.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
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
import ru.filit.dto.AuthorsDto;
import ru.filit.dto.BooksDto;
import ru.filit.model.Author;
import ru.filit.model.Book;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AuthorController {

	@GetMapping("authors")
	@Operation(summary = "Возвращает список авторов (пагинация + жанр/автор)")
	public ResponseEntity<AuthorsDto> getAuthors(@RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) String genreId,
			@RequestParam(required = false) String authorId) {

		AuthorsDto authorsDto = new AuthorsDto();
		return new ResponseEntity<>(authorsDto, HttpStatus.OK);
	}

	@GetMapping("authors/{id}")
	@Operation(summary = "Получает автора по id")
	public ResponseEntity<Author> getAuthorById(@PathVariable String id) {
		Author author = null;
		return new ResponseEntity<>(author, HttpStatus.OK);
	}

	@GetMapping("authors/{id}/books")
	@Operation(summary = "Возвращает список книг автора")
	public ResponseEntity<BooksDto> getAllBooksOfAuthor(@PathVariable String id) {
		BooksDto booksDto = new BooksDto();
		return new ResponseEntity<>(booksDto, HttpStatus.OK);
	}

	@PostMapping("authors")
	@Operation(summary = "Создаёт автора")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createAuthor(@RequestBody Author author) {

	}

	@PutMapping("authors/{id}")
	@Operation(summary = "Обновляет информацию об авторе")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateAuthor(@RequestBody Author author) {

	}

	@DeleteMapping("authors/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Operation(summary = "Удаляет автора и все его книги")
	public void deleteAuthorWithAllBooks(@PathVariable String id) {

	}

}
