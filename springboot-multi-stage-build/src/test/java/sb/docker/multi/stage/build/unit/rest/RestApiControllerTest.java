package sb.docker.multi.stage.build.unit.rest;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import sb.docker.multi.stage.build.rest.RestApiController;
import sb.docker.multi.stage.build.service.MessageService;

@RunWith(MockitoJUnitRunner.class)
public class RestApiControllerTest {

	@InjectMocks
	private RestApiController restApiController;
	
	@Mock
	private MessageService messageService;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = standaloneSetup(restApiController).build();
		doReturn("Hello world").when(messageService).getMessage();
	}
	
	
	@Test
	public void getMessage() throws Exception {
		mockMvc.perform(get("/api/hello")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello world"));
	}
}
