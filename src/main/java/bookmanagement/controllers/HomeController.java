package bookmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HomeController { // public method 90% က
	@RequestMapping("/") //route ( route name မတူရဘူး ( get $ post မှာတော့တူလို့ရတယ်) (form က get/ form ကနေသွားမှာက post)
	public String index() {
		return "index";
	}
}
