package ru.filit.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.filit.model.Genre;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenresDto extends ListDataDto {

	private List<GenreUpdateDto> genres;


}
