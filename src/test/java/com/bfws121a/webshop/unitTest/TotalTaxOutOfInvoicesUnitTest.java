package com.bfws121a.webshop.unitTest;

import java.util.Arrays;
import java.util.List;

import com.bfws121a.webshop.helper.CalcInvoice;
import com.bfws121a.webshop.helper.Calculator;
import com.bfws121a.webshop.object.Invoice;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalTaxOutOfInvoicesUnitTest {


        @Test
        public void testCalculateTotalTax() {
            CalcInvoice calcInvoice = new CalcInvoice();
            // Prepare test data
            Invoice invoice1 = new Invoice(100.0, 0.1); // Total amount: 100.0, Tax: 10.0
            Invoice invoice2 = new Invoice(200.0, 0.15); // Total amount: 200.0, Tax: 30.0
            Invoice invoice3 = new Invoice(300.0, 0.2); // Total amount: 300.0, Tax: 60.0

            List<Invoice> invoices = Arrays.asList(invoice1, invoice2, invoice3);

            // Calculate total tax
            double totalTax = calcInvoice.calculateTotalTax(invoices);

            // Print the total tax
            System.out.println("Total Tax: " + totalTax);

            // Assert the expected result
            assertEquals(100.0, totalTax, 0.001);
        }
    }


