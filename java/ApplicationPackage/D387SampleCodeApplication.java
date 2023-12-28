package ApplicationPackage;

import ApplicationPackage.translations.TimeConversionsController;
import ApplicationPackage.translations.WelcomeMessageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
		System.out.print("Hello World");
		WelcomeMessageController c = new WelcomeMessageController();
		c.getWelcomeMessage();

		TimeConversionsController t = new TimeConversionsController();
		System.out.println(t.getTimeConversions());
	}

}
