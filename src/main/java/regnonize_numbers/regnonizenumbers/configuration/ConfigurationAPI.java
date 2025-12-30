package regnonize_numbers.regnonizenumbers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;

@EnableWebSecurity
@Configuration
@Order(1)
 public class ConfigurationAPI {
    
    private final CorsConfig corsConfig;
    private final JwtCookieFilter jwtCookieFilter;

    public ConfigurationAPI(CorsConfig corsConfig, JwtCookieFilter jwtCookieFilter  ) {
        this.corsConfig = corsConfig;
        this.jwtCookieFilter = jwtCookieFilter;
    }

     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                 .cors(c -> c.configurationSource(corsConfig)) 
                 .csrf(csrf -> csrf.disable())
                
                 .requestCache(cache -> cache.disable())
                 .httpBasic(basic -> basic.disable())
                 .formLogin(form -> form.disable())
                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/**").permitAll()
                    .anyRequest().authenticated())
                    .addFilterBefore(jwtCookieFilter, UsernamePasswordAuthenticationFilter.class);
                    
         return http.build();
     }
}
