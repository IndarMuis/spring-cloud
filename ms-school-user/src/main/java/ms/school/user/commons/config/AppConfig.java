package ms.school.user.commons.config;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Key;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Key key() {
        byte[] bytes = Decoders.BASE64.decode("2B4B6250655368566D597133743677397A24432646294A404E635266546A576E");
        return Keys.hmacShaKeyFor(bytes);
    }
}
