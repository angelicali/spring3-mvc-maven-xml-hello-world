package com.mkyong.web.controller;

import com.google.common.collect.Lists;
import com.mkyong.web.model.User;
import com.mkyong.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HelloController {

//
//	@RequestMapping("/")
//	@ResponseBody
//	public String Test(){
//		//User user = new User(1234,"Angelica4321");
//		//userService.saveUser(user);
//		return "hello";
//
//	}

	@Autowired		// dependency injection (wire the bean "UserService" in)
	private UserService userService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";					// 'localhost:1234/' loads hello.jsp with message="Spring 3 MVC Hello World"

	}


	@RequestMapping(value = "/hello/{userid:.+}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView hello(@PathVariable("userid") int id) {	// works the same with or without @ResponseBody
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("name", id);

		return model;
	}

	@RequestMapping(value = "/json/{userid}", method = RequestMethod.GET)
	public @ResponseBody User getUserInJSON(@PathVariable int userid){	// without @ResponseBody, it'll look for userid.jsp
		User user = userService.findOne(userid);
		return user;
	}

	@RequestMapping(value="/test",method=RequestMethod.GET)			// when method is not specified, it handles everything
	public String test(ModelMap model){		// with @ResponseBody, it returns the string "tester"
								// 	without @ResponseBody, it looks for "tester.jsp" <- view resolver defined in spring-web-servlet.xml
		model.put("users",userService.findAllUsers());
		return "tester";
	}


	@RequestMapping(value="/test",method = RequestMethod.POST)
	public @ResponseBody List handleRequest(@RequestParam int userid, @RequestParam String name) {
		userService.saveUser(new User(userid,name));
		System.out.println(name + " " + userid);
		return userService.findAllUsers();
	}



}