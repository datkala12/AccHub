package com.PS23665.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PS23665.dao.CategoryRepo;
import com.PS23665.dao.ProductRepo;
import com.PS23665.entity.Category;
import com.PS23665.entity.Product;
import com.PS23665.service.CategoryService;
import com.PS23665.service.ProductService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("api/")
public class HomeController {
    @Autowired
    private ProductRepo productDAO;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryRepo categoriesDAO;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping({"/","/home"})
    public String home(Model model, Principal principal) {
        return "home";
    }

    @RequestMapping("about")
    public String about() {
        return "about";
    }

    @RequestMapping("contact")
    public String contact() {
        return "contact";
    }

    
    
    @GetMapping("/products")
//    public String list1(Model model, @RequestParam("cid") Optional<String> cid) {
      public List<Product> getProducts() {
//        if (cid.isPresent()) {
//            List<Product> list = productService.findByCategoryID(cid.get());
//            model.addAttribute("items", list);
//        } else {
//            List<Product> list = productService.findAll();
//            model.addAttribute("items", list);
//        }
//        List<Category> categories = categoryService.findAll();
//        model.addAttribute("categories", categories);
//    	 List<Product> list = productService.findAll();
//    	 model.addAttribute("items", list);
        return this.productDAO.findAll(); // Đảm bảo rằng bạn chuyển hướng về view "hello"
    }
    
    
	@GetMapping("/products/detail/{id}")
	public Product detail(@PathVariable("id") Integer id) {	
		return this.productService.findById(id);
	}
	
	@GetMapping("/categories")
	public List<Category> getAllCategories() {	
		return this.categoriesDAO.findAll();
	}
	
	@GetMapping("/categories/detail/{id}")
	public Category detailCate(@PathVariable("id") Integer id) {	
		return this.categoryService.findById(id);
	}
}