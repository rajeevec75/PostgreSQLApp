package com.PostgreSQLApp.service;

import com.PostgreSQLApp.model.PurchaseMaster;
import java.util.List;
import java.util.Optional;

public interface PurchaseMasterService {

    PurchaseMaster save(PurchaseMaster purchaseMaster);

    Optional<PurchaseMaster> findById(Integer id);

    List<PurchaseMaster> findAll();

    void deleteById(Integer id);

    PurchaseMaster update(Integer id, PurchaseMaster purchaseMaster);
}
