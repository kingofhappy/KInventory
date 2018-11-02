package com.kone.bluemix.ExceptionHandling;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.kone.bluemix.Controller")
public class EquipmentExceptionController extends ResponseEntityExceptionHandler{


	
	@ExceptionHandler({Exception.class})
	/*@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)*/
	public final String handleAllExceptions(Exception ex, Model model) {
		ErrorCustomResponse error = new ErrorCustomResponse();
		error.setDetail("Please check with support team");
		error.setMessage("to get more details");
		model.addAttribute("resp", error);
        return "error";
	}
	
	/*@ResponseStatus(HttpStatus.NOT_FOUND)*/
	@ExceptionHandler(HttpClientErrorException.class)
	public final String handleNotFoundExceptions(HttpClientErrorException ex, Model model) {
		ErrorCustomResponse error = new ErrorCustomResponse();
		error.setDetail("Equipment Not Found,");
		error.setMessage("Please add to the Inventory");
		model.addAttribute("resp", error);
        return "error";
	}
	
	
}
