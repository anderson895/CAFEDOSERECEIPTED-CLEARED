/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cafedose;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*; 
import java.util.Vector;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


class StockItem implements Serializable {
     private static final long serialVersionUID = 1L;
    
    private String name;
   
    private int stock;
     
    
    
    public StockItem(String name,int stock) {
        
        this.name = name;
        
       
        this.stock = stock;
    }
   
    public String getName() { return name; }
    public int getStock() { return stock; }
    
    public void setStock(int stock) { this.stock = stock; }
    
    @Override
    public String toString() {
        return String.format("%s - %s (%s)", name);
    }

}
public class Sales extends javax.swing.JFrame implements ActionListener {
private int editingRowIndex = -1;
     double total;
     double subTotal;
double sizePrice = 0;

 private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Sales.class.getName());
private static final String STOCK_FILE = "data/inventory.bin";
    /**
     * Creates new form Sales
     */
    public Sales(String username) {
        initComponents();
     loadTable();
     jTable2.setDefaultRenderer(Object.class, new Sales.StatusColorRenderer());
    // ✅ FIX 1: Use actual logged-in user
    datastore.currentCashier = username;  
    
    jScrollPane4.setVisible(false);
    cashie.setText(username);
    status.setVisible(false);
    cashie.setVisible(false);
    
    // ✅ Role-based permissions - PERFECT!
    if(username.equals("AD123")) {  // Admin
        jLabel1.setText("Welcome, DAVI - Admin");
      
        
           // Admin sees all buttons
        
    } else {  // Cashier (CS456, CS789)
        jLabel1.setText("Welcome, " + username + " - Cashier");
            // Hide admin buttons
    jButton7.setVisible(false);
}
          
    }
        public double getSizePrice(String productName, String size) {
        double basePrice = 0;

        switch(productName) {
            case "Coffee":
                if(size.equals("Small")) basePrice = 35.0;
                else if(size.equals("Medium")) basePrice = 65.0;
                else if(size.equals("Large")) basePrice = 90.0;
                break;

            case "Dark Choco":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
              case "White Choco":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
                case "Vanilla":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
                case "Caramel M.":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
                case "Taro":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
                case "Matcha":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
                case "Hazel":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
                case "Mocha":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
                 case "Tea":
                if(size.equals("Small")) basePrice = 35.0;
                else if(size.equals("Medium")) basePrice = 65.0;
                else if(size.equals("Large")) basePrice = 90.0;
                break;
                
                case "Sakura":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
                
                case "Pistacio":
                if(size.equals("Tall")) basePrice = 50.0;
                else if(size.equals("Grande")) basePrice = 90.0;
                else if(size.equals("Venti")) basePrice = 130.0;
                break;
        }

        return basePrice;
    }
        
         public double getServingPrice(String productName, String serving) {
        double basePrice = 0;
        switch(productName) {
            case "Bread":
                if(serving.equals("Mini")) basePrice = 35.0;
                else if(serving.equals("Classic")) basePrice = 55.0;
                else if(serving.equals("Deluxe")) basePrice = 75.0;
                break;
                
                case "Pancake":
                if(serving.equals("Mini")) basePrice = 59.0;
                else if(serving.equals("Classic")) basePrice = 89.0;
                else if(serving.equals("Deluxe")) basePrice = 119.0;
                break;
                
                case "Cookie":
                if(serving.equals("Mini")) basePrice = 25.0;
                else if(serving.equals("Classic")) basePrice = 45.0;
                else if(serving.equals("Deluxe")) basePrice = 65.0;
                break;
         }

        return basePrice;
    }
         
    public void reset() {
        clear();
        jSpinner1.setValue(0);
        jSpinner2.setValue(0);
        jSpinner3.setValue(0);
        jSpinner4.setValue(0);
        jSpinner5.setValue(0);
        jSpinner6.setValue(0);
        jSpinner7.setValue(0);
        jSpinner8.setValue(0);
        jSpinner9.setValue(0);
        jTextFieldTax.setText("");
        jTextFieldSubTotal.setText("");
        jTextFieldTotal.setText("");
        jTextFieldTotal1.setText("");
         jTextArea1.setText(" ");
        total = 0;
        subTotal = 0;
        ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
        }
    
        
    
    public void clear() {
    jTextChange.setText(" ");
    jTextCash.setText(" ");
   
    }
 

    private void cash() {
    try {
        double total = Double.parseDouble(
    jTextFieldTotal1.getText().replace("P", "").trim()
);
        double cash = Double.parseDouble(jTextCash.getText());

        double change = cash - total;

        if (change < 0) {
            jTextChange.setText("Not enough cash!");
        } else {
            String ChangeGiven = String.format("P %.2f", change);
            jTextChange.setText(ChangeGiven);
        }

    } catch (Exception e) {
        jTextChange.setText("Invalid input!");
    }
}
    private void calculateTotal() {
        double taxRate = 0.1; // 12% tax
        double tax = subTotal * taxRate;
        total = subTotal + tax;
        
        jTextFieldSubTotal.setText(String.format("P %.2f", subTotal));
        jTextFieldTax.setText(String.format("P %.2f", tax));
        jTextFieldTotal.setText(String.format("P %.2f", total));
        jTextFieldTotal1.setText(String.format("P %.2f", total));
    }
    private void addToTable(String productName, int quantity, String size, double price) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        double amount = price * quantity;
        subTotal += amount;
        model.addRow(new Object[]{productName, quantity, size, String.format("P %.2f", amount)});
        calculateTotal();
      
    }
    private double getSize(String productName, String size) {
        switch (productName) {
            case "Coffee":
                return size.equals("Small") ? 35 : size.equals("Medium") ? 65 : 90;
            case "Dark Choco":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;
            case "White Choco":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;
            case "Vanilla":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;
            case "Caramel M.":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;
            case "Taro":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;
            case "Matcha":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;
            case "Hazel":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;
            case "Mocha":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130; 
            case "Tea":
                return size.equals("Small") ? 35 : size.equals("Medium") ? 65 : 90;
            case "Sakura":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;
            case "Pistacio":
                return size.equals("Tall") ? 50 : size.equals("Grande") ? 90 : 130;    
            default:  
                return 0;
        }
    }
    
    private double getServing(String productName, String serving) {
        switch (productName) {
            case "Bread":
                return serving.equals("Mini") ? 35 : serving.equals("Classic") ? 55 : 75;
            case "Pancake":
                return serving.equals("Mini") ? 59 : serving.equals("Classic") ? 89 : 119;
            case "Cookie":
                return serving.equals("Mini") ? 35 : serving.equals("Classic") ? 55 : 75;
            default:
            return 0;
        }
        }
    
    public void qtyIsZero(javax.swing.JSpinner spinner) {
        if (Integer.parseInt(spinner.getValue().toString()) == 0) {    
            JOptionPane.showMessageDialog(null, "Please increase the item quantity");
            return;
        }
        
    }    
   
   public class StatusColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        String status = table.getModel().getValueAt(row, 3).toString();

        if (!isSelected) {
            switch (status) {
                case "SUCCESS":
                    c.setBackground(new Color(153,204,255)); // light blue
                    break;
                case "FAILED":
                    c.setBackground(new Color(102,153,255)); // blue
                    break;
                    case "CHANGED":
                    c.setBackground(new Color(51,204,255)); // sky blue
                      break;
                default:
                    c.setBackground(Color.WHITE);
            }
        }

        return c;
    }
}
    public void loadTable() {
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0);

    for (String[] row : datalog.logs) {
        model.addRow(row);
    }
}
   public String TIMEOUT() {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a");
    return sdf.format(new java.util.Date());
}
    public String getTimeNow() {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
    return sdf.format(new java.util.Date());
    }
    public void itemcost()          
    {
        double sub=0;
        for(int i=0;i<jTable1.getRowCount();i++)
        {
            sub= sub + Double.parseDouble(jTable1.getValueAt(i,3).toString());
        }
        
        String fsub=String.format("%.2f", sub);
      jTextFieldSubTotal.setText(fsub);
        double vat=sub/1.12;
        double fvat=sub-vat;
        
        String ffvat=String.format("%.2f", fvat);
        jTextFieldTax.setText(ffvat);
        double Total;
        Total=sub;
        String fTotal=String.format("%.2f", Total);
        jTextFieldTotal.setText(fTotal);       
        jTextFieldTotal1.setText(fTotal);
        
    }
  public void showSalesReport() {
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    model.setRowCount(0);
    
    if (datareport.sales != null && datareport.sales.length > 0) {
        for (String[] sale : datareport.sales) {
            model.addRow(new Object[]{
                sale.length > 0 ? sale[0] : "",                                // Item
                sale.length > 1 ? sale[1] : "",                                // Size
                sale.length > 2 ? sale[2] : "",                                // Qty  
                sale.length > 3 ? sale[3] : "",                                // Total
                sale.length > 4 ? sale[4] : getTimeNow(),                      // Time
                datareport.currentCashier != null ? datareport.currentCashier : "Unknown"  // ✅ CASHIER
            });
        }
    } else {
        model.addRow(new Object[]{"No sales yet", "", "", "", getTimeNow(), "—"});
    }
}

public void saveSaleToDatastore() {
    if (jTable1.getRowCount() > 0) {
        int currentCount = datareport.salesCount;
        int newSales = jTable1.getRowCount();
        String[][] allSales = new String[currentCount + newSales][6];
        
        // Copy existing
        for (int i = 0; i < currentCount; i++) {
            allSales[i] = datareport.sales[i];
        }
        
        // ✅ Add NEW sale WITH CASHIER (index 5!)
        for (int i = 0; i < newSales; i++) {
            allSales[currentCount + i] = new String[]{
                jTable1.getValueAt(i, 0).toString(),           // Item (0)
                jTable1.getValueAt(i, 2).toString(),           // Size (1)
                jTable1.getValueAt(i, 1).toString(),           // Qty (2)
                jTable1.getValueAt(i, 3).toString(),           // Total (3)
                getTimeNow(),                                  // Time (4)
                datareport.currentCashier                      // ✅ CASHIER (5) ← MISSING!
            };
        }
        
        datareport.sales = allSales;
        datareport.salesCount = currentCount + newSales;
        showSalesReport();
        JOptionPane.showMessageDialog(this, "✅ Sale + Cashier saved!");
    }
}
private List<StockItem> loadStocks() {
    List<StockItem> stocks = new ArrayList<>();
    
    // Check if file exists
    if (!Files.exists(Paths.get(STOCK_FILE))) {
        logger.log(java.util.logging.Level.INFO, "No inventory.bin found - creating new");
        return stocks;
    }
    
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STOCK_FILE))) {
        Object obj = ois.readObject();
        if (obj instanceof List<?>) {
            stocks = (List<StockItem>) obj;
            logger.log(java.util.logging.Level.INFO, "Loaded {0} stocks from {1}", 
                      new Object[]{stocks.size(), STOCK_FILE});
        } } catch (Exception e) {
        logger.log(java.util.logging.Level.SEVERE, "❌ FAILED to load stocks: " + e.getMessage(), e);
        // Create backup
        try {
            Files.copy(Paths.get(STOCK_FILE), Paths.get("inventory_backup.bin"));
        } catch (IOException ex) {}
        JOptionPane.showMessageDialog(this, 
            "⚠️ Inventory load failed!\nCheck logs. Using empty inventory.", 
            "Load Error", JOptionPane.WARNING_MESSAGE);
    }
    return stocks; 
}
private void loadStockTable() {
     DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
    model.setRowCount(0);
    
    List<StockItem> stocks = loadStocks();
    for (StockItem item : stocks) {
        model.addRow(new Object[]{
             item.getName(),item.getStock()
        });
    }

}
private boolean validateStockInputWithSize() {
    String[] fields = {jTextField13.getText().trim(),
                      jTextField14.getText().trim()};
    String[] labels = {"Name","Stock"};
    
    for (int i = 0; i < fields.length; i++) {
        if (fields[i].isEmpty()) {
            JOptionPane.showMessageDialog(this, "❌ " + labels[i] + " required!");
            return false;
        }
    }
    return true;
}
private void saveStocks(List<StockItem> stocks) {
   try {
       
        new File("data").mkdirs();
        
       
        File file = new File("data/inventory.bin");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        
        oos.writeObject(new ArrayList<>(stocks));
        oos.flush();
        oos.close();
        fos.close();
        
        System.out.println("SAVED: " + stocks.size() + " items");
        System.out.println("File: data/inventory.bin (" + file.length() + " bytes)");
        
    } catch (Exception e) {
        System.err.println("SAVE ERROR: " + e.getMessage());
        e.printStackTrace();
    }

}
private void clearStockFields() {
     jTextField13.setText("");
    editingRowIndex = -1;
   }

// === Inventory deduction (3 stocks, grams) ===
private List<StockItem> ensureSeededStocks() {
    List<StockItem> stocks = loadStocks();
    if (stocks == null || stocks.isEmpty()) {
        stocks = new ArrayList<>();
        stocks.add(new StockItem("Coffee Beans", 5000));
        stocks.add(new StockItem("Milk", 5000));
        stocks.add(new StockItem("Sugar", 3000));
        saveStocks(stocks);
    }
    return stocks;
}

private int sizeFactor(String size, int small, int medium, int large) {
    if (size == null) return small;
    switch (size) {
        case "Small": case "Tall": case "Mini":    return small;
        case "Medium": case "Grande": case "Classic": return medium;
        case "Large": case "Venti": case "Deluxe":  return large;
        default: return small;
    }
}

// returns grams to deduct for [Coffee Beans, Milk, Sugar] per ONE serving
private int[] recipeFor(String item, String size) {
    int coffee = 0, milk = 0, sugar = 0;
    if (item == null) return new int[]{0,0,0};
    switch (item) {
        case "Coffee": case "Mocha":
            coffee = sizeFactor(size, 8, 12, 18);
            milk   = sizeFactor(size, 50, 100, 150);
            sugar  = sizeFactor(size, 5, 8, 10);
            break;
        case "Tea": case "Matcha": case "Sakura":
            milk  = sizeFactor(size, 40, 80, 120);
            sugar = sizeFactor(size, 5, 8, 10);
            break;
        case "Dark Choco": case "White Choco": case "Vanilla":
        case "Caramel M.": case "Taro": case "Hazel": case "Pistacio":
            milk  = sizeFactor(size, 60, 110, 160);
            sugar = sizeFactor(size, 6, 10, 14);
            break;
        case "Bread": case "Pancake": case "Cookie":
            milk  = sizeFactor(size, 20, 30, 40);
            sugar = sizeFactor(size, 10, 15, 20);
            break;
        default: break;
    }
    return new int[]{coffee, milk, sugar};
}

private void deductIngredient(List<StockItem> stocks, String name, int grams) {
    if (grams <= 0) return;
    for (StockItem s : stocks) {
        if (s.getName().equalsIgnoreCase(name)) {
            s.setStock(Math.max(0, s.getStock() - grams));
            return;
        }
    }
}

private void deductStocksFromCart() {
    if (jTable1.getRowCount() == 0) return;
    List<StockItem> stocks = ensureSeededStocks();

    StringBuilder report = new StringBuilder();
    for (int i = 0; i < jTable1.getRowCount(); i++) {
        String item = jTable1.getValueAt(i, 0).toString();
        int qty;
        try { qty = Integer.parseInt(jTable1.getValueAt(i, 1).toString()); }
        catch (Exception e) { qty = 1; }
        String size = jTable1.getValueAt(i, 2).toString();

        int[] g = recipeFor(item, size);
        deductIngredient(stocks, "Coffee Beans", g[0] * qty);
        deductIngredient(stocks, "Milk",         g[1] * qty);
        deductIngredient(stocks, "Sugar",        g[2] * qty);

        report.append(String.format("%s (%s) x%d -> -%dg beans, -%dg milk, -%dg sugar%n",
                item, size, qty, g[0]*qty, g[1]*qty, g[2]*qty));
    }

    saveStocks(stocks);
    try { loadStockTable(); } catch (Exception ignored) {}
    System.out.println("[INVENTORY DEDUCTED]\n" + report);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KIOSK = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jTextChange = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTextFieldTotal1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextCash = new javax.swing.JTextField();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldSubTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldTax = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jButton47 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jComboBox18 = new javax.swing.JComboBox<>();
        jSpinner10 = new javax.swing.JSpinner();
        jButton14 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner();
        jButton45 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jSpinner2 = new javax.swing.JSpinner();
        jButton13 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jButton44 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jSpinner4 = new javax.swing.JSpinner();
        jButton41 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton5 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        jButton43 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jButton21 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jSpinner17 = new javax.swing.JSpinner();
        jButton23 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jButton42 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jSpinner12 = new javax.swing.JSpinner();
        jButton51 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jSpinner11 = new javax.swing.JSpinner();
        jButton50 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jButton46 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jSpinner14 = new javax.swing.JSpinner();
        jButton53 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jSpinner15 = new javax.swing.JSpinner();
        jButton54 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jComboBox19 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jSpinner16 = new javax.swing.JSpinner();
        jButton55 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cashie = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        ADMIN = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        time = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        report = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        inventory = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField18 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        KIOSK.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(163, 195, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 0, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 102), new java.awt.Color(153, 204, 255), new java.awt.Color(0, 204, 255), java.awt.Color.black));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Qty", "Size", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 650));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 310, 670));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 310, 670));

        jPanel13.setBackground(new java.awt.Color(0, 0, 102));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 102), new java.awt.Color(153, 204, 255), new java.awt.Color(0, 204, 255), java.awt.Color.black));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextChange.setEditable(false);
        jTextChange.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextChangeActionPerformed(evt);
            }
        });
        jPanel13.add(jTextChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 120, 30));

        jLabel60.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(153, 204, 255));
        jLabel60.setText("TOTAL  :");
        jPanel13.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, -1));

        jLabel61.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(153, 204, 255));
        jLabel61.setText("CHANGE  :");
        jPanel13.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 30));

        jTextFieldTotal1.setEditable(false);
        jTextFieldTotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotal1ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextFieldTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 120, 30));

        jLabel62.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(153, 204, 255));
        jLabel62.setText("CASH  :");
        jPanel13.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 30));

        jTextCash.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCashActionPerformed(evt);
            }
        });
        jPanel13.add(jTextCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 120, 30));

        jButton48.setBackground(new java.awt.Color(204, 255, 255));
        jButton48.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton48.setText("CLEAR");
        jButton48.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, 30));

        jButton49.setBackground(new java.awt.Color(153, 204, 255));
        jButton49.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton49.setText("PAY");
        jButton49.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 204, 255));
        jLabel13.setText("Sub Total");
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 120, 30));

        jTextFieldSubTotal.setEditable(false);
        jPanel13.add(jTextFieldSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 120, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 204, 255));
        jLabel15.setText("Tax");
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 120, 30));

        jTextFieldTax.setEditable(false);
        jPanel13.add(jTextFieldTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 204, 255));
        jLabel10.setText("Total");
        jPanel13.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 120, 30));

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });
        jPanel13.add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 120, 30));

        jButton47.setBackground(new java.awt.Color(204, 255, 255));
        jButton47.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton47.setText("RESET");
        jButton47.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 210, 30));

        jButton30.setBackground(new java.awt.Color(153, 204, 255));
        jButton30.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton30.setText("PRINT");
        jButton30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 210, 30));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 550, 280));

        jPanel14.setBackground(new java.awt.Color(51, 153, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(126, 164, 208));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 102));
        jLabel24.setText("TEA");
        jPanel12.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 50, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Teafinal.gif"))); // NOI18N
        jPanel12.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 90));

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel26.setText("SIZE :");
        jPanel12.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        jComboBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox18ActionPerformed(evt);
            }
        });
        jPanel12.add(jComboBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 30));

        jSpinner10.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel12.add(jSpinner10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton14.setBackground(new java.awt.Color(153, 204, 255));
        jButton14.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton14.setText("ORDER");
        jButton14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 30));

        jPanel14.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 160, 330));

        jPanel2.setBackground(new java.awt.Color(126, 164, 208));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mochy.gif"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 100));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel23.setText("SIZE :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 30));

        jLabel45.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 102));
        jLabel45.setText("MOCHA");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel2.add(jSpinner8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton45.setBackground(new java.awt.Color(153, 204, 255));
        jButton45.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton45.setText("ORDER");
        jButton45.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 160, 330));

        jPanel3.setBackground(new java.awt.Color(159, 182, 214));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("COFFEE");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cofy.gif"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 90));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel19.setText("SIZE :");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        jComboBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox17ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 30));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel3.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton13.setBackground(new java.awt.Color(153, 204, 255));
        jButton13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton13.setText("ORDER");
        jButton13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 30));

        jPanel14.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 330));

        jPanel11.setBackground(new java.awt.Color(126, 164, 208));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hazelfinal.gif"))); // NOI18N
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 100));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel22.setText("SIZE :");
        jPanel11.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        jPanel11.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel44.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 102));
        jLabel44.setText("HAZEL");
        jPanel11.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel11.add(jSpinner7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton44.setBackground(new java.awt.Color(153, 204, 255));
        jButton44.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton44.setText("ORDER");
        jButton44.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 160, 330));

        jPanel6.setBackground(new java.awt.Color(126, 164, 208));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 102));
        jLabel40.setText("VANILLA");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vanillafinal.gif"))); // NOI18N
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 100));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel17.setText("SIZE :");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel6.add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton41.setBackground(new java.awt.Color(153, 204, 255));
        jButton41.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton41.setText("ORDER");
        jButton41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 160, 330));

        jPanel4.setBackground(new java.awt.Color(126, 164, 208));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DarkChocolatefinal.gif"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 100));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel12.setText("SIZE :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel38.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jLabel38.setText("DARK CHOCO");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel4.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton5.setBackground(new java.awt.Color(153, 204, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton5.setText("ORDER");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 160, 330));

        jPanel9.setBackground(new java.awt.Color(126, 164, 208));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Matchafinal.gif"))); // NOI18N
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 100));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel21.setText("SIZE :");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel43.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 102));
        jLabel43.setText("MATCHA");
        jPanel9.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel9.add(jSpinner6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton43.setBackground(new java.awt.Color(153, 204, 255));
        jButton43.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton43.setText("ORDER");
        jButton43.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 160, 330));

        jPanel5.setBackground(new java.awt.Color(126, 164, 208));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/WhiteChocolatefinal.gif"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 90));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel14.setText("SIZE :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel39.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 102));
        jLabel39.setText("WHITE CHOCO");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel5.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton21.setBackground(new java.awt.Color(153, 204, 255));
        jButton21.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton21.setText("ORDER");
        jButton21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel22.setBackground(new java.awt.Color(147, 192, 234));
        jPanel22.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chocB.png"))); // NOI18N
        jPanel22.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 90));

        jLabel53.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel53.setText("SIZE :");
        jPanel22.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox14ActionPerformed(evt);
            }
        });
        jPanel22.add(jComboBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel54.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 102));
        jLabel54.setText("WHITE CHOCO");
        jPanel22.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSpinner17.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel22.add(jSpinner17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton23.setBackground(new java.awt.Color(153, 204, 255));
        jButton23.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton23.setText("ORDER");
        jButton23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel5.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 160, 330));

        jPanel14.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 720, 160, 330));

        jPanel8.setBackground(new java.awt.Color(126, 164, 208));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tarofinal.gif"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel20.setText("SIZE :");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel42.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 102));
        jLabel42.setText("TARO");
        jPanel8.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel8.add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton42.setBackground(new java.awt.Color(153, 204, 255));
        jButton42.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton42.setText("ORDER");
        jButton42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 720, 160, 330));

        jPanel23.setBackground(new java.awt.Color(119, 156, 205));
        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel29.setText("SIZE :");
        jPanel23.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sakurafinal.gif"))); // NOI18N
        jPanel23.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12ActionPerformed(evt);
            }
        });
        jPanel23.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel47.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 102));
        jLabel47.setText("SAKURA");
        jPanel23.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jSpinner12.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel23.add(jSpinner12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton51.setBackground(new java.awt.Color(153, 204, 255));
        jButton51.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton51.setText("ORDER");
        jButton51.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 1070, 160, 330));

        jPanel21.setBackground(new java.awt.Color(119, 156, 205));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel27.setText("SIZE :");
        jPanel21.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pistachiofinal.gif"))); // NOI18N
        jPanel21.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });
        jPanel21.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel46.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 102));
        jLabel46.setText("PISTACIO");
        jPanel21.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jSpinner11.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel21.add(jSpinner11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton50.setBackground(new java.awt.Color(153, 204, 255));
        jButton50.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton50.setText("ORDER");
        jButton50.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 1070, 160, 330));

        jPanel7.setBackground(new java.awt.Color(119, 156, 205));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel18.setText("SIZE :");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caramy.gif"))); // NOI18N
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        jLabel41.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 102));
        jLabel41.setText(" CARAMEL M.");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSpinner9.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel7.add(jSpinner9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton46.setBackground(new java.awt.Color(153, 204, 255));
        jButton46.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton46.setText("ORDER");
        jButton46.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel14.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1070, 160, 330));

        jScrollPane3.setViewportView(jPanel14);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 550, 370));

        jPanel18.setBackground(new java.awt.Color(51, 204, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(103, 154, 216));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pancake.gif"))); // NOI18N
        jPanel15.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 100));

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel33.setText("SERVING:");
        jPanel15.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mini", "Classic", "Deluxe" }));
        jComboBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox15ActionPerformed(evt);
            }
        });
        jPanel15.add(jComboBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 30));

        jLabel49.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 102));
        jLabel49.setText("PANCAKE");
        jPanel15.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jSpinner14.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel15.add(jSpinner14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton53.setBackground(new java.awt.Color(153, 204, 255));
        jButton53.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton53.setText("ORDER");
        jButton53.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel18.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 160, 330));

        jPanel16.setBackground(new java.awt.Color(103, 154, 216));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Bread.gif"))); // NOI18N
        jPanel16.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 100));

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel35.setText("SERVING:");
        jPanel16.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mini", "Classic", "Deluxe" }));
        jComboBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox16ActionPerformed(evt);
            }
        });
        jPanel16.add(jComboBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 30));

        jLabel50.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 102));
        jLabel50.setText("BREAD");
        jPanel16.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jSpinner15.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel16.add(jSpinner15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton54.setBackground(new java.awt.Color(153, 204, 255));
        jButton54.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton54.setText("ORDER");
        jButton54.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel18.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 330));

        jPanel17.setBackground(new java.awt.Color(103, 154, 216));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cookie.gif"))); // NOI18N
        jPanel17.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 100));

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel37.setText("SERVING:");
        jPanel17.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mini", "Classic", "Deluxe" }));
        jComboBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox19ActionPerformed(evt);
            }
        });
        jPanel17.add(jComboBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 30));

        jLabel51.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 102));
        jLabel51.setText("COOKIE");
        jPanel17.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jSpinner16.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel17.add(jSpinner16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, -1));

        jButton55.setBackground(new java.awt.Color(153, 204, 255));
        jButton55.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton55.setText("ORDER");
        jButton55.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 30));

        jPanel18.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 160, 330));

        jScrollPane4.setViewportView(jPanel18);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 550, 370));

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setText("BEVERAGE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 50));

        jButton3.setBackground(new java.awt.Color(102, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton3.setText("MORE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 50));

        jButton6.setBackground(new java.awt.Color(0, 0, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 204, 255));
        jButton6.setText("LOG OUT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 140, 50));

        cashie.setText("jLabel24");
        jPanel1.add(cashie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, -1, 20));

        status.setText("jLabel24");
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        jButton7.setBackground(new java.awt.Color(204, 255, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton7.setText("ADMIN");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 100, 50));

        KIOSK.add(jPanel1, "card2");

        getContentPane().add(KIOSK, "card2");

        ADMIN.setBackground(new java.awt.Color(163, 195, 233));
        ADMIN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 7, true));
        ADMIN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logohex.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ADMIN.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, 110));

        jPanel20.setBackground(new java.awt.Color(163, 195, 233));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 7, true));
        jPanel20.setLayout(new java.awt.CardLayout());

        time.setBackground(new java.awt.Color(0, 0, 102));
        time.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "TIME IN", "TIME OUT", "STATUS"
            }
        ));
        jScrollPane6.setViewportView(jTable2);

        time.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1010, 640));

        jPanel20.add(time, "card2");

        report.setBackground(new java.awt.Color(102, 153, 255));
        report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ITEM", "SIZE", "QTY", "TOTAL", "TIME", "ID"
            }
        ));
        jScrollPane7.setViewportView(jTable3);

        report.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1030, 640));

        jPanel20.add(report, "card3");

        inventory.setBackground(new java.awt.Color(51, 153, 255));
        inventory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Stocks"
            }
        ));
        jScrollPane8.setViewportView(jTable4);

        inventory.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 580, 650));

        jTextField18.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField18FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField18FocusLost(evt);
            }
        });
        inventory.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 110, 20));

        jLabel48.setText("TEA img");
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        inventory.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, 60));

        jTextField16.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField16FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField16FocusLost(evt);
            }
        });
        inventory.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 110, 20));

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(153, 204, 255));
        jTextField13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField13.setText("COFFEE BEAN");
        jTextField13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField13FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField13FocusLost(evt);
            }
        });
        inventory.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 110, 30));

        jTextField14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField14FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField14FocusLost(evt);
            }
        });
        inventory.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 110, 20));

        jTextField15.setEditable(false);
        jTextField15.setBackground(new java.awt.Color(153, 204, 255));
        jTextField15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("MILK");
        jTextField15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField15FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField15FocusLost(evt);
            }
        });
        inventory.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 110, 30));

        jLabel32.setText("MILK img");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        inventory.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 90, 60));

        jLabel31.setText("coffee bean img");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        inventory.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, 60));

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(153, 204, 255));
        jTextField17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("TEA BAG");
        jTextField17.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField17FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField17FocusLost(evt);
            }
        });
        inventory.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, 30));

        jButton4.setBackground(new java.awt.Color(51, 204, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("REMOVE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        inventory.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 260, 30));

        jPanel20.add(inventory, "card4");

        ADMIN.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1090, 690));

        jButton10.setBackground(new java.awt.Color(51, 153, 255));
        jButton10.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton10.setText("INVENTORY");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        ADMIN.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 200, 50));

        jButton8.setBackground(new java.awt.Color(0, 0, 102));
        jButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(153, 204, 255));
        jButton8.setText("TIME IN & OUT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        ADMIN.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 200, 50));

        jButton9.setBackground(new java.awt.Color(102, 153, 255));
        jButton9.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton9.setText("SALES REPORT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        ADMIN.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 50));

        getContentPane().add(ADMIN, "card3");

        jPanel19.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanel19, "card4");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   KIOSK.setVisible(true);
   ADMIN.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        saveSaleToDatastore();
        if(total > 0) {
    if(jTextChange.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Not paid!");
        return;
    }

    double cash = Double.parseDouble(jTextCash.getText());
    if(cash < total) {
        JOptionPane.showMessageDialog(null, "Not enough cash!");
        return;
    }
 // Generate receipt
 try {  // Print the receipt
        boolean complete = jTextArea1.print();
        if (complete) {
            JOptionPane.showMessageDialog(null, "Printing Complete", "Printer", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Print Error: " + e.getMessage());
        e.printStackTrace();
    }

    // Deduct ingredients (grams) from inventory.bin
    deductStocksFromCart();

    // Reset cart
    reset();
    // Loop through cart items


  
} else {
    JOptionPane.showMessageDialog(null, "No items in cart!");
}
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jTextChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextChangeActionPerformed

    private void jComboBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox17ActionPerformed
        // TODO add your handling code here:
      

    }//GEN-LAST:event_jComboBox17ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        jPanel10.setVisible(true);
         qtyIsZero(jSpinner2);

int quantity = Integer.parseInt(jSpinner2.getValue().toString());
if(quantity > 0) {
    String size = jComboBox17.getSelectedItem().toString();
    double price = getSize("Coffee", size);
    double totalAmount = price * quantity;

    // add sa table sa GUI
    addToTable("Coffee", quantity, size, price);

    // create one log object for this transaction
  
}
    
    }//GEN-LAST:event_jButton13ActionPerformed
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         jPanel10.setVisible(true);
        qtyIsZero(jSpinner1);
         
        if (Integer.parseInt(jSpinner1.getValue().toString()) > 0) {
            String size = jComboBox1.getSelectedItem().toString();
            double price = getSize("Dark Choco", size);
            addToTable("Dark Choco", 
                      Integer.parseInt(jSpinner1.getValue().toString()), 
                      size, price);
    }                         
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        qtyIsZero(jSpinner3);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner3.getValue().toString()) > 0) {
            String size = jComboBox2.getSelectedItem().toString();
            double price = getSize("White Choco", size);
            addToTable("White Choco", 
                      Integer.parseInt(jSpinner3.getValue().toString()), 
                      size, price);
    }//GEN-LAST:event_jButton21ActionPerformed
    }
    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        qtyIsZero(jSpinner4);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner4.getValue().toString()) > 0) {
            String size = jComboBox5.getSelectedItem().toString();
            double price = getSize("Vanilla", size);
            addToTable("Vanilla", 
                      Integer.parseInt(jSpinner4.getValue().toString()), 
                      size, price);
    }//GEN-LAST:event_jButton41ActionPerformed
    }
    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
         qtyIsZero(jSpinner9);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner9.getValue().toString()) > 0) {
            String size = jComboBox6.getSelectedItem().toString();
            double price = getSize("Caramel M.", size);
            addToTable("Caramel M.", 
                      Integer.parseInt(jSpinner9.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
         qtyIsZero(jSpinner5);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner5.getValue().toString()) > 0) {
            String size = jComboBox7.getSelectedItem().toString();
            double price = getSize("Taro", size);
            addToTable("Taro", 
                      Integer.parseInt(jSpinner5.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
          qtyIsZero(jSpinner7);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner7.getValue().toString()) > 0) {
            String size = jComboBox9.getSelectedItem().toString();
            double price = getSize("Hazel", size);
            addToTable("Hazel", 
                      Integer.parseInt(jSpinner7.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
          qtyIsZero(jSpinner8);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner8.getValue().toString()) > 0) {
            String size = jComboBox10.getSelectedItem().toString();
            double price = getSize("Mocha", size);
            addToTable("Mocha", 
                      Integer.parseInt(jSpinner8.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        jPanel10.setVisible(true);
        reset();
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jTextFieldTotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotal1ActionPerformed

    private void jTextCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCashActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        jPanel10.setVisible(true);
        clear();
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
    
        cash();
         StringBuilder receipt = new StringBuilder();

        receipt.append("================= CAFE DOSE ================\n");
        receipt.append("St.Peter Street, San Dionisio, Paranaque City\n");
        receipt.append("0956-875-4533\n");
        receipt.append("cafedose@gmail.com\n");
        receipt.append("VAT REG TIN: 123-456-789-000\n");
        receipt.append("=============================================\n");
        receipt.append("Item        Qty     Size      Amount\n");
        receipt.append("=============================================\n");
        receipt.append("                                             \n");
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String item = jTable1.getValueAt(i, 0).toString();
            String qty = jTable1.getValueAt(i, 1).toString();
            String size = jTable1.getValueAt(i, 2).toString();
            String amount = jTable1.getValueAt(i, 3).toString();
            

            receipt.append(String.format("%-10s      %-5s      %-6s      %3s\n", 
                item,     qty,     size,     amount));
        }

        receipt.append("=============================================\n");
        receipt.append(String.format("Subtotal: %s\n", jTextFieldSubTotal.getText()));
        receipt.append(String.format("Tax:      %s\n", jTextFieldTax.getText()));
        receipt.append(String.format("Total:    %s\n", jTextFieldTotal.getText()));
        receipt.append("\n");
        receipt.append(String.format("Cash:     ₱ %s\n", jTextCash.getText()));
        receipt.append(String.format("Change:   %s\n", jTextChange.getText()));
        receipt.append("========== THANK YOU! COME AGAIN ==============\n");
        

        jTextArea1.setText(receipt.toString());
        
        
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jComboBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox14ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        qtyIsZero(jSpinner6);
 jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner6.getValue().toString()) > 0) {
            String size = jComboBox8.getSelectedItem().toString();
            double price = getSize("Matcha", size);
            addToTable("Matcha",
                Integer.parseInt(jSpinner6.getValue().toString()),
                size, price);
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
     
            jScrollPane4.setVisible(false);
        jScrollPane3.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         jScrollPane3.setVisible(false);
        jScrollPane4.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
          int choice = JOptionPane.showConfirmDialog(null,
                "Are sure you want to log out?",
                "Log Out",
                JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            
            // BABAGUHIN
           String username = datalog.currentUser;
    String timeOut = getTimeNow();

    // CODE KO SA SAME ROW
    for (int i = datalog.logs.size() - 1; i >= 0; i--) {
        String[] row = datalog.logs.get(i);

        if (row[0].equals(username)
                && row[1] != null && !row[1].isEmpty()
                && (row[2] == null || row[2].isEmpty())) {

            row[2] = timeOut; // PARA SAME ROW
            break;
        }
    }
         this.setVisible(false);
            new loadingB().setVisible(true);
        } else if (choice == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Log Out Cancelled");
        }
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        Vector<Vector> tableData=model.getDataVector();
        
        try
        {
            FileOutputStream file= new FileOutputStream("inventory.bin");
            ObjectOutputStream output= new ObjectOutputStream(file);
            
            output.writeObject(tableData);
            output.close();
            file.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        KIOSK.setVisible(false); 
        ADMIN.setVisible(true); 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         time.setVisible(true);
        report.setVisible(false);
         inventory.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        showSalesReport();
        report.setVisible(true);
        time.setVisible(false);
        inventory.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try
        {
            FileInputStream file= new FileInputStream("inventory.bin");
            ObjectInputStream input= new ObjectInputStream(file);
            
            Vector<Vector> tableData=(Vector<Vector>)input.readObject();
            
            DefaultTableModel model=(DefaultTableModel) jTable4.getModel();
            for(int i=0;i< tableData.size() ;i++)
            {
                Vector row=tableData.get(i);
                model.addRow(new Object[]{row.get(0),row.get(1)});
            }
            
            input.close();
            file.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }        
    }//GEN-LAST:event_formWindowOpened

    private void jTextField13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField13FocusGained

    private void jTextField13FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField13FocusLost

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
         report.setVisible(false);
        time.setVisible(false);
        inventory.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jComboBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox18ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
         qtyIsZero(jSpinner10);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner10.getValue().toString()) > 0) {
            String size = jComboBox18.getSelectedItem().toString();
            double price = getSize("Tea", size);
            addToTable("Tea", 
                      Integer.parseInt(jSpinner10.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
         qtyIsZero(jSpinner11);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner11.getValue().toString()) > 0) {
            String size = jComboBox11.getSelectedItem().toString();
            double price = getSize("Pistacio", size);
            addToTable("Pistacio", 
                      Integer.parseInt(jSpinner11.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jComboBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox12ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
        qtyIsZero(jSpinner12);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner12.getValue().toString()) > 0) {
            String size = jComboBox12.getSelectedItem().toString();
            double price = getSize("Sakura", size);
            addToTable("Sakura", 
                      Integer.parseInt(jSpinner12.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jComboBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox15ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
        qtyIsZero(jSpinner14);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner14.getValue().toString()) > 0) {
            String serving = jComboBox15.getSelectedItem().toString();
            double price = getServing("Pancake", serving);
            addToTable("Pancake", 
                      Integer.parseInt(jSpinner14.getValue().toString()), 
                      serving, price);
        }
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jComboBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox16ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
        qtyIsZero(jSpinner15);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner15.getValue().toString()) > 0) {
            String serving = jComboBox16.getSelectedItem().toString();
            double price = getServing("Bread", serving);
            addToTable("Bread", 
                      Integer.parseInt(jSpinner15.getValue().toString()), 
                      serving, price);
        }
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jComboBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox19ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here
        qtyIsZero(jSpinner16);
          jPanel10.setVisible(true);
        if (Integer.parseInt(jSpinner16.getValue().toString()) > 0) {
            String serving = jComboBox19.getSelectedItem().toString();
            double price = getServing("Cookie", serving);
            addToTable("Cookie", 
                      Integer.parseInt(jSpinner16.getValue().toString()), 
                      serving, price);
        }
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jTextField14FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14FocusGained

    private void jTextField14FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14FocusLost

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
          String item=jTextField13.getText();
        String stocks=jTextField14.getText();
        if(item.isEmpty()||stocks.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
			"Please enter all fields!",
			"Try Again",
			JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            DefaultTableModel model=(DefaultTableModel) jTable4.getModel();
            model.addRow(new Object[]{item,stocks});
        }
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jTextField15FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15FocusGained

    private void jTextField15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15FocusLost

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
             String item=jTextField15.getText();
        String stocks=jTextField16.getText();
        if(item.isEmpty()||stocks.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
			"Please enter all fields!",
			"Try Again",
			JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            DefaultTableModel model=(DefaultTableModel) jTable4.getModel();
            model.addRow(new Object[]{item,stocks});
        }
        
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jTextField16FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField16FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16FocusGained

    private void jTextField16FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField16FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16FocusLost

    private void jTextField17FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField17FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17FocusGained

    private void jTextField17FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField17FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17FocusLost

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
        String item=jTextField17.getText();
        String stocks=jTextField18.getText();
        if(item.isEmpty()||stocks.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
			"Please enter all fields!",
			"Try Again",
			JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            DefaultTableModel model=(DefaultTableModel) jTable4.getModel();
            model.addRow(new Object[]{item,stocks});
        }
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jTextField18FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField18FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18FocusGained

    private void jTextField18FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField18FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18FocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model=(DefaultTableModel)jTable4.getModel();
        int removerow = jTable4.getSelectedRow();
        if (removerow >=0)
        {
            model.removeRow(removerow);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales(datalog.currentUser).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADMIN;
    private javax.swing.JPanel KIOSK;
    private javax.swing.JLabel cashie;
    private javax.swing.JPanel inventory;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner16;
    private javax.swing.JSpinner jSpinner17;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextCash;
    private javax.swing.JTextField jTextChange;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextFieldSubTotal;
    private javax.swing.JTextField jTextFieldTax;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldTotal1;
    private javax.swing.JPanel report;
    private javax.swing.JLabel status;
    private javax.swing.JPanel time;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
