package regnonize_numbers.regnonizenumbers.configuration;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.security.Key;

@Component
public class JwtCookieFilter extends  OncePerRequestFilter{
    
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws java.io.IOException, ServletException {
        // Implement JWT cookie extraction and validation logic here
        String token = null;
        if(request.getCookies() != null) {
            for(Cookie cookie : request.getCookies()) {
                if("jwt_token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    // Validate the JWT token using the jwtSecret
                    // If valid, set authentication in the security context
                    break;
                }
            }
        }


        if(token != null) {
            try {

                SecretKey key = Keys.hmacShaKeyFor(jwtSecret.trim().getBytes(StandardCharsets.UTF_8));
                Claims claims = Jwts.parser()
                  .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

                    String username = claims.getSubject();

                    if(username != null) {
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            username, null, new ArrayList<>());
                        // Set the authentication in the security context
                        SecurityContextHolder.getContext().setAuthentication(auth);

                    }
            }
            catch(Exception e) {
                SecurityContextHolder.clearContext();
                // Handle invalid token
            }
        }



        filterChain.doFilter(request, response);
    }
}
