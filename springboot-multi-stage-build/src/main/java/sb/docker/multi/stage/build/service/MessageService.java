package sb.docker.multi.stage.build.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sb.docker.multi.stage.build.configuration.AppProperties;

@Service
public class MessageService {

	private final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
	
	@Autowired
	private AppProperties properties;
	
	
	public String getMessage() {
		LOGGER.info("Service call to get message : {}", properties.getMessage());
		return properties.getMessage();
	}
	
}
