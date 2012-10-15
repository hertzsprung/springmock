package uk.co.datumedge.springmock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyCollaboratorConfig.class)
public class MyServiceConfig {
	@Autowired private MyCollaboratorConfig collaboratorConfig;
	
	@Bean
	public MyService myService() {
		return new MyRealService(collaboratorConfig.myCollaborator());
	}
}
