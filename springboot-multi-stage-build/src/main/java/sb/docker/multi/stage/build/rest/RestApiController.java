package sb.docker.multi.stage.build.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sb.docker.multi.stage.build.service.MessageService;


@RestController
@RequestMapping(path="/api")
public class RestApiController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	private MessageService messageService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET,path="/hello", produces = "application/json")
	public @ResponseBody String getMessage() {
		LOGGER.info("Web service call to get message");
		return messageService.getMessage();
	}
	
}
