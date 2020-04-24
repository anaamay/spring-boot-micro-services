package com.ril.fb.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
	HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
	LOGGER.info("Request is from : {} ", httpServletRequest.getRequestURI());
		return httpServletRequest;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
