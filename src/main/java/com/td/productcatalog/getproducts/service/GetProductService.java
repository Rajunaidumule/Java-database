package com.td.productcatalog.getproducts.service;

import com.td.productcatalog.getproducts.model.Product;
import com.td.productcatalog.getproducts.repo.GetProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductService {
    @Autowired
    GetProductsRepository repository;

    public List<Product> getProducts() {
      return   repository.findAll();
    }

}
