package com.etiqa.custpro.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Component
@WebFilter(urlPatterns = "/api/**")
@Order(-999)
@Log4j2
public class AccessLogFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
		log.info("Received request for "+"[" + req.getMethod() + "] " + req.getRequestURI() + getParameters(req));
		ContentCachingRequestWrapper request = new ContentCachingRequestWrapper(req);
		ContentCachingResponseWrapper response = new ContentCachingResponseWrapper(resp);
		
		filterChain.doFilter(request, response);

		log.info("request body = {}", new String(request.getContentAsByteArray(), StandardCharsets.UTF_8));
		log.info("response body = {}", new String(response.getContentAsByteArray(), StandardCharsets.UTF_8));
		
		response.copyBodyToResponse();
	}
	
	private String getParameters(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Enumeration<?> e = request.getParameterNames();
		if (e != null) {
			sb.append("?");
		}
		
		while (e.hasMoreElements()) {
			if (sb.length() > 1) {
				sb.append("&");
			}
			String next = (String) e.nextElement();
			sb.append(next).append("=");
			if (next.contains("password") || next.contains("answer") || next.contains("pwd")) {
				sb.append("****");
			}
			else {
				sb.append(request.getParameter(next));
			}
		}
		
		String ip = request.getHeader("X-FORWARDED-FOR");
		String ipAddress = (ip == null) ? getRemoteAddr(request) : ip;
		if (!StringUtils.isEmpty(ipAddress)) {
			sb.append("&_psip=" + ipAddress);
		}
		return sb.toString();
	}
	
	private String getRemoteAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip != null && ip.length() > 0) {
			return ip;
		}
		return request.getRemoteAddr();
	}
}
