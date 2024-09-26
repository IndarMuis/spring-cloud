package ms.school.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsSchoolEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSchoolEurekaApplication.class, args);
	}

}
