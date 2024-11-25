package com.cavidanrahmanov.salesreport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SalesDto {

    private String productName;
    private double salesAmount;
}
