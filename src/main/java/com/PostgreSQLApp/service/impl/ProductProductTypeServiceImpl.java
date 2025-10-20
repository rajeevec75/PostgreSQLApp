package com.PostgreSQLApp.service.impl;

import com.PostgreSQLApp.model.ProductProductType;
import com.PostgreSQLApp.repository.ProductProductTypeRepository;
import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.ErrorDataResult;
import com.PostgreSQLApp.results.ErrorResult;
import com.PostgreSQLApp.results.Result;
import com.PostgreSQLApp.results.SuccessDataResult;
import com.PostgreSQLApp.results.SuccessResult;
import com.PostgreSQLApp.service.ProductProductTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class ProductProductTypeServiceImpl implements ProductProductTypeService {

    private final ProductProductTypeRepository productProductTypeRepository;

    @Autowired
    public ProductProductTypeServiceImpl(ProductProductTypeRepository productProductTypeRepository) {
        this.productProductTypeRepository = productProductTypeRepository;
    }

    @Override
    public DataResult<List<ProductProductType>> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<ProductProductType> page = this.productProductTypeRepository.findAll(pageable);
        return new SuccessDataResult<>(page.getContent(), "All product types listed");
    }

    @Override
    public DataResult<ProductProductType> getById(Integer id) {
        Optional<ProductProductType> optProductProductType = productProductTypeRepository.findById(id);

        if (optProductProductType.isEmpty()) {
            return new ErrorDataResult<>("Product type not found with ID: " + id);
        }

        return new SuccessDataResult<>(optProductProductType.get(), "Product type found");
    }

    @Override
    public DataResult<ProductProductType> create(ProductProductType type) {
        return new SuccessDataResult<>(productProductTypeRepository.save(type), "Product type created");
    }

    @Override
    public DataResult<ProductProductType> update(Integer id, ProductProductType updated) {
        Optional<ProductProductType> existingOpt = productProductTypeRepository.findById(id);

        if (existingOpt.isEmpty()) {
            return new ErrorDataResult<>("Product type not found with ID: " + id);
        }

        ProductProductType existing = existingOpt.get();

        // Update fields — for example, name, slug, hasVariants, etc.
        existing.setName(updated.getName());
        existing.setSlug(updated.getSlug());
        existing.setHasVariants(updated.isHasVariants());
        existing.setShippingRequired(updated.isShippingRequired());
        existing.setWeight(updated.getWeight());
        existing.setDigital(updated.isDigital());
        existing.setMetadata(updated.getMetadata());
        existing.setPrivateMetadata(updated.getPrivateMetadata());
        existing.setKind(updated.getKind());
        existing.setTaxClassId(updated.getTaxClassId());

        ProductProductType saved = productProductTypeRepository.save(existing);
        return new SuccessDataResult<>(saved, "Product type updated successfully");
    }

    @Override
    public Result delete(Integer id) {
        if (!productProductTypeRepository.existsById(id)) {
            return new ErrorResult("Product type not found with ID: " + id);
        }
        productProductTypeRepository.deleteById(id);
        return new SuccessResult("Product type deleted");
    }
}
