package com.td.productcatalog.getproducts.controller;

import com.td.productcatalog.getproducts.annotations.ValidEmailHeader;
import com.td.productcatalog.getproducts.model.Product;
import com.td.productcatalog.getproducts.service.EncryptDecryptService;
import com.td.productcatalog.getproducts.service.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetProductsController {
    @Autowired
    GetProductService service;
    @Autowired
    EncryptDecryptService encryptDecryptService;
    @GetMapping("/getProducts")
    public List<Product> getProducts(@ValidEmailHeader @RequestHeader String email) throws InterruptedException {


        System.out.println("request came to the controller"+ email);
        return service.getProducts();
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/getProductsWithSortingInAscendingOrder/{field}")
    public List<Product> getProductsWithSortingAscendingOrder(@PathVariable String field) {
        return service.getProductsWithSortingAscendingOrder(field);

    }

    @GetMapping("/getProductsBasedOnPagination/{offset}/{pageSize}")
    public Page<Product> getProductsBasedOnPagination(@PathVariable int offset, @PathVariable int pageSize){
        return service.getProductsBasedOnPagination(offset, pageSize);
    }

    @GetMapping("/getProductsBasedOnPaginationWithSorting/{offset}/{pageSize}/{field}")
    public Page<Product> getProductsBasedOnPaginationwithSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        return service.getProductsBasedOnPaginationwithSorting(offset, pageSize, field);
    }

    @GetMapping("/convertToEncryptedFormat/{number}")
    public String convertToEncryptedFormat(@PathVariable String number) {
         return encryptDecryptService.encrypt(number);
    }

    @GetMapping("/convertToDecryptedFormat/{number}")
    public String converToDecrypted(@PathVariable String number){
        return encryptDecryptService.decrypt(number);
    }
}
