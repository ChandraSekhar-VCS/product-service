package com.chandrasekhar.productservice.controller;

import com.chandrasekhar.productservice.dto.CategoryDto;
import com.chandrasekhar.productservice.dto.ProductDto;
import com.chandrasekhar.productservice.dto.ProductListDto;
import com.chandrasekhar.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/health")
    public String healthCheck() {
        return "Product Service is up and running";
    }
    @GetMapping
    public ProductListDto getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }
    @GetMapping("/search")
    public ProductListDto searchProducts(@RequestParam(name = "q") String query){
        return productService.searchProducts(query);
    }
    @GetMapping("/category/{name}")
    public ProductListDto getProductsByCategory(@PathVariable("name") String name){
        return productService.getProductsByCategory(name);
    }
    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories(){
        return productService.getAllCategories();
    }
}
