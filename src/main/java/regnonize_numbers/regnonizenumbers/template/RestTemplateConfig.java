package regnonize_numbers.regnonizenumbers.template;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

// @Profile({ "tomcat" })
// @Lazy
// @Configuration
// @SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class RestTemplateConfig {
  // @Value("${swagger.prefix.url}")
  // private String swaggerPrefixUrl;

  // @Bean
  // public OpenAPI customOpenAPI() {
  //   return new OpenAPI()
  //       .info(new io.swagger.v3.oas.models.info.Info().title("Regnonize Numbers API").version("1.0.0").description("API for recognizing and processing numbers."))
  //       .servers(List.of(new Server().url(swaggerPrefixUrl)))
  //       .security(Collections.singletonList(
  //           new io.swagger.v3.oas.models.security.SecurityRequirement().addList("bearerAuth")));
        

  // }
}
