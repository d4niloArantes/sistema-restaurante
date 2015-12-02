package fpu.si4p.t2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControl 
{
	@RequestMapping("/login")
	public String goLogin() 
	{		
		return "Login";
	}
	
	@RequestMapping("/")
	public String goHome() 
	{
		return "Home";
	}
}
