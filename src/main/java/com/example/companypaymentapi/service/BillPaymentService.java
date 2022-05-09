package com.example.companypaymentapi.service;

import com.example.companypaymentapi.model.RequestModel;
import com.example.companypaymentapi.model.ResponseModel;

import java.util.List;

public interface BillPaymentService {
    ResponseModel createBill(RequestModel requestModel);
    ResponseModel updateBill(RequestModel requestModel);
    ResponseModel getBillByBillId(String billId);
    void deleteBillById(String billId);
    ResponseModel getBillByClientId(String clientId);
    List<ResponseModel> getAllBills();

//    DTO getAmountOfDebtByClientId(String clientId);

}
