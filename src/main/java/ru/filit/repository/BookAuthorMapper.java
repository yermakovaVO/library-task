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
public interface BookAuthorMapper {

	@Select("SELECT book_author.id "
			+ "FROM LIBRARY.BOOK "
			+ "         left join library.book_author on book.id = book_author.book_id "
			+ "where book_id = #{bookId}")
	List<Long> findAllAuthorBookLnkByBookId(@Param("bookId") Long bookId);

	@Select("SELECT ba.id "
			+ "FROM LIBRARY.book_author ba "
			+ "         left join LIBRARY.author a on a.id = ba.author_id "
			+ "where author_id = #{authorId}")
	List<Long> findAllAuthorBookLnkByAuthorId(@Param("authorId") Long authorId);

	//Ужас, но такое нашлось в офишиал доке по запросу mybatis batch, я решила оставить и обсудить )
	@Delete("<script>" +
			"DELETE from LIBRARY.BOOK_AUTHOR where id in " +
			"<foreach item='item' index='index' collection='authorBookIds'" +
			" open='(' separator=',' close=')'>" +
			" #{item}" +
			"</foreach>" +
			"</script>")
	void deleteLnkBookAuthorByIds(@Param("authorBookIds") List<Long> authorBookIds);

	@Insert("Insert into LIBRARY.book_author (author_id, book_id) values(#{author_id},#{book_id})")
	void createLnkBookAuthor(@Param("book_id") Long book_id, @Param("author_id") Long author_id);

	@Update("Update LIBRARY.book_author set author_id = #{author_id}, book_id = #{book_id} where id=#{id}")
	void updateLnkBookAuthor(@Param("book_id") Long book_id, @Param("author_id") Long author_id);

	@Update("Update LIBRARY.book_author set author_id = #{author_id}, book_id = #{book_id} where id=#{id}")
	void deleteLnkBookAuthor(@Param("book_id") Long book_id, @Param("author_id") Long author_id);


}
