package com.PostgreSQLApp.repository;

import com.PostgreSQLApp.model.PurchaseMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseMasterRepository extends JpaRepository<PurchaseMaster, Integer> {

}
