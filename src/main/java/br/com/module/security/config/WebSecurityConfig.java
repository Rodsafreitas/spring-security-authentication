package br.com.module.security.config;

import br.com.module.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationDatabase authenticationDatabase;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new SuccessAutenthication();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationDatabase);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/welcome", "/dashboard").hasAnyRole("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/login", "/resource/**").permitAll()
                .and()
                .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
                .loginProcessingUrl("/doLogin")
                .successForwardUrl("/welcome")
                .failureUrl("/loginFailed")
                .successHandler(authenticationSuccessHandler())
                .and()
                .logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
                .and()
                .csrf().disable();
    }

}
