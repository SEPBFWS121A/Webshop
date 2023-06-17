package com.bfws121a.webshop.helper;

import com.bfws121a.webshop.object.Invoice;

import java.util.List;

public class CalcInvoice {

    public double calculateTotalTax(List<Invoice> invoices) {
        double totalTax = 0.0;
        for (Invoice invoice : invoices) {
            double taxAmount = invoice.getTotalAmount() * invoice.getTaxRate();
            totalTax += taxAmount;
        }
        return totalTax;
    }
}
