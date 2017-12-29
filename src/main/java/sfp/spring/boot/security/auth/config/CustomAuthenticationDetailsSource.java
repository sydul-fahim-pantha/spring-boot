package sfp.spring.boot.security.auth.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class CustomAuthenticationDetailsSource extends WebAuthenticationDetailsSource {
	
	@Override
	public CustomWebAuthenticationDetails buildDetails(HttpServletRequest context) {
		System.out.println(">>>>>>>>>>> Inside CustomWebAuthenticationDetails ");
		
		return new CustomWebAuthenticationDetails(context);
	}
}
