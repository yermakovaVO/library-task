package ru.filit.services;

import java.util.List;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.filit.repository.AuthorMapper;
import ru.filit.repository.BookAuthorMapper;
import ru.filit.repository.BookGenreMapper;
import ru.filit.repository.BookMapper;

@Service
public class AuthorDbService {


	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public void deleteAuthorById(Long authorId) {

		try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {

			BookAuthorMapper bookAuthorMapper = sqlSession.getMapper(BookAuthorMapper.class);
			BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
			BookGenreMapper bookGenreMapper = sqlSession.getMapper(BookGenreMapper.class);

			List<Long> lnkBookAuthorList = bookAuthorMapper.findAllAuthorBookLnkByAuthorId(authorId);
			List<Long> booksList = bookMapper.findAllBooksByAuthor(authorId);
			bookAuthorMapper.deleteLnkBookAuthorByIds(lnkBookAuthorList);

			for (var l : booksList) {
				List<Long> lst = bookGenreMapper.findAllAGenreBookLnkByBookId(l);
				bookGenreMapper.deleteLnkBookGenreByIds(lst);
				bookMapper.deleteBookById(l);
			}

			AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
			authorMapper.deleteAuthorById(authorId);

			sqlSession.commit();
		}

	}


}
