package com.chandrasekhar.productservice.service;

import com.chandrasekhar.productservice.client.ProductApiClient;
import com.chandrasekhar.productservice.dto.CategoryDto;
import com.chandrasekhar.productservice.dto.ProductDto;
import com.chandrasekhar.productservice.dto.ProductListDto;
import com.chandrasekhar.productservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductApiClient productApiClient;
    @Autowired
    public ProductServiceImpl(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    @Override
    public ProductListDto getAllProducts(){
        ProductListDto productList = productApiClient.getAllProducts();
        if (productList == null || productList.getProducts() == null || productList.getProducts().isEmpty()) {
            throw new ResourceNotFoundException("No products available");
        }
        return productList;
    }
    @Override
    public ProductDto getProductById(int id){
        ProductDto productDto = productApiClient.getProductById(id);
        if(productDto == null){
            throw new ResourceNotFoundException("Product not found");
        }
        return productDto;
    }
    @Override
    public ProductListDto searchProducts(String query){
        ProductListDto productList = productApiClient.searchProducts(query);
        if (productList == null || productList.getProducts() == null || productList.getProducts().isEmpty()) {
            throw new ResourceNotFoundException("No products found matching query: " + query);
        }
        return productList;
    }
    @Override
    public ProductListDto getProductsByCategory(String category){
        ProductListDto productList = productApiClient.getProductsByCategory(category);
        if (productList == null || productList.getProducts() == null || productList.getProducts().isEmpty()) {
            throw new ResourceNotFoundException("No products found in category: " + category);
        }
        return productList;
    }
    @Override
    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> categoryList = productApiClient.getAllCategories();
        if (categoryList == null || categoryList.isEmpty()) {
            throw new ResourceNotFoundException("No product categories available");
        }
        return categoryList;
    }
}
