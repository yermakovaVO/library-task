package ru.filit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest()
@AutoConfigureMockMvc
public class RESTTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void errorCase() throws Exception {
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(
				"/api/v1//books?page=0&size=100&genreId=999&authorId=1"));
		response.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}

	public void checkGetBooksEndpoint() throws Exception {

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books"));
		response.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
