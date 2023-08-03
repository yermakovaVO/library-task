package ru.filit.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.filit.model.Author;
import ru.filit.model.Genre;

@Mapper
public interface GenreMapper {

	@Select("SELECT * FROM LIBRARY.GENRE WHERE id = #{id}")
	Genre getGenreById(@Param("id") Long id);

}
