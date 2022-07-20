package com.kalven22.springbootstarterforwebjdbc.controllers;

import com.kalven22.springbootstarterforwebjdbc.dto.Product;
import com.kalven22.springbootstarterforwebjdbc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     * All below URLS are tested & stored in
     * POSTMAN COLLECTION: spring-starter-web-jdbc
     */

    @Autowired
    private ProductService productService;

    /**
     * PostMapping & RequestBody
     */
    @PostMapping(path="/add")
    public void insertProduct(@RequestBody Product product){
        productService.insertProduct(product);
    }

    /**
     * 1.Simple return
     */
    @GetMapping(path="/")
    public String simpleTest(){
        return "Hello";
    }

    /**
     * 2.Used @PathVariable
     *(name = "brand" not required if param name is used same as String brand as below
     */
    @GetMapping(path = "/get/{brand}")
    public Product getProductByBrand(@PathVariable(name = "brand") String brand){
        //fake product implementation
        Product product = new Product();
        product.setBrand(brand);
        product.setName("Object");
        return product;
    }

    /**
     * 3.Used @RequestHeader
     * (name = "brand" not required if param name is used same as String brand as below
     */
    @GetMapping(path = "/testrh")
    public String testRequestHeader(@RequestHeader String phone, @RequestHeader String brand){
        return phone + " " + brand;
    }

    /**
     * 4.For many RequestHeaders, better to use Map<String, String>
     * (name = "brand" not required if param name is used same as String brand as below
     */
    @GetMapping(path = "/testmultiplerh")
    public Map<String, String> testmultiplerh(@RequestHeader Map<String, String> rheaders){
        return rheaders;
    }

    /**
     * 5.Edit ResponseHeader and ResponseStatus
     * Spring will inject the object in the parameter
     */
    @GetMapping(path = "/testresponseheaders")
    public String testresponseheaders(HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Brand", "Apple");
        httpServletResponse.setStatus(202);
        return "TestOK";
    }

    /**
     * 6. For getting Pdf file or image or any document
     */
    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] downloadPDF(){
        byte[] byteStreamOfPdf = new byte[100];
        return byteStreamOfPdf;
    }

    /**
     * Not implemented GET from Database because it requires using RowMapper,
     * so skipped for now
     */

}
