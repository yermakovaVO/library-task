package ru.filit.repository;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import ru.filit.model.Genre;

@Mapper
public interface GenreMapper {

	@Select("SELECT * FROM LIBRARY.GENRE WHERE id = #{id}")
	Genre getGenreById(@Param("id") Long id);


	@Select("SELECT * FROM LIBRARY.GENRE"
			+ "  offset #{offset} limit #{limit}")
	List<Genre> getGenres(@Param("offset") Integer offset, @Param("limit") Integer limit);

	@Delete("DELETE from LIBRARY.GENRE where id = #{id}")
	void deleteGenreById(@Param("id") Long id);

	@SelectKey(statement = "SELECT MAX(id) + 1 FROM library.genre", keyProperty = "id", resultType = Long.class, before = true)
	@Insert("Insert into LIBRARY.GENRE (id,name) values(#{id},#{name})")
	Integer createGenre(Genre person);

	@Update("Update LIBRARY.GENRE set name= #{name} where id=#{id}")
	void updateGenreById(Genre genre);

}
