package com.example.companypaymentapi.service;

import com.example.companypaymentapi.model.RequestModel;
import com.example.companypaymentapi.model.ResponseModel;
import com.example.companypaymentapi.repository.BillEntity;
import com.example.companypaymentapi.repository.BillRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillPaymentService {
    @Autowired
    private BillRepository billRepository;
    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    }

    @Override
    public ResponseModel createBill(RequestModel requestModel) {
        requestModel.setBillId(UUID.randomUUID().toString());
        BillEntity billEntity = modelMapper.map(requestModel, BillEntity.class);
        billRepository.save(billEntity);
        return modelMapper.map(billEntity, ResponseModel.class);
    }

    @Override
    public ResponseModel updateBill(RequestModel requestModel) {
        BillEntity billEntity = modelMapper.map(requestModel, BillEntity.class);
        BillEntity dbEntity = billRepository.getBillEntitiesByBillId(billEntity.getBillId());
        billEntity.setBillId(dbEntity.getBillId());
        billEntity = billRepository.save(billEntity);
        return modelMapper.map(billEntity, ResponseModel.class);
    }

    @Override
    public ResponseModel getBillByBillId(String billId) {
        BillEntity billEntity = billRepository.getBillEntitiesByBillId(billId);
        return modelMapper.map(billEntity, ResponseModel.class);
    }

    @Override
    public void deleteBillById(String billId) {
    billRepository.deleteBillEntitiesByBillId(billId);
    }

    @Override
    public ResponseModel getBillByClientId(String clientId) {
        BillEntity billEntity= billRepository.getBillEntitiesByClientId(clientId);
        return modelMapper.map(billEntity,ResponseModel.class);
    }

    @Override
    public List<ResponseModel> getAllBills() {
        return billRepository.getBillEntitiesBy().stream().map(billEntity ->
                modelMapper.map(billEntity,ResponseModel.class)).collect(Collectors.toList());
    }

//    @Override
//    public DTO getAmountOfDebtByClientId(String clientId) {
//        BillEntity billEntity= billRepository.getBillEntitiesByClientId(clientId);
//        return modelMapper.map(billEntity,DTO.class);
//    }
}
