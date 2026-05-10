/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cafedose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Sales extends javax.swing.JFrame implements ActionListener {

     double total;
     double subTotal;
double sizePrice = 0;


    /**
     * Creates new form Sales
     */
    public Sales() {
        initComponents();
        datastore.currentCashier = "Cashier1";
        
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
        total = 0;
        subTotal = 0;
        ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
        }
    
        
    
    public void clear() {
    jTextChange.setText(" ");
    jTextCash.setText(" ");
    }
    public String getTimeNow() {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a");
    return sdf.format(new java.util.Date());
    }
    public String TIMEOUT() {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a");
    return sdf.format(new java.util.Date());
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jButton21 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jSpinner4 = new javax.swing.JSpinner();
        jButton41 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jButton46 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jButton42 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        jButton43 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jButton44 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jTextFieldSubTotal = new javax.swing.JTextField();
        jTextFieldTax = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton47 = new javax.swing.JButton();
        jTextFieldTotal = new javax.swing.JTextField();
        jButton30 = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(163, 195, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(147, 192, 234));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mochaB.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 100, 100));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel23.setText("SIZE :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tall", "Grande", "Venti" }));
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 160, 330));

        jPanel3.setBackground(new java.awt.Color(163, 195, 233));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("COFFEE");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caffineB.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 90));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel19.setText("SIZE :");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        jComboBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox17ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 110, 30));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel3.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 70, -1));

        jButton13.setBackground(new java.awt.Color(153, 204, 255));
        jButton13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton13.setText("ORDER");
        jButton13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 110, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 230, 290));

        jPanel4.setBackground(new java.awt.Color(177, 202, 233));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/darkB.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 100, 100));

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 330));

        jPanel5.setBackground(new java.awt.Color(147, 192, 234));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chocB.png"))); // NOI18N
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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 160, 330));

        jPanel6.setBackground(new java.awt.Color(147, 192, 234));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 102));
        jLabel40.setText("VANILLA");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VB.png"))); // NOI18N
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 100));

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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 160, 330));

        jPanel7.setBackground(new java.awt.Color(147, 192, 234));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel18.setText("SIZE :");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CMB.png"))); // NOI18N
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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 160, 330));

        jPanel8.setBackground(new java.awt.Color(147, 192, 234));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/taroB.png"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 160, 330));

        jPanel9.setBackground(new java.awt.Color(147, 192, 234));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/matchaB.png"))); // NOI18N
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 100, 100));

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

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 160, 330));

        jPanel11.setBackground(new java.awt.Color(147, 192, 234));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hazelB.png"))); // NOI18N
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 100, 100));

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

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 160, 330));

        jPanel10.setBackground(new java.awt.Color(0, 0, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 102), new java.awt.Color(153, 204, 255), new java.awt.Color(0, 204, 255), java.awt.Color.black));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jTextFieldSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 120, 30));
        jPanel10.add(jTextFieldTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 204, 255));
        jLabel10.setText("Total");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 120, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 204, 255));
        jLabel13.setText("Sub Total");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 120, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 204, 255));
        jLabel15.setText("Tax");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 120, 30));

        jButton47.setBackground(new java.awt.Color(204, 255, 255));
        jButton47.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton47.setText("RESET");
        jButton47.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 110, 30));

        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });
        jPanel10.add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 120, 30));

        jButton30.setBackground(new java.awt.Color(153, 204, 255));
        jButton30.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton30.setText("PRINT");
        jButton30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 110, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Qty", "Size", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 440));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 310, 670));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 310, 670));

        jPanel13.setBackground(new java.awt.Color(0, 0, 102));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 102), new java.awt.Color(153, 204, 255), new java.awt.Color(0, 204, 255), java.awt.Color.black));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel13.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 30));

        jButton49.setBackground(new java.awt.Color(153, 204, 255));
        jButton49.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton49.setText("PAY");
        jButton49.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 110, 30));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 280, 210));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logohex.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 120, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            new login().setVisible(true);
        } else if (choice == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Log Out Cancelled");
        }


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

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboBox8ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
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
 try {
        StringBuilder receipt = new StringBuilder();

        receipt.append("================= CAFE DOSE ================\n");
        receipt.append("St.Peter Street, San Dionisio, Paranaque City\n");
        receipt.append("09#########\n");
        receipt.append("cafedose@gmail.com\n");
        receipt.append("VAT REG TIN: 123-456-789-000\n");
        receipt.append("=============================================\n");
        receipt.append("Item=======Qty====Size====Amount\n");
        receipt.append("=============================================\n");

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
        receipt.append("============ THANK YOU! COME AGAIN ==============\n");
        

        jTextArea1.setText(receipt.toString());
       

        // Print the receipt
        boolean complete = jTextArea1.print();
        if (complete) {
            JOptionPane.showMessageDialog(null, "Printing Complete", "Printer", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Print Error: " + e.getMessage());
        e.printStackTrace();
    }  
    

    // Reset cart
    reset();
    // Loop through cart items
    for(int i = 0; i < jTable1.getRowCount(); i++) {
        String itemName = jTable1.getValueAt(i, 0).toString();
        int qty = Integer.parseInt(jTable1.getValueAt(i, 1).toString());
        double amount = Double.parseDouble(jTable1.getValueAt(i, 2).toString()); // price * qty

        // Record in datastore
        log newSale = new log(datastore.currentCashier, itemName, qty, amount, TIMEOUT());
        datastore.log.add(newSale);
    }

  
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
         
        if (Integer.parseInt(jSpinner5.getValue().toString()) > 0) {
            String size = jComboBox7.getSelectedItem().toString();
            double price = getSize("Taro", size);
            addToTable("Taro", 
                      Integer.parseInt(jSpinner5.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
         qtyIsZero(jSpinner6);
         
        if (Integer.parseInt(jSpinner6.getValue().toString()) > 0) {
            String size = jComboBox8.getSelectedItem().toString();
            double price = getSize("Matcha", size);
            addToTable("Matcha", 
                      Integer.parseInt(jSpinner6.getValue().toString()), 
                      size, price);
    } 
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
          qtyIsZero(jSpinner7);
         
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
        clear();
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
        cash();
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed
    
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
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton30;
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox17;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextCash;
    private javax.swing.JTextField jTextChange;
    private javax.swing.JTextField jTextFieldSubTotal;
    private javax.swing.JTextField jTextFieldTax;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldTotal1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
