package com.galosoft.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String addProductPost(@ModelAttribute("product")Product product, HttpServletRequest request) {
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
	public String deleteProduct(@PathVariable String id, Model model) {
		productDao.deleteProduct(id);
		return "redirect:/productInventory";
	}
}
