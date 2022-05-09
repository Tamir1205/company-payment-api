package com.example.companypaymentapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BillRepository extends ElasticsearchRepository<BillEntity,String> {
   void deleteBillEntitiesByBillId(String billId);
   BillEntity getBillEntitiesByClientId(String clientId);
   List<BillEntity> getBillEntitiesBy();
   BillEntity getBillEntitiesByBillId(String billId);



}
