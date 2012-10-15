package uk.co.datumedge.springmock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCollaboratorConfig {
	@Bean
	public MyCollaborator myCollaborator() {
		return new MyRealCollaborator();
	}
}
