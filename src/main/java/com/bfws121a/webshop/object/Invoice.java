package com.bfws121a.webshop.object;

import java.util.List;

public class Invoice {

    // Invoice class representing an individual invoice
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
