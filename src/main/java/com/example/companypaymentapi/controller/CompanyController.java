package com.example.companypaymentapi.controller;

import com.example.companypaymentapi.model.RequestModel;
import com.example.companypaymentapi.model.ResponseModel;
import com.example.companypaymentapi.service.BillPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class CompanyController {
    @Autowired
   private BillPaymentService billPaymentService;

    @PostMapping
    public ResponseModel createBill(@RequestBody RequestModel requestModel) {
        return billPaymentService.createBill(requestModel);
    }

    @PutMapping("/put")
    public ResponseModel updateBill(@RequestParam String billId, @RequestBody RequestModel requestModel) {
        requestModel.setBillId(billId);
        return billPaymentService.updateBill(requestModel);
    }
    @GetMapping("/bill")
    public ResponseModel getBillById(@RequestParam String billId) {
        return billPaymentService.getBillByBillId(billId);
    }
    @GetMapping("/all")
    public List<ResponseModel> getAllBills() {
        return billPaymentService.getAllBills();
    }

    @DeleteMapping
    public void deleteBill(@RequestParam String billId) {
        billPaymentService.deleteBillById(billId);
    }





    @GetMapping
    public ResponseModel getBillByClientId(@RequestParam String clientId) {
        return billPaymentService.getBillByClientId(clientId);
    }


}
