package com.PostgreSQLApp.controller;

import com.PostgreSQLApp.model.ProductProductType;
import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.Result;
import com.PostgreSQLApp.service.ProductProductTypeService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-types")
public class ProductProductTypeController {

    private final ProductProductTypeService productProductTypeService;

    public ProductProductTypeController(ProductProductTypeService productProductTypeService) {
        this.productProductTypeService = productProductTypeService;
    }

    // Get all with pagination
    @GetMapping
    public ResponseEntity<DataResult<List<ProductProductType>>> getAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {

        DataResult<List<ProductProductType>> result = productProductTypeService.getAll(pageNumber, pageSize);
        return ResponseEntity.ok(result);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<DataResult<ProductProductType>> getById(@PathVariable Integer id) {
        DataResult<ProductProductType> result = productProductTypeService.getById(id);
        return ResponseEntity.ok(result);
    }

    // Create new
    @PostMapping
    public ResponseEntity<DataResult<ProductProductType>> create(@RequestBody ProductProductType productProductType) {
        DataResult<ProductProductType> result = productProductTypeService.create(productProductType);
        return ResponseEntity.ok(result);
    }

    // Update existing
    @PutMapping("/{id}")
    public ResponseEntity<DataResult<ProductProductType>> update(
            @PathVariable Integer id,
            @RequestBody ProductProductType updatedProductType) {

        DataResult<ProductProductType> result = productProductTypeService.update(id, updatedProductType);

        return ResponseEntity.ok(result);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Integer id) {
        Result result = productProductTypeService.delete(id);

        return ResponseEntity.ok(result);
    }
}
