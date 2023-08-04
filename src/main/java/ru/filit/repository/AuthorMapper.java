package ru.filit.repository;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import ru.filit.model.Author;

@Mapper
public interface AuthorMapper {

	@Select("SELECT * FROM LIBRARY.AUTHOR WHERE id = #{id}")
	Author getAuthorById(@Param("id") Long id);

	@Select("SELECT * FROM LIBRARY.AUTHOR "
			+ "  offset #{offset} limit #{limit}")
	List<Author> getAuthors(@Param("offset") Long offset, @Param("limit") Long limit);

	@Delete("DELETE from LIBRARY.AUTHOR where id = #{id}")
	void deleteAuthorById(@Param("id") Long id);


	//	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") //не сработало, сделала SELECT MAX(id) + 1
	@SelectKey(statement = "SELECT MAX(id) + 1 FROM library.author", keyProperty = "id", resultType = Long.class, before = true)
	@Insert("Insert into LIBRARY.AUTHOR ( id, nickname,name,surname,midname) values(#{id}, #{nickname},#{name},#{surname},#{midname} )")
	Integer createAuthor(Author person);

	@Update("Update LIBRARY.AUTHOR set nickname = #{nickname}, name= #{name}, surname = #{surname}, midname = #{midname} where id=#{id}")
	void updateAuthorById(Author person);


}
