package com.Dict.demo;



import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class DictController 
{
	
	
	@Autowired 
	RegisterService RegisterServiceObj;
	
	@Autowired
	LoginService LoginServiceObj;
	
	@Autowired
	AcronymService AcronymServiceObj;
	
	String appName="Acronym Dictionary";

	@RequestMapping("/welcome")
	public String welcome(Model model) 
	{
        model.addAttribute("appName", appName);
        return "Welcome";
	}
	
	
	@GetMapping("/login")
	public String login()
	{
		return "Login";
	}
	
/*	@GetMapping("/google")
	public String google()
	{
		return "Google";
	}
*/	
	@GetMapping("/verify")
	public String verify(@ModelAttribute("user") Users user, Model model)
	{
		//System.out.println(user.getEmailID());
		//System.out.println(user.getPassword());
		model.addAttribute("user", user);
		String result = LoginServiceObj.verify(user.getEmailID(), user.getPassword());
		return result;
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "Register";
	}

	@PostMapping("/register")
	public String registerDetails(@ModelAttribute("user") Users user, Model model) 
	  {
	    System.out.println(user.getEmailID());
	    model.addAttribute("user", user);
	    RegisterServiceObj.addUser(user);
	    return "RegisterSuccess";
      }
      
/*	@PostMapping("/search")
	public String search(@ModelAttribute("acronyms")Acronyms acronyms, Model model)
	{
		System.out.println(acronyms.getAcronym());
		System.out.println(AcronymServiceObj.search(acronyms.getAcronym()));
		String fullForm = AcronymServiceObj.search(acronyms.getAcronym());
		
		
		  
		return "AcronymResult";
		
		
	}
	*/
	
	@PostMapping("/output")
	public String search(@ModelAttribute("acronyms")Acronyms acronyms,ModelMap modelMap)
	   {
		System.out.println(acronyms.getAcronym());
		System.out.println(AcronymServiceObj.search(acronyms.getAcronym()));
		modelMap.put("fullForm", AcronymServiceObj.search(acronyms.getAcronym()));
		return "AcronymResult";
       }
	
	
}