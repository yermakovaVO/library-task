package ru.filit.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.filit.model.Book;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooksDto extends ListDataDto {

	private List<BookUpdateDto> books;

}
