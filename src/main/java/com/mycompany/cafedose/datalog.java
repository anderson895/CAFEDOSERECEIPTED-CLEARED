/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cafedose;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author RICA
 */
public class datalog {
    public static ArrayList<String[]> logs = new ArrayList<>();
    public static String currentUser = "";
    public static int currentLogIndex = -1;
    
    public static HashMap<String, String> accounts = new HashMap<>();
    public static HashMap<String, Integer> attempts = new HashMap<>();

    // ✅ AUTO-INITIALIZE on first access
    static {
        initAccounts();
    }
    
    private static void initAccounts() {
        accounts.put("AD123", "DAVI");
        accounts.put("CS456", "JUNEY");
        accounts.put("CS789", "BRLLY");
        System.out.println("✅ Accounts auto-loaded: " + accounts.size());
    }
    
    public static void addLog(String user, String timeIn, String timeOut, String status) {
        logs.add(new String[]{user, timeIn, timeOut, status});
    }
}