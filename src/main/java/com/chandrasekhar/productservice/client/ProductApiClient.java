package com.chandrasekhar.productservice.client;

import com.chandrasekhar.productservice.dto.CategoryDto;
import com.chandrasekhar.productservice.dto.ProductDto;
import com.chandrasekhar.productservice.dto.ProductListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductApiClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    @Autowired
    public ProductApiClient(RestTemplate restTemplate, @Value("${dummyjson.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public ProductListDto getAllProducts(){
        String url = baseUrl+"/products";
        ProductListDto returnList = restTemplate.getForObject(url, ProductListDto.class);
        if (returnList == null || returnList.getProducts() == null || returnList.getProducts().isEmpty()) {
            return null;
        }
        return returnList;
    }

    public ProductDto getProductById(int id){
        String url = baseUrl+"/products/"+ id;
        ProductDto returnedProduct = restTemplate.getForObject(url, ProductDto.class);
        if (returnedProduct == null){
            return null;
        }
        return returnedProduct;
    }

    public ProductListDto searchProducts(String query){
        String url = baseUrl + "/products/search?q="+query;
        ProductListDto returnedList = restTemplate.getForObject(url, ProductListDto.class);
        if (returnedList == null || returnedList.getProducts() == null || returnedList.getProducts().isEmpty()) {
            return null;
        }
        return returnedList;
    }

    public ProductListDto getProductsByCategory(String category){
        String url = baseUrl + "/products/category/"+category;
        ProductListDto returnedList = restTemplate.getForObject(url, ProductListDto.class);
        if (returnedList == null || returnedList.getProducts() == null || returnedList.getProducts().isEmpty()) {
            return null;
        }
        return returnedList;
    }

    public List<CategoryDto> getAllCategories(){
        String url = baseUrl+"/products/categories";
        List<CategoryDto> returnList = restTemplate.getForObject(url,List.class);
        if (returnList == null || returnList.isEmpty()) {
            return null;
        }
        return returnList;
    }
}
