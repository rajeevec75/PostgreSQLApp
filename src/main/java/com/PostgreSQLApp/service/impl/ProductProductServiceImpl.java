package com.PostgreSQLApp.service.impl;

import com.PostgreSQLApp.model.ProductProduct;
import com.PostgreSQLApp.repository.ProductProductRepository;
import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.SuccessDataResult;
import com.PostgreSQLApp.service.ProductProductService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductProductServiceImpl implements ProductProductService {

    private final ProductProductRepository productProductRepository;

    public ProductProductServiceImpl(ProductProductRepository productProductRepository) {
        this.productProductRepository = productProductRepository;
    }

    @Override
    public DataResult<List<ProductProduct>> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<ProductProduct> productProducts = this.productProductRepository.findAll(pageable);
        List<ProductProduct> products = productProducts.getContent();

        return new SuccessDataResult<>(products, "Products fetched successfully.");
    }

}
