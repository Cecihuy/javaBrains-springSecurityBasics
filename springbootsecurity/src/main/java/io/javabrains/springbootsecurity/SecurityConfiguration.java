package io.javabrains.springbootsecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
}