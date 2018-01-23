package com.galosoft.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.galosoft.dao.ProductDao;
import com.galosoft.model.Product;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}
	
	@RequestMapping("/viewProduct/{productId}")
	public String  viewProduct(@PathVariable String productId,  Model model) throws IOException {
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		return "viewProduct";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);
		return "productInventory";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductStatus("Active");
		product.setProductCondition("New");
		model.addAttribute("product",product );
		return "addProduct";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product")Product product) {
		productDao.addProduct(product);
		return "redirect:/productInventory";
	}
	
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable String id, Model model) {
		productDao.deleteProduct(id);
		return "redirect:/productInventory";
	}
}
