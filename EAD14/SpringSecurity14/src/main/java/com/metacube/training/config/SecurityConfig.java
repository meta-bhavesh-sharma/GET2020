package com.metacube.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetails;
	
	@Override
	public void configure( AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetails);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user").hasAuthority("USER")
		.antMatchers("/employees").hasAuthority("USER")
		.antMatchers("/plan").hasAuthority("USER")
		.antMatchers("/veichle").hasAuthority("USER")
		.antMatchers("/setimage").hasAuthority("USER")
		.antMatchers("/userhome").hasAuthority("USER")
		.antMatchers("/Mr_baba_17").hasAuthority("ADMIN")
		.antMatchers("/allemployees").hasAuthority("ADMIN")
		.antMatchers("/home").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers(HttpMethod.POST,"/setimage").permitAll()
		.antMatchers("/Resources/static/**").permitAll()
		.and()
		.formLogin()
        .loginPage("/login")
        .and().logout().logoutSuccessUrl("/");
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

}
