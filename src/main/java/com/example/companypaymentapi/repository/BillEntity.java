package com.example.companypaymentapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "company-payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillEntity {
    @Id
    @Field(type= FieldType.Keyword)
    private String billId;
    @Field(type= FieldType.Keyword)
    private String clientId;
    @Field(type= FieldType.Text)
    private String paymentType;
    @Field(type= FieldType.Double)
    private Double amountOfDebt;
    @Field(type = FieldType.Date)
    private Date dueDate;

}
