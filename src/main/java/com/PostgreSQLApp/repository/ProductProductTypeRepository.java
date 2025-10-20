package com.PostgreSQLApp.repository;

import com.PostgreSQLApp.model.ProductProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductProductTypeRepository extends JpaRepository<ProductProductType, Integer> {

}
