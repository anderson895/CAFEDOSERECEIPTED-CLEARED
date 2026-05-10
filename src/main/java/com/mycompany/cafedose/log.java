/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cafedose;

/**
 *
 * @author RICA
 */
public class log {
    String cashier;
    String item;
    int quantity;
    double amount;
    String timeIn;

    public log(String cashier, String item, int quantity, double amount, String timeIn) {
        this.cashier = cashier;
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.timeIn = timeIn;
    }
}