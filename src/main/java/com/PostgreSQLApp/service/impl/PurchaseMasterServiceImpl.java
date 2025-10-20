package com.PostgreSQLApp.service.impl;

import com.PostgreSQLApp.model.PurchaseMaster;
import com.PostgreSQLApp.repository.PurchaseMasterRepository;
import com.PostgreSQLApp.service.PurchaseMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseMasterServiceImpl implements PurchaseMasterService {

    @Autowired
    private PurchaseMasterRepository purchaseMasterRepository;

    @Override
    public PurchaseMaster save(PurchaseMaster purchaseMaster) {
        return purchaseMasterRepository.save(purchaseMaster);
    }

    @Override
    public Optional<PurchaseMaster> findById(Integer id) {
        return purchaseMasterRepository.findById(id);
    }

    @Override
    public List<PurchaseMaster> findAll() {
        return purchaseMasterRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        purchaseMasterRepository.deleteById(id);
    }

    @Override
    public PurchaseMaster update(Integer id, PurchaseMaster purchaseMaster) {
        if (!purchaseMasterRepository.existsById(id)) {
            throw new RuntimeException("PurchaseMaster not found with id: " + id);
        }
        purchaseMaster.setPurchaseId(id);
        return purchaseMasterRepository.save(purchaseMaster);
    }
}
