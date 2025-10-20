package com.PostgreSQLApp.controller;

import com.PostgreSQLApp.model.PurchaseMaster;
import com.PostgreSQLApp.service.PurchaseMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseMasterController {

    @Autowired
    private PurchaseMasterService service;

    @PostMapping
    public ResponseEntity<PurchaseMaster> create(@RequestBody PurchaseMaster purchaseMaster) {
        return ResponseEntity.ok(service.save(purchaseMaster));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseMaster>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseMaster> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseMaster> update(@PathVariable Integer id, @RequestBody PurchaseMaster purchaseMaster) {
        return ResponseEntity.ok(service.update(id, purchaseMaster));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
