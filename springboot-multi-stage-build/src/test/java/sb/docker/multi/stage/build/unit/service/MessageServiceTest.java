package sb.docker.multi.stage.build.unit.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sb.docker.multi.stage.build.service.MessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

	@Autowired
	protected MessageService messageService;
	
	
	@Test
	public void getMessage() {
		String message = messageService.getMessage();
		assertThat(message, equalTo("Hello!! springboot rest api test"));
	}
	
}
