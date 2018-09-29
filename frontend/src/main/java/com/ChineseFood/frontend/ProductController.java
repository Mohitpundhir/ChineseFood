package com.ChineseFood.frontend;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ChineseFood.Backend.dao.CategoryRepository;
import com.ChineseFood.Backend.dao.ProductRepository;
import com.ChineseFood.Backend.model.Category;
import com.ChineseFood.Backend.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/Adminproduct")
	public String productPage(Model model)
	{
		List<Product>AllProduct=productRepository.getAllProduct();
		List<Category> AllCategory= categoryRepository.getAllCategory();
		
		model.addAttribute("dat",new Product());
		model.addAttribute("productList",AllProduct);
		model.addAttribute("categoryList",AllCategory);
		
		return "Product";
	}
	
	@RequestMapping(value="/AdminaddProduct",method=RequestMethod.POST)
	
		public String productAdd(@Valid @ModelAttribute("dat") Product product,BindingResult result)
		{
		    if(result.hasErrors())
		    {
		    	return "Product";
		    }
		    else
		    {
			if(product.getProductId()==0)
			{
				if(productRepository.addProduct(product))
				{
					
				}
				
			}
			else
			{
					productRepository.updateProduct(product);
			}
				return "redirect:/Adminproduct";
		
		}}

			@RequestMapping("/AdmindeleteProduct/{id}")
			public String productDelete(@PathVariable("id")int productId)
					{
						productRepository.deleteProduct(productId);
						return "redirect:/Adminproduct";
					}
				

							@RequestMapping("/AdmineditProduct/{id}")
							
							public String product(@PathVariable("id")int ProductId,Model model)
							{
								Product productData=productRepository.getProductId(ProductId);
								model.addAttribute("dat",productData);
								List<Product>allProduct=productRepository.getAllProduct();
								model.addAttribute("productList",allProduct);
								return "Product";
							}
							
							
							@RequestMapping("getAllProductsBycatgeory/{categoryId}")
							
							public String getAllProductByCategory(@PathVariable("categoryId") int categoryId,Model model)
							{
								System.out.println("product by categoryid1");
								
								List<Product> productL=productRepository.getAllProducts(categoryId);
								model.addAttribute("product",productL);
								System.out.println("product by categoryid");
								return "ShowProduct";
								
							}
							
							
							
							
							
							
							
							
							
							
							
							

}
