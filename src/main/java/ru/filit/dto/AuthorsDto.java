package ru.filit.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.filit.model.Author;

@Getter
@Setter
@NoArgsConstructor
public class AuthorsDto extends ListDataDto {

	private List<AuthorUpdateDto> authors;

}
