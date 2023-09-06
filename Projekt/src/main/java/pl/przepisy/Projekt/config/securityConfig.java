package pl.przepisy.Projekt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home", "/recipe", "/about", "/contact", "/User/login", "/User/register").permitAll()
                // Tutaj dodaj inne ścieżki, do których niezalogowani użytkownicy mają dostęp
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/User/login")
                .defaultSuccessURL("/dashboard") // Przekierowanie po zalogowaniu
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}