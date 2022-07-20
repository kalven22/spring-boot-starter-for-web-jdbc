package com.kalven22.springbootstarterforwebjdbc.repositories;

import com.kalven22.springbootstarterforwebjdbc.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void insertProduct(Product product) {
        String insertSQL = "INSERT INTO public.\"Product\"(\n" +
                "\tname, brand)\n" +
                "\tVALUES (?, ?)";
        jdbcTemplate.update(insertSQL, product.getName(), product.getBrand());
    }
}
