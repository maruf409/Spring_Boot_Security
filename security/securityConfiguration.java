package spring.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@SuppressWarnings("all")
public class securityConfiguration {

    private final PasswordEncoder passwordEncoder;

    public securityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /* Spring Security 5.8 antMatchers, mvcMatchers, and regexMatchers methods were deprecated
     in favor of new requestMatchers methods.*/
    /*For Basic Authentication*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/spring/security/**")
                .hasRole(userRoles.Student.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return httpSecurity.build();
    }


    /*for In memory user name password genarator*/
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("Smith")
                .password(passwordEncoder.encode("smith123"))
                .roles(userRoles.Student.name())  /*delcare role for this user*/
                .build();
        UserDetails user2 = User.builder()
                .username("John")
                .password(passwordEncoder.encode("john123"))
                .roles(userRoles.Admin.name())  /*delcare role for this user*/
                .build();
        return new InMemoryUserDetailsManager(
                user1,
                user2
        );
    }

}
