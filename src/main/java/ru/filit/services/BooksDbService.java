package ru.filit.services;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import ru.filit.model.Book;
import ru.filit.repository.AuthorMapper;
import ru.filit.repository.BookAuthorMapper;
import ru.filit.repository.BookGenreMapper;
import ru.filit.repository.BookMapper;
import ru.filit.repository.GenreMapper;

@Service
@Slf4j
public class BooksDbService {


	@Autowired
	GenreService genreService;

	@Autowired
	AuthorMapper authorMapper;

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Autowired
	BookAuthorMapper bookAuthorMapper;


	@Autowired
	BookMapper bookMapper;

	@Autowired
	BookGenreMapper bookGenreMapper;


	public void deleteBookById(Long id) {
		List<Long> lst = bookAuthorMapper.findAllAuthorBookLnkByBookId(id);
		bookAuthorMapper.deleteLnkBookAuthorByIds(lst);
		lst = bookGenreMapper.findAllAGenreBookLnkByBookId(id);
		bookGenreMapper.deleteLnkBookGenreByIds(lst);

		bookMapper.deleteBookById(id);
	}


	public void createBook(Book book, List<Long> authors, List<Long> genres) {

		try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {

			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			bookMapper.createBook(book);

			BookAuthorMapper bookAuthorMapper = sqlSession.getMapper(BookAuthorMapper.class);
			for (var author : authors) {
				bookAuthorMapper.createLnkBookAuthor(book.getId(), author);
			}

			BookGenreMapper bookGenreMapper = sqlSession.getMapper(BookGenreMapper.class);
			for (var genre : genres) {
				bookGenreMapper.createLnkBookGenre(book.getId(), genre);
			}

			sqlSession.commit();
		}

	}

	public void updateBook(Book book, List<Long> authors, List<Long> genres) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {

			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			bookMapper.updateBook(book);

			BookAuthorMapper bookAuthorMapper = sqlSession.getMapper(BookAuthorMapper.class);

			List<Long> lst = bookAuthorMapper.findAllAuthorBookLnkByBookId(book.getId());
			for (var author : authors) {
				bookAuthorMapper.deleteLnkBookAuthorByIds(lst);
				bookAuthorMapper.createLnkBookAuthor(book.getId(), author);
			}

			BookGenreMapper bookGenreMapper = sqlSession.getMapper(BookGenreMapper.class);
			lst = bookGenreMapper.findAllAGenreBookLnkByBookId(book.getId());
			for (var genre : genres) {
				bookGenreMapper.deleteLnkBookGenreByIds(lst);
				bookGenreMapper.createLnkBookGenre(book.getId(), genre);
			}

			sqlSession.commit();
		}
	}

	public List<Book> getBookById(Long authorLongId, Long genreLongId, Long page, Long size) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {

			AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
			GenreMapper genreMapper = sqlSession.getMapper(GenreMapper.class);
			Boolean authorExists = authorMapper.checkExists(authorLongId);
			Boolean genreExists = genreMapper.checkExists(genreLongId);
			sqlSession.rollback();
			if (!(authorExists && genreExists)) {
				log.warn("authorExists " + authorExists + ", genreExists " + genreExists);
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Non existing author or genre");
			}
			return bookMapper.getBooks(
					authorLongId,
					genreLongId,
					page,
					size
			);
		}
	}

	public Book getBookById(Long bookId) {
		return bookMapper.getBookById(bookId);
	}


}
