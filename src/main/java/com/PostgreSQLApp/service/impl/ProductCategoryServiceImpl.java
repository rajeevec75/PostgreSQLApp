package com.PostgreSQLApp.service.impl;

import com.PostgreSQLApp.model.ProductCategory;
import com.PostgreSQLApp.repository.ProductCategoryRepository;
import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.SuccessDataResult;
import com.PostgreSQLApp.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository categoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductCategory create(ProductCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<ProductCategory> getById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public DataResult<List<ProductCategory>> getAllCategories(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<ProductCategory> page = categoryRepository.findAll(pageable);
        return new SuccessDataResult<>(page.getContent(), "Categories listed successfully");
    }

    @Override
    public ProductCategory update(Integer id, ProductCategory category) {
        return categoryRepository.findById(id)
                .map(existing -> {
                    category.setId(existing.getId()); // preserve ID
                    return categoryRepository.save(category);
                })
                .orElseThrow(() -> new RuntimeException("ProductCategory not found with ID: " + id));
    }

    @Override
    public void delete(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("ProductCategory not found with ID: " + id);
        }
        categoryRepository.deleteById(id);
    }
}
