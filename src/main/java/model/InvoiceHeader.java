/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Laptop Market
 */
public class InvoiceHeader {

    public InvoiceHeader() {
    }
    private String billNumber;
    private String date;
    private String customerName;
    private Double bill_Total;
    private List <InvoiceLines> bills;

    public InvoiceHeader(String billNumber, String date, String customerName) {
        this.billNumber = billNumber;
        this.date = date;
        this.customerName = customerName;
    }

   public Double getTotalBill(){
//   Double total=0.0;
//   for(invoiceData line:bills){
//   total+=line.getTotal();
//   }
//   return total;
   return bill_Total;
    }

    public void setBill_Total(Double bill_Total) {
        this.bill_Total = bill_Total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "invoiceSummary{" + "billNumber=" + billNumber + ", date=" + date + ", customerName=" + customerName + '}';
    }
    public String toString2(){
        return billNumber+","+date+","+customerName+","+bill_Total;
    }
    public String toString3(){
        return billNumber+","+date+","+customerName+",";
    }

    public List <InvoiceLines> getBills() {
        return bills;
    }
    
  
    
}
