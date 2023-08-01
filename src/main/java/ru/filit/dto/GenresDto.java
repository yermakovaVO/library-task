package ru.filit.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.filit.model.Genre;

@Getter
@Setter
@NoArgsConstructor
public class GenresDto extends ListDataDto {

	private List<Genre> genres;


}
