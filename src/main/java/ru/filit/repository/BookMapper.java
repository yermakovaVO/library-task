package ru.filit.repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.filit.model.Book;

@Mapper
public interface BookMapper {

	@Select("SELECT * FROM LIBRARY.BOOK WHERE id = #{id}")
	Book getBookById(@Param("id") Long id);

}
