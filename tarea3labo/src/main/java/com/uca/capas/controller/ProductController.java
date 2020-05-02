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
		
		//Telefonos
		productos.add(new Product(0, "Samsung Galaxy S20 Ulta", 30));
		productos.add(new Product(1, "Apple iPhone 11", 50));
		productos.add(new Product(2, "Xiaomi Mi Mix 2S", 7));
		productos.add(new Product(3, "Huawei P40 Pro", 5));
		productos.add(new Product(4, "Google Pixel 4 XL", 42));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		return mav;
	}
	
	@PostMapping("/validar")
	@ResponseBody
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		if(productos.get(product.getId()).getCantidad() < product.getCantidad()){
			mav.setViewName("error");
		}else {
			mav.setViewName("compra");
		}
		product.setNombre(productos.get(product.getId()).getNombre());
		mav.addObject("product", product);
		System.out.print(product.getNombre());
		return mav;
	}
}
