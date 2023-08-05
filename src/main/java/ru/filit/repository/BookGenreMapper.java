package ru.filit.repository;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookGenreMapper {

	@Select(
			"SELECT book_genre.id "
					+ "FROM LIBRARY.BOOK "
					+ "         left join library.book_genre on book.id = book_genre.genre_id "
					+ "where book_id = #{bookId}")
	List<Integer> findAllAGenreBookLnkByBookId(@Param("bookId") Long bookId);


	@Delete("<script>" +
			"DELETE from LIBRARY.BOOK_GENRE where id in " +
			"<foreach item='item' index='index' collection='genreBookIds'" +
			" open='(' separator=',' close=')'>" +
			" #{item}" +
			"</foreach>" +
			"</script>")
	void deleteLnkBookGenreByIds(@Param("genreBookIds") List<Integer> genreBookIds);


	@Insert("Insert into LIBRARY.book_genre (genre_id, book_id) values(#{genre_id}, #{book_id})")
	void createLnkBookGenre(@Param("book_id") Long book_id, @Param("genre_id") Long author_id);


	@Update("Update LIBRARY.book_genre set genre_id = #{genre_id}, book_id = #{book_id} where id=#{id}")
	void updateLnkBookAuthor(@Param("book_id") Long book_id, @Param("genre_id") Long genre_id);

}
