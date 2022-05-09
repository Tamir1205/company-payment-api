package com.example.companypaymentapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
    private String billId;
    @NotNull
    private String clientId;
    @NotNull

    private String paymentType;
    @NotNull

    private Double amountOfDebt;
    @Email
    private String companyEmail;
    @NotNull
    private Date dueDate;
}
