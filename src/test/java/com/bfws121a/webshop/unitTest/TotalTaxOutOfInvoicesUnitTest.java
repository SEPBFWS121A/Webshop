package com.bfws121a.webshop.unitTest;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalTaxOutOfInvoicesUnitTest {

        @Test
        public void testCalculateTotalTax() {
            // Prepare test data
            Invoice invoice1 = new Invoice(100.0, 0.1); // Total amount: 100.0, Tax: 10.0
            Invoice invoice2 = new Invoice(200.0, 0.15); // Total amount: 200.0, Tax: 30.0
            Invoice invoice3 = new Invoice(300.0, 0.2); // Total amount: 300.0, Tax: 60.0

            List<Invoice> invoices = Arrays.asList(invoice1, invoice2, invoice3);

            // Calculate total tax
            double totalTax = calculateTotalTax(invoices);

            // Print the total tax
            System.out.println("Total Tax: " + totalTax);

            // Assert the expected result
            assertEquals(100.0, totalTax, 0.001);
        }

        // Method to calculate the total tax out of a list of invoices
        public double calculateTotalTax(List<Invoice> invoices) {
            double totalTax = 0.0;
            for (Invoice invoice : invoices) {
                double taxAmount = invoice.getTotalAmount() * invoice.getTaxRate();
                totalTax += taxAmount;
            }
            return totalTax;
        }

        // Invoice class representing an individual invoice
        private class Invoice {
            private double totalAmount;
            private double taxRate;

            public Invoice(double totalAmount, double taxRate) {
                this.totalAmount = totalAmount;
                this.taxRate = taxRate;
            }

            public double getTotalAmount() {
                return totalAmount;
            }

            public double getTaxRate() {
                return taxRate;
            }
        }
    }


