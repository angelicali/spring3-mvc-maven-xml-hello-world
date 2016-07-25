package com.mkyong.web.controller;


import com.mkyong.web.model.User;
import com.mkyong.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{userid:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("userid") int id) {
		User user = UserService.findUserById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("name", user.getName());

		return model;
	}

	@RequestMapping(value = "/json/{userid}", method = RequestMethod.GET)
	public @ResponseBody User getUserInJSON(@PathVariable int userid){
		User user = UserService.findUserById(userid);
		return user;
	}


}