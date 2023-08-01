package ru.filit.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.filit.model.Book;

@Getter
@Setter
@NoArgsConstructor
public class BooksDto extends ListDataDto {

	private List<Book> books;

}
