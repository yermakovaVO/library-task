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
import ru.filit.dto.AuthorCreateDto;
import ru.filit.dto.AuthorUpdateDto;
import ru.filit.dto.AuthorsDto;
import ru.filit.dto.BooksDto;
import ru.filit.services.AuthorService;
import ru.filit.services.LoggingService;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@Autowired
	LoggingService loggingService;

	@GetMapping("authors")
	@Operation(summary = "Возвращает список авторов (пагинация + жанр/автор)")
	public ResponseEntity<AuthorsDto> getAuthors(@RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) String genreId,
			@RequestParam(required = false) String authorId) {
		loggingService.logIncomingRequest(offset + " " + limit + "" + genreId + "" + authorId);
		AuthorsDto authorsDto = new AuthorsDto();
		return new ResponseEntity<>(authorsDto, HttpStatus.OK);
	}


	@GetMapping("authors/{id}")
	@Operation(summary = "Получает автора по id")
	public ResponseEntity<AuthorUpdateDto> getAuthorById(@PathVariable String id) {
		loggingService.logIncomingRequest(id);
		return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
	}

	@GetMapping("authors/{id}/books")
	@Operation(summary = "Возвращает список книг автора")
	public ResponseEntity<BooksDto> getAllBooksOfAuthor(@PathVariable String id) {
		loggingService.logIncomingRequest(id);
		BooksDto booksDto = new BooksDto();
		return new ResponseEntity<>(booksDto, HttpStatus.OK);
	}

	@PostMapping("authors")
	@Operation(summary = "Создаёт автора")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createAuthor(@RequestBody AuthorCreateDto dto) {
		loggingService.logIncomingRequest(dto.toString());

	}

	@PutMapping("authors/{id}")
	@Operation(summary = "Обновляет информацию об авторе")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateAuthor(@RequestBody AuthorCreateDto dto) {
		loggingService.logIncomingRequest(dto.toString());

	}

	@DeleteMapping("authors/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Operation(summary = "Удаляет автора и все его книги")
	public void deleteAuthorWithAllBooks(@PathVariable String id) {
		loggingService.logIncomingRequest(id);
	}

}
