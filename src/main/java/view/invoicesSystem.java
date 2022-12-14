/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.controller;
import model.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Laptop Market
 */
public class invoicesSystem extends javax.swing.JFrame {

    controller con;
    int selectedRow;
    int SelectedRowS;

    /**
     * Creates new form invoicesSystem
     */
    public invoicesSystem() {
        con = new controller();
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        summaryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        billaNumber = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        billDate = new javax.swing.JLabel();
        billTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        AddNewRow = new javax.swing.JButton();
        DeleteBill = new javax.swing.JButton();
        deleteItem = new javax.swing.JButton();
        SaveNewInvoice = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        createNewTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbill_number = new javax.swing.JLabel();
        lcustomer_name = new javax.swing.JLabel();
        lbill_date = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        iBillNumber = new javax.swing.JTextField();
        iCustomerName = new javax.swing.JTextField();
        iBillDate = new javax.swing.JTextField();
        ltotal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getBillNumber(evt);
            }
        });

        summaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill Number", "Bill Date", "Customer Name", "Bill Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        summaryTable.setShowGrid(true);
        summaryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                summaryTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(summaryTable);

        jLabel1.setText("Bill Number");

        jLabel2.setText("Customer Name");

        jLabel3.setText("Bill date");

        jLabel4.setText("Bill Total");

        billaNumber.setText(".");

        customerName.setText(".");

        billDate.setText(".");

        billTotal.setText(".");

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "Item Name", "Item Price", "Count", "Total"
            }
        ));
        dataTable.setShowGrid(true);
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dataTable);

        AddNewRow.setBackground(new java.awt.Color(0, 204, 204));
        AddNewRow.setText("Add New Item");
        AddNewRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewRowActionPerformed(evt);
            }
        });

        DeleteBill.setBackground(new java.awt.Color(0, 204, 204));
        DeleteBill.setText("Delete Bill");
        DeleteBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedBill(evt);
            }
        });

        deleteItem.setBackground(new java.awt.Color(153, 153, 255));
        deleteItem.setText("Delete Item");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemBUTTON(evt);
            }
        });

        SaveNewInvoice.setBackground(new java.awt.Color(0, 204, 204));
        SaveNewInvoice.setText("Save New Invoice");
        SaveNewInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveNewInvoiceActionPerformed(evt);
            }
        });

        createNewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Item Name", "Item Price", "Count", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        createNewTable.setShowGrid(true);
        jScrollPane3.setViewportView(createNewTable);

        lbill_number.setText("Bill Number");

        lcustomer_name.setText("Customer Name");

        lbill_date.setText("Bill date");

        jLabel8.setText("Bill Total");

        ltotal.setText("0.0");

        jMenu1.setText("File");

        jMenuItem1.setText("Load File");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadFile(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFile1(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(DeleteBill, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lcustomer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbill_number)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbill_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(iBillNumber)
                                    .addComponent(iCustomerName)
                                    .addComponent(iBillDate, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(ltotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(billaNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(billDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(billTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(customerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddNewRow)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(deleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveNewInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(billaNumber))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(customerName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(billDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(billTotal))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteItem))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteBill)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbill_number)
                            .addComponent(iBillNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lcustomer_name)
                            .addComponent(iCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbill_date)
                            .addComponent(iBillDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ltotal))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveNewInvoice)
                    .addComponent(AddNewRow))
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    void LoadFile(){
        String [] data=new String[4];
        DefaultTableModel model=(DefaultTableModel)summaryTable.getModel();
        List<invoiceSummary> Summary = con.loadSummary();
        for(int i=0;i<Summary.size();i++){
            data[0]= String.valueOf(Summary.get(i).getBillNumber());
            data[1]=Summary.get(i).getDate();
            data[2]=Summary.get(i).getCustomerName();
            data[3]= String.valueOf(Summary.get(i).getTotalBill());
            model.addRow(data);
        }
    }
    private void loadFile1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFile1
        // TODO add your handling code here:
        String [] data=new String[4];
        DefaultTableModel model=(DefaultTableModel)summaryTable.getModel();
        List<invoiceSummary> Summary = con.loadSummary();
        for(int i=0;i<Summary.size();i++){
            data[0]= String.valueOf(Summary.get(i).getBillNumber());
            data[1]=Summary.get(i).getDate();
            data[2]=Summary.get(i).getCustomerName();
            data[3]= String.valueOf(Summary.get(i).getTotalBill());
            model.addRow(data);
        }



    }//GEN-LAST:event_loadFile1

    private void deleteSelectedBill(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedBill
        // TODO add your handling code here:
        try {

            DefaultTableModel model = (DefaultTableModel) summaryTable.getModel();
                int row=SelectedRowS;
            System.out.println("selectedRow"+SelectedRowS);
            summaryTable.addNotify();
            invoiceSummary in = new invoiceSummary();
            in.setBillNumber(summaryTable.getValueAt(row, 0).toString());
            in.setCustomerName(summaryTable.getValueAt(row, 2).toString());
            in.setDate(summaryTable.getValueAt(row, 1).toString());
            in.setBill_Total(Double.parseDouble(summaryTable.getValueAt(SelectedRowS, 3).toString()));
            con.deleteSummaryItem(in);
            model.removeRow(row);
            LoadFile();
        }
        catch (Exception e){}
        LoadFile();
        

    }//GEN-LAST:event_deleteSelectedBill

    private void loadFile(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadFile
        // TODO add your handling code here:

    }//GEN-LAST:event_loadFile

    private void getBillNumber(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getBillNumber

        
    }//GEN-LAST:event_getBillNumber

    private void summaryTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summaryTableMousePressed
        // TODO add your handling code here:
        controller con=new controller();
        DefaultTableModel model=(DefaultTableModel)dataTable.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        String id=summaryTable.getValueAt(summaryTable.getSelectedRow(),0).toString();
        billaNumber.setText(id);
        customerName.setText(summaryTable.getValueAt(summaryTable.getSelectedRow(),2).toString());
        billDate.setText(summaryTable.getValueAt(summaryTable.getSelectedRow(),1).toString());
        billTotal.setText(summaryTable.getValueAt(summaryTable.getSelectedRow(),3).toString());
        //System.out.println("id= "+id);
        dataTable.repaint();
        List<invoiceData> selectedbBills=con.loadSeletcedBills(id);
        String [] data=new String[5];

        for(int i=0;i<selectedbBills.size();i++){
            data[0]= String.valueOf(i+1);
            data[1]=selectedbBills.get(i).getProductName();
            data[2]=selectedbBills.get(i).getPrice().toString();
            data[3]= String.valueOf(selectedbBills.get(i).getCount());
            data[4]= String.valueOf(selectedbBills.get(i).getCount()*selectedbBills.get(i).getPrice());

            model.addRow(data);

        }




    }//GEN-LAST:event_summaryTableMousePressed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)dataTable.getModel();
        selectedRow=dataTable.getSelectedRow();
        //System.out.println("MouseHndllar"+ selectedRow);
    }//GEN-LAST:event_dataTableMouseClicked

    private void SaveNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveNewInvoiceActionPerformed
        // TODO add your handling code here:
        double total=0.0;
        List<invoiceData>billData = new ArrayList<invoiceData>() ;
        invoiceSummary billSummary= new invoiceSummary();
        billSummary.setCustomerName(iCustomerName.getText());

        billSummary.setDate(iCustomerName.getText());
        billSummary.setBillNumber(iBillNumber.getText());
        billSummary.setBill_Total(total);
        DefaultTableModel model=(DefaultTableModel)createNewTable.getModel();
           for(int i=0;i<model.getRowCount();i++){
               System.out.println("rowCount="+model.getRowCount());
               invoiceData obj= new invoiceData();
            total+=Double.parseDouble(createNewTable.getValueAt(i,4).toString());
            obj.setBill(iBillNumber.getText());
            obj.setProductName(createNewTable.getValueAt(i,1).toString());
            obj.setPrice(Double.parseDouble(createNewTable.getValueAt(i,2).toString()));
            obj.setCount(Integer.parseInt(createNewTable.getValueAt(i,3).toString()));
            billData.add(obj);

    }
        billSummary.setBill_Total(total);
        ltotal.setText(String.valueOf(total));
        con.saveNewBill(billData,billSummary);
        iCustomerName.setText("");
        iBillNumber.setText("");
        iBillDate.setText("");
        billTotal.setText("");
        total=0.0;
        for (int i=0;i<model.getRowCount();i++){
            model.removeRow(i);
        }
        LoadFile();
        DefaultTableModel model2 = (DefaultTableModel) dataTable.getModel();

        for (int row = 0; row < dataTable.getRowCount(); row++) {
            model2.removeRow(row);
        }





    }//GEN-LAST:event_SaveNewInvoiceActionPerformed

    private void AddNewRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewRowActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)createNewTable.getModel();
        model.addRow(new Object[]{null,null,null,null,null});
//        DefaultTableModel model=(DefaultTableModel)dataTable.getModel();
//        model.setRowCount(0);
//        dataTable.addNotify();

    }//GEN-LAST:event_AddNewRowActionPerformed

    private void deleteItemBUTTON(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemBUTTON
        // TODO add your handling code here:
   int row=selectedRow;
   System.out.println(row);
        DefaultTableModel model=(DefaultTableModel)dataTable.getModel();
        model.removeRow(row);
        dataTable.addNotify();
        invoiceData in= new invoiceData();
        in.setPrice(Double.parseDouble(dataTable.getValueAt(row,2).toString()));
        in.setCount(Integer.parseInt(dataTable.getValueAt(row,3).toString()));
        in.setProductName(dataTable.getValueAt(row,1).toString());
        in.setBill(billaNumber.getText());
        con.deleteItemf(in);
        dataTable.repaint();

        }

//GEN-LAST:event_deleteItemBUTTON


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
            java.util.logging.Logger.getLogger(invoicesSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(invoicesSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(invoicesSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(invoicesSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new invoicesSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNewRow;
    private javax.swing.JButton DeleteBill;
    private javax.swing.JButton SaveNewInvoice;
    private javax.swing.JLabel billDate;
    private javax.swing.JLabel billTotal;
    private javax.swing.JLabel billaNumber;
    private javax.swing.JTable createNewTable;
    private javax.swing.JLabel customerName;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton deleteItem;
    private javax.swing.JTextField iBillDate;
    private javax.swing.JTextField iBillNumber;
    private javax.swing.JTextField iCustomerName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbill_date;
    private javax.swing.JLabel lbill_number;
    private javax.swing.JLabel lcustomer_name;
    private javax.swing.JLabel ltotal;
    private javax.swing.JTable summaryTable;
    // End of variables declaration//GEN-END:variables
}
