package regnonize_numbers.regnonizenumbers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
 public class ConfigurationAPI {
     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                 .cors(withDefaults()) // ✅ very important: enables CorsConfig
                 .csrf(csrf -> csrf.disable())
                 .authorizeHttpRequests(auth -> auth
                            .requestMatchers(HttpMethod.GET, "/service/test").permitAll() // Allow GET requests to /service/test
                            .requestMatchers(HttpMethod.POST, "/service/fibonacci").permitAll() // Allow POST requests to /service/fibonacci
                            .requestMatchers(HttpMethod.POST, "api/regnonize-numbers/service/send-test-message-broker").permitAll() // Allow POST requests to /service/send-test-message-broker
                            .anyRequest().authenticated() // All other requests require authentication
                    );
         return http.build();
     }
}
