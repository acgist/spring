package com.acgist.springboot;

//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.acgist.controller.EmailController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class SprintBootTest {

	private MockMvc mvc;
	
	@Before
	public void init() {
		mvc = MockMvcBuilders.standaloneSetup(new EmailController()).build();
	}
	
	@Test
	public void test() throws Exception {
		String content = mvc.perform(MockMvcRequestBuilders.get("/book").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.name", ))
				.andExpect(content().string("hello world"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(content);
	}
	
}
