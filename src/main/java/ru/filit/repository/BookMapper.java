package ru.filit.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.filit.model.Author;

@Mapper
public interface BookMapper {
	@Select("SELECT * FROM AUTHOR WHERE id = #{id}")
	Author getArticle(@Param("id") Long id);

}