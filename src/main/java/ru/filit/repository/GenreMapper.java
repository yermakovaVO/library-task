package ru.filit.repository;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.filit.model.Genre;

@Mapper
public interface GenreMapper {

	@Select("SELECT * FROM LIBRARY.GENRE WHERE id = #{id}")
	Genre getGenreById(@Param("id") Long id);


	@Select("SELECT * FROM LIBRARY.GENRE")
	List<Genre> getGenres(@Param("offset") Integer offset, @Param("limit") Integer limit);

	@Delete("DELETE from LIBRARY.GENRE where id = #{id}")
	void deleteGenreById(@Param("id") Long id);

	@Insert("Insert into LIBRARY.GENRE (nickname,name,surname,midname,genderId) values(#{nickname},#{name}),#{surname}),#{midname}),#{genderId}))")
	Integer createGenre(Genre person);

	@Update("Update LIBRARY.GENRE set nickname = #{nickname} name= #{name}, surname = #{surname}, midname = #{midname} , genderId = #{genderId} where id=#{id}")
	void updateGenreById(@Param("id") Long id);

}
