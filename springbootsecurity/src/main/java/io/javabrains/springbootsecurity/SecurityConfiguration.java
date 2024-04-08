package io.javabrains.springbootsecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails account1 = User.withDefaultPasswordEncoder()
            .username("blah")
            .password("blah")
            .roles("USER")
            .build();
        UserDetails account2 = User.withDefaultPasswordEncoder()
            .username("foo")
            .password("foo")
            .roles("ADMIN")
            .build();            
        return new InMemoryUserDetailsManager(account1,account2);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
            .requestMatchers("/admin").hasRole("ADMIN")
            .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
            .requestMatchers("/").permitAll()            
            .and()
            .formLogin();                        
        return http.build();
    }
}