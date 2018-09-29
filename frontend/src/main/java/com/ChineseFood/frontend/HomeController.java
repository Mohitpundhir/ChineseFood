package com.ChineseFood.frontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ChineseFood.Backend.dao.CategoryRepository;

@Controller
public class HomeController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/Home")
	
		public String indexpage(HttpSession session)
		{		
		
		
		return "index";
	}
	

	@RequestMapping("/")
	public String  homepage(HttpSession session)
	{
		
		session.setAttribute("categoryList", categoryRepository.getAllCategory());
		return "index";
		
		
	}
			
	
	
	
	
	
	@RequestMapping("/AdminHome")
		
		public String Adminhome()
		{
		
			return "Admin";
		
		}
}
