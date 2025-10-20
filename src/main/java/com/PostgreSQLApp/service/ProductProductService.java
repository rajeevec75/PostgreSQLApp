package com.PostgreSQLApp.service;

import com.PostgreSQLApp.model.ProductProduct;
import com.PostgreSQLApp.results.DataResult;
import java.util.List;

public interface ProductProductService {

    DataResult<List<ProductProduct>> getAll(int pageNumber, int pageSize);
}
