package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

@Controller
public class HelloController {
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("data","hello!!");
		return "hello";
	}

}
