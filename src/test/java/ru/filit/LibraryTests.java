package ru.filit;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.filit.config.DataSourceConfig;
import ru.filit.model.Author;
import ru.filit.model.Book;
import ru.filit.model.Genre;
import ru.filit.repository.AuthorMapper;
import ru.filit.repository.BookMapper;
import ru.filit.repository.GenreMapper;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
class LibraryTests {

	@Autowired
	AuthorMapper authorMapper;

	@Autowired
	BookMapper bookMapper;

	@Autowired
	GenreMapper genreMapper;


	@Test
	void checkEntities() {
		List<Author> lst = authorMapper.getAuthors(1L, 5L);
		Author author = authorMapper.getAuthorById(1L);
		Assert.assertNotNull(author);
		Assert.assertFalse(lst.isEmpty());

		List<Book> booksLst = bookMapper.getBooks(null, null, 0L, 10L);
		Book book = bookMapper.getBookById(1L);
		Assert.assertNotNull(book);
		Assert.assertFalse(booksLst.isEmpty());

		List<Genre> genreList = genreMapper.getGenres(0, 5);
		Assert.assertFalse(genreList.isEmpty());
	}

}
