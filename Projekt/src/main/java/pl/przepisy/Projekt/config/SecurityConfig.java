//package pl.przepisy.Projekt.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/login", "/register", "/contact", "/about", "/usersRecipes").permitAll()
//                .antMatchers("/private/**").authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessURL("/dashboard")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login")
//                .and()
//                .csrf().disable();
//    }
//}