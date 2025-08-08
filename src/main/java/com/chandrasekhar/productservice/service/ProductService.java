package com.chandrasekhar.productservice.service;

import com.chandrasekhar.productservice.dto.CategoryDto;
import com.chandrasekhar.productservice.dto.ProductDto;
import com.chandrasekhar.productservice.dto.ProductListDto;

import java.util.List;

public interface ProductService {
    ProductListDto getAllProducts();
    ProductDto getProductById(int id);
    ProductListDto searchProducts(String query);
    ProductListDto getProductsByCategory(String category);
    List<CategoryDto> getAllCategories();

}
