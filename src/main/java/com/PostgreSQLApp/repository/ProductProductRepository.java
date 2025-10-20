package com.PostgreSQLApp.repository;

import com.PostgreSQLApp.model.ProductProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductProductRepository extends JpaRepository<ProductProduct, Integer> {

}
