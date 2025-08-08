package com.chandrasekhar.productservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductListDto {
    private List<ProductDto> products;
    private int total;
    private int skip;
    private int limit;
}
