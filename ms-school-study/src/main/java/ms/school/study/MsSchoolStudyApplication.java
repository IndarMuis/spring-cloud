package ms.school.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableDiscoveryClient
//@EnableEurekaClient
public class MsSchoolStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSchoolStudyApplication.class, args);
	}

}
