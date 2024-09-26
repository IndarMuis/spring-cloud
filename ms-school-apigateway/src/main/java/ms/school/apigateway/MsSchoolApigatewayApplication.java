package ms.school.apigateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Spring Cloud API Gateway", version = "1.0", description = "API Gateway Swagger Documentation, Select Definition menu for more documentation"))
public class MsSchoolApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSchoolApigatewayApplication.class, args);
	}

}
