package com.example.companypaymentapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
    private String billId;
    private String clientId;
    private String paymentType;
    private Double amountOfDebt;
    private Date dueDate;
    private String companyEmail;

}
