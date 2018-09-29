package com.ChineseFood.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ChineseFood.Backend.dao.CategoryRepository;
import com.ChineseFood.Backend.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
		
	 @RequestMapping("/Admincategory")
		public String categoryPage(Model model)
		{  List<Category> AllCategory= categoryRepository.getAllCategory();
			model.addAttribute("cat",new Category());
			model.addAttribute("categoryList",AllCategory);
			return "category";
		}

	
	@RequestMapping(value="/AdminaddCategory",method=RequestMethod.POST)
	public String categoryaAdd(@ModelAttribute("cat") Category category)
	
	{
		if(category.getCategoryId()==0)
		{
			categoryRepository.addCategory(category);
		}
		else
		{
			categoryRepository.updateCategory(category);
		}
			return "redirect:/Admincategory";
		
	}
	
		@RequestMapping("/AdmindeleteCategory/{id}")
		
			public String categoryDelete(@PathVariable("id")int categoryId )
			{
					categoryRepository.deleteCategory(categoryId);
					return "redirect:/Admincategory";
			
			}

				@RequestMapping("/AdmineditCategory/{id}")
					public String categoryUpdate(@PathVariable("id")int categoryId,Model model)
					{
						Category categoryData=categoryRepository.getCategoryId(categoryId);
						model.addAttribute("cat",categoryData);
						List<Category>allCategory=categoryRepository.getAllCategory();
						model.addAttribute("categoryList",allCategory);
						return "category";
						
					
					}

}



