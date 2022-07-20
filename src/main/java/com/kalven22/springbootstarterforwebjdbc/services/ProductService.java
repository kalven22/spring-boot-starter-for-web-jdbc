package com.kalven22.springbootstarterforwebjdbc.services;

import com.kalven22.springbootstarterforwebjdbc.dto.Product;
import com.kalven22.springbootstarterforwebjdbc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }
}
