/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Laptop Market
 */
public class InvoiceLines {
   private String bill;
    private String productName;
    private int count;
    private Double price;

    public InvoiceLines() {
    }

    public InvoiceLines(String bill, String productName, int count, Double price) {
        this.bill = bill;
        this.productName = productName;
        this.count = count;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public String tostring2(){
        return bill+","+productName+","+Double.toString(price)+","+Integer.toString(count);
    }
    public String tostring3(){
        return bill+","+productName+","+Double.toString(price)+","+Integer.toString(count)+","+Double.toString(getTotal());
    }

    @Override
    public String toString() {
        return "invoiceData{" + "productName=" + productName + ", count=" + count + ", price=" + price + '}';
    }
    
         public Double getTotal(){
     return count*price;
     }

      
}
