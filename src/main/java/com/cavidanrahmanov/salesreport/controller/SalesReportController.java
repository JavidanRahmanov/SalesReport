package com.cavidanrahmanov.salesreport.controller;

import com.cavidanrahmanov.salesreport.service.SalesReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class SalesReportController {

    private SalesReportService salesReportService;

    @GetMapping("/generate")
    public String generateReport() {
        salesReportService.generateWeeklySalesReport();
        return "Sales report generated successfully!";
    }
}
