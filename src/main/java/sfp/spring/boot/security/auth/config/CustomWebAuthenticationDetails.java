package sfp.spring.boot.security.auth.config;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

	private static final long serialVersionUID = 1L;

	private final Map<String, Object> headers = new HashMap<>();
	private final Map<String,Object> requestParams = new HashMap<>();
	
	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		
		System.out.println("Inside CustomWebAuthenticationDetails");
		
		prettyPrintHeader(request);
		prettyPrintRequestParameter(request);
	}
	
	public void prettyPrintHeader(HttpServletRequest request) {
		Enumeration<String> headerNmames = request.getHeaderNames();
		while (headerNmames.hasMoreElements()) {
			String name = headerNmames.nextElement();
			headers.put(name, request.getHeader(name));
			
			System.out.println("Header name: " + name + "    Header value: " + request.getHeader(name));
		}
	}

	public void prettyPrintRequestParameter(HttpServletRequest request) {
		for (String key : request.getParameterMap().keySet()) {
			requestParams.put(key, request.getParameter(key));
			
			System.out.println("Request key: " + key + "    value: " + request.getParameter(key));
		}
	}
	
	public Map<String, Object> getHeaders() {
		return headers;
	}
	
	public Map<String, Object> getRequestParams() {
		return requestParams;
	}
}
