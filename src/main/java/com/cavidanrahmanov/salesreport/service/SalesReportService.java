package com.cavidanrahmanov.salesreport.service;

import com.cavidanrahmanov.salesreport.dto.SalesDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SalesReportService {


    public List<SalesDto> fetchSalesData() {
        return Arrays.asList(
                new SalesDto("Product A", 150.0),
                new SalesDto("Product B", 320.0),
                new SalesDto("Product C", 210.0)
        );
    }


    @Scheduled(cron = "0 0 9 ? * MON")
    public void generateWeeklySalesReport() {
        List<SalesDto> salesData = fetchSalesData();
        StringBuilder report = new StringBuilder("Weekly Sales Report:\n")
                .append("Generated at: ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .append("\nProduct Name | Total Sales\n--------------------------\n");

        salesData.forEach(data -> report.append(data.getProductName())
                .append(" | ")
                .append(data.getSalesAmount())
                .append("\n"));

        log.info(report.toString());
    }
}
