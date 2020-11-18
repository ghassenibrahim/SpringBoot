package tn.essat.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tn.essat.service.IUserService;
@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter{
	 @Autowired
     IUserService service;
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder crypt=cryptMP();
		System.out.println(crypt.encode("essat"));
		auth.userDetailsService(service).passwordEncoder(crypt);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").defaultSuccessUrl("/")
		.failureUrl("/login?error=true").permitAll();
		http.authorizeRequests().antMatchers("/ajout**/**","/delete**/**").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.exceptionHandling().accessDeniedPage("/notAuthorise");
		http.csrf().disable();
	}
	@Bean
	public PasswordEncoder cryptMP() {
		return new BCryptPasswordEncoder();
	}
}
