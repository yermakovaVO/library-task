package ru.filit.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.filit.dto.GenreCreateDto;
import ru.filit.dto.GenreUpdateDto;
import ru.filit.dto.GenresDto;
import ru.filit.services.GenreService;
import ru.filit.services.LoggingService;

@RestController
@RequestMapping("/api/v1/genres")
@RequiredArgsConstructor
public class GenreController {

	@Autowired
	GenreService genreService;

	@Autowired
	LoggingService loggingService;


	@GetMapping("")
	@Operation(summary = "Возвращает список жанров")
	public ResponseEntity<GenresDto> getGenres(@RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer limit) {
		loggingService.logIncomingRequest(offset + " " + limit);

		return new ResponseEntity<>(genreService.getGenres(offset, limit), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Получает жанр по id")
	public ResponseEntity<GenreUpdateDto> getGenreById(@PathVariable String id) {
		loggingService.logIncomingRequest(id);

		return new ResponseEntity<>(genreService.getGenreById(id), HttpStatus.OK);
	}

	@PostMapping("")
	@Operation(summary = "Создаёт жанр")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createGenre(@RequestBody GenreCreateDto genre) {
		loggingService.logIncomingRequest(genre.toString());
		genreService.createGenre(genre);

	}

	@PutMapping("/{id}")
	@Operation(summary = "Обновляет информацию о жанре")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateGenre(@RequestBody GenreUpdateDto genre) {
		loggingService.logIncomingRequest(genre.getId());
		genreService.updateGenreById(genre);

	}

}
