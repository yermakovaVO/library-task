package ru.filit.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
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
import ru.filit.dto.GenresDto;
import ru.filit.model.Genre;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class GenreController {

	@GetMapping("genres")
	@Operation(summary = "Возвращает список жанров")
	public ResponseEntity<GenresDto> getGenres(@RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer limit) {

		GenresDto genresDto = new GenresDto();
		return new ResponseEntity<>(genresDto, HttpStatus.OK);
	}

	@GetMapping("genres/{id}")
	@Operation(summary = "Получает жанр по id")
	public ResponseEntity<Genre> getGenreById(@PathVariable String id) {
		Genre genre = null;
		return new ResponseEntity<>(genre, HttpStatus.OK);
	}

	@PostMapping("genres")
	@Operation(summary = "Создаёт жанр")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createGenre(@RequestBody Genre genre) {

	}

	@PutMapping("genres/{id}")
	@Operation(summary = "Обновляет информацию о жанре")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateGenre(@PathVariable String id) {
	}

}
