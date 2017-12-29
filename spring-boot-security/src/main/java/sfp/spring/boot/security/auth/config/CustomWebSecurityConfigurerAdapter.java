package sfp.spring.boot.security.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import sfp.spring.boot.security.auth.provider.CustomAuthenticationProvider;

@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println(">>>>>>>>>>>>>> configure auth " );
		
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println(">>>>>>>>>>>>>> configure http" );
		
		http.authorizeRequests().anyRequest().authenticated()
		.and()
		.httpBasic()
		.authenticationDetailsSource(new CustomAuthenticationDetailsSource());
	}
}
