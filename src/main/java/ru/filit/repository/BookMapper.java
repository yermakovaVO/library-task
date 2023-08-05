package ru.filit.repository;


import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import ru.filit.model.Book;
import ru.filit.model.BookAuthor;
import ru.filit.model.BookGenre;

@Mapper
public interface BookMapper {

	@Select("SELECT book.id, book.name, book.year FROM LIBRARY.BOOK WHERE id = #{id}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "year", column = "year"),

			@Result(property = "authors", javaType = List.class, column = "id", many = @Many(select = "getAuthorsForBook")),
			@Result(property = "genres", javaType = List.class, column = "id", many = @Many(select = "getGenresForBook"))
	})
	Book getBookById(@Param("id") Long id);

	@Select("SELECT * FROM LIBRARY.BOOK_AUTHOR WHERE LIBRARY.BOOK_AUTHOR.book_id = #{id}")
	@Results(value = {
			@Result(property = "authorId", column = "author_id"),
			@Result(property = "bookId", column = "book_id")
	})
	List<BookAuthor> getAuthorsForBook(Long id);


	@Select("SELECT * FROM LIBRARY.BOOK_GENRE WHERE LIBRARY.BOOK_GENRE.book_id = #{id}")
	@Results(value = {
			@Result(property = "genreId", column = "genre_id"),
			@Result(property = "bookId", column = "book_id")
	})
	List<BookGenre> getGenresForBook(Long id);


	//oO в май батис нет пагинации встроенной? сделала свою
	@Select("SELECT LIBRARY.BOOK.*"
			+ "FROM LIBRARY.BOOK "
			+ "         left join library.book_author on book.id = book_author.book_id "
			+ "         left join library.author on book_author.author_id = author.id "
			+ "         left join library.book_genre on book.id = book_genre.book_id "
			+ "         left join library.genre on book_genre.genre_id = genre.id "
			+ "  WHERE (#{authorId}::bigint is null or author.id = #{authorId})"
			+ "  AND (#{genreId}::bigint is null or genre.id = #{genreId})"
			+ "  group by LIBRARY.BOOK.id"
			+ "  offset #{offset} limit #{limit}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "year", column = "year"),

			@Result(property = "authors", javaType = List.class, column = "id", many = @Many(select = "getAuthorsForBook")),
			@Result(property = "genres", javaType = List.class, column = "id", many = @Many(select = "getGenresForBook"))
	}) //не смотрела как это выглядит в дебаге. тут точно не n+1?)
	List<Book> getBooks(@Param("authorId") Long authorId, @Param("genreId") Long genreId,
			@Param("offset") Long offset, @Param("limit") Long limit);


	@Select("SELECT book.id "
			+ " "
			+ "FROM LIBRARY.BOOK "
			+ "         left join library.book_author on book.id = book_author.book_id "
			+ "         left join library.author on book_author.author_id = author.id "
			+ " "
			+ "where author_id = #{authorId}")
	List<Long> findAllBooksByAuthor(@Param("authorId") Long authorId);


	@Delete("DELETE from LIBRARY.BOOK where id = #{id}")
	void deleteBookById(@Param("id") Long id);

	@SelectKey(statement = "SELECT MAX(id) + 1 FROM library.book", keyProperty = "id", resultType = Long.class, before = true)
	@Insert("Insert into LIBRARY.BOOK (id, year,name) values(#{id},#{year},#{name})")
	Integer createBook(Book person);

	@Update("Update LIBRARY.BOOK set year = #{year}, name= #{name} where id=#{id}")
	void updateBook(Book person);


}
