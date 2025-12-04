package com.td.productcatalog.getproducts.service;

import com.td.productcatalog.getproducts.model.Product;
import com.td.productcatalog.getproducts.repo.GetProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GetProductService {
    @Autowired
    GetProductsRepository repository;

    public List<Product> getProducts() {
      return   repository.findAll();
    }

    public String addProduct(Product product) {

        for(int i=0; i<200; i++){
            Product product1 = new Product();
            product1.setProductName(product.getProductName()+ Math.random()*100);
            product1.setProductValue(product.getProductValue());
            product1.setProductNumber(product.getProductNumber()+Integer.valueOf((int) (Math.random()*120)));
            repository.save(product1);
        }

        return "Saved successfully";
    }

    public List<Product> getProductsWithSortingAscendingOrder(String field) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }
}
