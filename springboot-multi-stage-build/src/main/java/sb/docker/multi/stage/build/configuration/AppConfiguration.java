package sb.docker.multi.stage.build.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import sb.docker.multi.stage.build.MainClassApplication;

@Configuration
@ComponentScan(basePackageClasses=MainClassApplication.class)
@EnableConfigurationProperties(value = {AppProperties.class})
public class AppConfiguration {
	
}
