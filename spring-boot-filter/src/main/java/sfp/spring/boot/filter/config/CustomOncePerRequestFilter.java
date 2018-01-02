package sfp.spring.boot.filter.config;

import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CustomOncePerRequestFilter extends OncePerRequestFilter {

	private static final String HEADER_PARAM_NAME_API_KEY = "apiKey";
	private static final String HEADER_PARAM_NAME_AUTHORIZATION = "Authorization";
	private static final String HEADER_PARAM_VALUE_BASIC = "Basic";
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain chain)
			throws ServletException, IOException {
		
		String headerParamApiKey = httpRequest.getHeader(HEADER_PARAM_NAME_API_KEY);
		String basicAuthUserName = getBasicAuthUserName(httpRequest);
		
		// if no api key header is provided in the header 
		// consider the basic auth header as api key
		String apiKey = (headerParamApiKey == null || headerParamApiKey.isEmpty()) ? basicAuthUserName : headerParamApiKey;
		if (isValidApiKey(apiKey)) {
			chain.doFilter(httpRequest, httpResponse);
		} else {
			httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No api key found in the request");
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>> Invoked URL = " + httpRequest.getRequestURL());;
	}
	
	private String getBasicAuthUserName(HttpServletRequest httpRequest) {
		
		String credentials = null;
		String[] values = null;
		
		try {
		
			String authorization = httpRequest.getHeader(HEADER_PARAM_NAME_AUTHORIZATION);
			if (authorization != null && authorization.startsWith(HEADER_PARAM_VALUE_BASIC)) {

				String base64Credentials = authorization.substring(HEADER_PARAM_VALUE_BASIC.length()).trim();
				credentials = new String(Base64.getDecoder().decode(base64Credentials));

				values = credentials.split(":");

				System.out.println(">>>>>>>>>>>>>> base64: " + base64Credentials);
				System.out.println(">>>>>>>>>>> credentials: " + values[0]);

				if (values != null && values.length > 0) credentials = values[0];
			}
	    
		} catch (RuntimeException exception) {exception.printStackTrace();}
	    
		return credentials;
	}
	    
	// TODO checks a user from DB or somewhere  
	private boolean isValidApiKey(String apiKey) {
	
		// TODO  perform the check from DB
		System.out.println(">>>>>>>>>>>>>>>> apiKey.equals(apiKey)" + "apiKey".equals(apiKey));
		
		return "apiKey".equals(apiKey);
	}
			
	public void prettyPrintHeader(HttpServletRequest httpRequest) {
		
		Enumeration<String> headerNmames = httpRequest.getHeaderNames();
		while (headerNmames.hasMoreElements()) {
			String name = headerNmames.nextElement();
			
			System.out.println("Header name: " + name + "    Header value: " + httpRequest.getHeader(name));
		}
	}

	public void prettyPrintRequestParameter(HttpServletRequest request) {
		for (String key : request.getParameterMap().keySet()) {
			
			System.out.println("Request key: " + key + "    value: " + request.getParameter(key));
		}
	}
}