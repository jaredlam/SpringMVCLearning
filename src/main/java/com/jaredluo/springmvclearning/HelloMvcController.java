package com.jaredluo.springmvclearning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
