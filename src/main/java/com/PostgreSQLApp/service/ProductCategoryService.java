package com.PostgreSQLApp.service;

import com.PostgreSQLApp.model.ProductCategory;
import com.PostgreSQLApp.results.DataResult;
import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {

    ProductCategory create(ProductCategory category);

    Optional<ProductCategory> getById(Integer id);

    DataResult<List<ProductCategory>> getAllCategories(int pageNumber, int pageSize);

    ProductCategory update(Integer id, ProductCategory category);

    void delete(Integer id);
}
