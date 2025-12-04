package com.td.productcatalog.getproducts.controller;

import com.td.productcatalog.getproducts.annotations.ValidEmailHeader;
import com.td.productcatalog.getproducts.model.Product;
import com.td.productcatalog.getproducts.service.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetProductsController {
    @Autowired
    GetProductService service;

    @GetMapping("/getProducts")
    public List<Product> getProducts(@ValidEmailHeader @RequestHeader String email) throws InterruptedException {

        System.out.println("request came to the controller"+ email);
        return service.getProducts();
    }
}
