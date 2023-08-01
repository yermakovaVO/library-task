package ru.filit;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.filit.config.DataSourceConfig;
import ru.filit.repository.AuthorMapper;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
class LibraryTests {

	@Autowired
	AuthorMapper authorMapper;

	@Test
	void getArticleById() {
		authorMapper.getArticle(123L);
	}

}