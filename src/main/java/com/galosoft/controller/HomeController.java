package com.galosoft.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.galosoft.dao.ProductDao;
import com.galosoft.model.Product;

@Controller
public class HomeController {
	
	private Path path;
	
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
	public String addProductPost(@Valid @ModelAttribute("product")Product product, HttpServletRequest request, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addProduct";
		}
		
		productDao.addProduct(product);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\views\\resources\\images\\" + product.getProductId()+ ".png");
		                               
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product saving failed...", e);
			}
		}
		
		return "redirect:/productInventory";
	}
	
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable String id, Model model,HttpServletRequest request ) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\views\\resources\\images\\" + id+ ".png");
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		productDao.deleteProduct(id);
		
		return "redirect:/productInventory";
	}
	
	
	@RequestMapping("/editProduct/{id}")
	public String editProduct(@PathVariable String id, Model model) {
		Product product = productDao.getProductById(id);
		model.addAttribute(product);
		return "editProduct";
	}
	
	@RequestMapping(value="/editProduct", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute("product")Product product, Model model, HttpServletRequest request, BindingResult result) {
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\views\\resources\\images\\" + product.getProductId()+ ".png");
		
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product saving failed...", e);
			}
		}
		if(result.hasErrors()) {
			return "editProduct";
		}
		
		productDao.editProduct(product);
		
		return "redirect:/productInventory";
		
	}
}













