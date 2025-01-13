package group.aca.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour les tests
                .cors(cors -> {}) // Activer CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // Autoriser toutes les requêtes sous /api
                        .anyRequest().authenticated() // Authentification requise pour le reste
                );
        return http.build();
    }
}


