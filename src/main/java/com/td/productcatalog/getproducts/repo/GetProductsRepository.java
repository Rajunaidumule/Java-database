package com.td.productcatalog.getproducts.repo;

import com.td.productcatalog.getproducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface GetProductsRepository extends JpaRepository<Product, Integer> {

}
