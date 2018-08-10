package sb.docker.multi.stage.build.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import sb.docker.multi.stage.build.MainClassApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainClassApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApiControllerTest {

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();
	private HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveStudentCourse() {
	
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/hello"),HttpMethod.GET, entity, String.class);

		String expected = "Hello!! springboot rest api test";
		assertThat(response.getBody(), equalTo(expected));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
