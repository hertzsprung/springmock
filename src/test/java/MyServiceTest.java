import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.co.datumedge.springmock.MyCollaborator;
import uk.co.datumedge.springmock.MyService;
import uk.co.datumedge.springmock.MyServiceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyServiceConfig.class, MyServiceTest.Config.class})
@DirtiesContext(classMode=AFTER_EACH_TEST_METHOD)
public class MyServiceTest {
	@Rule @Autowired public JUnitRuleMockery context;
	@Autowired private MyService service;
	@Autowired private MyCollaborator collaborator;
	
	@Test
	public void test() {
		context.checking(new Expectations() {{
			allowing(collaborator).compute(); will(returnValue(42));
		}});
		
		assertThat(service.performUsefulFunction(), equalTo(84));
	}
	
	@Configuration
	public static class Config {
		@Bean
		public JUnitRuleMockery context() {
			return new JUnitRuleMockery();
		}
		
		@Bean
		public MyCollaborator myCollaborator() {
			return context().mock(MyCollaborator.class);
		}
	}
}
