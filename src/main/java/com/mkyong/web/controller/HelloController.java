package com.mkyong.web.controller;


import com.mkyong.web.model.User;
import com.mkyong.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

	@Autowired		// dependency injection (wire the bean "UserService" in)
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";					// 'localhost:****/' loads hello.jsp with message="Spring 3 MVC Hello World"

	}

	@RequestMapping(value = "/hello/{userid:.+}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView hello(@PathVariable("userid") int id) {	// works the same with or without @ResponseBody
		User user = userService.findUserById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("name", user.getName());

		return model;
	}

	@RequestMapping(value = "/json/{userid}", method = RequestMethod.GET)
	public @ResponseBody User getUserInJSON(@PathVariable int userid){	// without @ResponseBody, it'll look for userid.jsp
		User user = userService.findUserById(userid);
		return user;
	}

	@RequestMapping(value="/test",method=RequestMethod.GET)			// when method is not specified, it handles everything
	public String test(){		// with @ResponseBody, it returns the string "tester"
								// 	without @ResponseBody, it looks for "tester.jsp" <- view resolver defined in spring-web-servlet.xml
		return "tester";
	}

	@RequestMapping(value="/test",method = RequestMethod.POST)
	public @ResponseBody String handleRequest(@RequestParam String userid) {
		return "userid:"+userid;
	}


}