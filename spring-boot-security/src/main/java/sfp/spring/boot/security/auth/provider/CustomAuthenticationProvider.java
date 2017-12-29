package sfp.spring.boot.security.auth.provider;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import sfp.spring.boot.security.auth.config.CustomWebAuthenticationDetails;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		System.out.println(">>>>>>>>>>> Inside CustomAuthenticationProvider <<<<<<<<");

		CustomWebAuthenticationDetails details = ((CustomWebAuthenticationDetails) authentication.getDetails());
		System.out.println(">>>> all header map " + details.getHeaders());
		System.out.println(">>>> all request map " + details.getRequestParams());

		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println(">>>>>>>>>>>> username: " + userName + " >>>> password: " + password);

		UsernamePasswordAuthenticationToken authenticationToken = null;

		if (userName != null && userName.contains("me")) {
			authenticationToken = new UsernamePasswordAuthenticationToken(userName, password,
					new ArrayList<GrantedAuthority>());
		}

		return authenticationToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		System.out.println(">>>>>>>>>>>>>> supports: " + authentication);

		boolean authenticated = authentication.equals(UsernamePasswordAuthenticationToken.class);
		System.out.println(">>>>>>>>>>>>>> supports: " + authenticated);

		return authenticated;
	}
}
