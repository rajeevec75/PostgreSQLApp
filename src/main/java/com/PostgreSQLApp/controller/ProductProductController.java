package com.PostgreSQLApp.controller;

import com.PostgreSQLApp.model.ProductProduct;
import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.ErrorResult;
import com.PostgreSQLApp.service.ProductProductService;
import com.PostgreSQLApp.util.JwtUtil;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductProductController {

    private final ProductProductService productService;

    public ProductProductController(ProductProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "1") int pageSize,
            HttpSession session) {

        // Check if Authorization header is missing
        if (token == null || token.isEmpty()) {
            return ResponseEntity.ok(new ErrorResult("Authorization header is missing. Please include 'Bearer <token>' in headers."));
        }

        // Required: Handle 'Bearer <token>' format
        if (!token.startsWith("Bearer ")) {
            return ResponseEntity.ok(new ErrorResult("Invalid token format. Token must start with 'Bearer '."));
        }

        // Extract token part
        token = token.substring(7);

        //  Validate token
        if (!JwtUtil.validateToken(token)) {
            return ResponseEntity.ok(new ErrorResult("Session expired or invalid token. Please log in again."));
        }

        // Proceed to fetch data if token is valid
        DataResult<List<ProductProduct>> result = this.productService.getAll(pageNumber, pageSize);
        return ResponseEntity.ok(result);
    }

}
