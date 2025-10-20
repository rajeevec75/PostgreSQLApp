package com.PostgreSQLApp.service;

import com.PostgreSQLApp.model.ProductProductType;

import java.util.List;

import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.Result;

public interface ProductProductTypeService {

    DataResult<List<ProductProductType>> getAll(int pageNumber, int pageSize);

    DataResult<ProductProductType> getById(Integer id);

    DataResult<ProductProductType> create(ProductProductType type);

    DataResult<ProductProductType> update(Integer id, ProductProductType updated);

    Result delete(Integer id);
}
