package ms.school.apigateway.commons.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("user-service")
                .pathsToMatch("/user-service/**")
                .build();
    }

    @Bean
    public GroupedOpenApi studyApi() {
        return GroupedOpenApi.builder()
                .group("study-service")
                .pathsToMatch("/study-service/**")
                .build();
    }
}
