package com.lsh.testing05.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
		
		String contentType = request.getHeader("Content-Type"); 
		ModelAndView model=null;
		String reason= HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
		int statusCode= HttpStatus.INTERNAL_SERVER_ERROR.value();
		
		if(contentType != null && MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
			model = new ModelAndView("jsonView");
			ResponseStatus annotation = exception.getClass().getAnnotation(ResponseStatus.class);
			
			if(annotation != null) {
				reason = annotation.reason();
				statusCode = annotation.value().value();
			}
			
		} 

		model.addObject("reason", reason);
		model.addObject("status", statusCode);
		response.setStatus(statusCode);

		return model;
		
	}
}
