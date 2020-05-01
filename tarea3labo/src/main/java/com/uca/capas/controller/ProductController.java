package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class ProductController {
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto(){
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "GTA5", 60));
		productos.add(new Product(1, "MINECRAFT", 20));
		productos.add(new Product(2, "WOW", 10));
		productos.add(new Product(3, "COD", 8));
		productos.add(new Product(4, "ANIMAL CROSSING", 20));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		return mav;
	}
	
	@PostMapping("validar")
	@ResponseBody
	public String validar(Product product) {
		return productos.get(product.getId()).getNombre();
	}
}
