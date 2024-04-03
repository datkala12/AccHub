package com.PS23665.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PS23665.entity.Product;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	private List<Product> cart = new ArrayList<>();
	
	@PostMapping("/add")
    public ResponseEntity<Void> addToCart(@RequestBody Product product) {
        cart.add(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Integer productId) {
        cart.removeIf(p -> p.getId()==productId);
        return ResponseEntity.ok().build();
    }
	
	@GetMapping("/items")
    public ResponseEntity<List<Product>> getCartItems() {
        return ResponseEntity.ok(cart);
    }
}
