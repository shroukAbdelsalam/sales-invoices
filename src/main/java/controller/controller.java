/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.InvoiceHeader;
import model.InvoiceLines;
/**
 *
 * @author Laptop Market
 */
public class controller {
    static String path = "E:/Software test/java/New Folder/sales_invoice/invoices.txt";
    static String summaryPath = "E:/Software test/java/New Folder/sales_invoice/invoicesSammry.txt";
    FileWriter fws;
    FileWriter fwi;
    BufferedWriter bws;
    BufferedWriter bwi;
    PrintWriter pws;
    PrintWriter pwi;
    BufferedReader brSummary;
    BufferedReader biSummary;

    public controller() {
        try {
            fws = new FileWriter(summaryPath, true);
            fwi = new FileWriter(path, true);
            bws = new BufferedWriter(fws);
            bwi = new BufferedWriter(fwi);
            pws = new PrintWriter(bws);
            pwi = new PrintWriter(bwi);

            brSummary = new BufferedReader(new FileReader(summaryPath));
            biSummary = new BufferedReader(new FileReader(path));
        } catch (IOException e) {
        }

    }

    public List<InvoiceHeader> loadSummary() {
        List<InvoiceHeader> readedData = new ArrayList<InvoiceHeader>();
        String s = "";
        try {

            while ((s = brSummary.readLine()) != null) {
                String[] data = s.split(",");
                InvoiceHeader iss = new InvoiceHeader();
                iss.setBillNumber(data[0]);
                iss.setCustomerName(data[2]);
                iss.setDate(data[1]);
                iss.setBill_Total(Double.parseDouble(data[3]));
                System.out.println(iss.toString());
                readedData.add(iss);
            }
            // summaryData = readedData.toArray(new String[readedData.size()]);
        } catch (IOException e) {
        }
        return readedData;
    }

    public List<InvoiceLines> loadSeletcedBills(String id) {
        List<InvoiceLines> loadedBills = new ArrayList<InvoiceLines>();

        String s = "";
        try {

            while ((s = biSummary.readLine()) != null) {
                String[] data = s.split(",");

                if (data[0].equals(id)) {
                    InvoiceLines iss = new InvoiceLines();
                    iss.setCount(Integer.parseInt(data[3]));
                    iss.setPrice(Double.parseDouble(data[2]));
                    iss.setProductName(data[1]);
                    loadedBills.add(iss);
                }


            }
            // summaryData = readedData.toArray(new String[readedData.size()]);
        } catch (IOException e) {
        }
        // return readedData;
        return loadedBills;
    }

    public void deleteItemf(InvoiceLines bill) {
        String compat = bill.tostring2();
        System.out.println(compat);
        List<String> FileData = new ArrayList<String>();
        String s = "";
        try {
            //int i=0;
            System.out.println(compat);
            while ((s = biSummary.readLine()) != null) {
                if (!s.equals(compat)) {
                    FileData.add(s);
                    System.out.println("readed from file: " + s);
                }
            }
            biSummary.close();
            PrintWriter pr = new PrintWriter(new FileWriter(path));
            //FileWriter withoutAppend= new FileWriter(path);
            //PrintWriter pr= new PrintWriter(withoutAppend);
            for (int i = 0; i < FileData.size(); i++) {

                pr.println(FileData.get(i).toString());
                System.out.println("writed" + FileData.get(i));
            }
            pr.close();


        } catch (Exception e) {
        }

    }

    public void deleteSummaryItem(InvoiceHeader sum) {
        String compat = sum.toString2();
        //System.out.println(compat);
        String selectedId = sum.getBillNumber();
        List<String> FileData = new ArrayList<String>();
        String s = "";
        try {
            BufferedReader bufferedReader= new BufferedReader(new FileReader(summaryPath));
            while ((s = bufferedReader.readLine()) != null) {
                if (s.equals(compat)) {
                    System.out.println("c1: "+compat);
                    System.out.println("f2: "+s);
                }
                else{
                    FileData.add(s);
                    System.out.println("c: "+compat);
                     System.out.println("f: "+s);
                }
            }
            bufferedReader.close();
            PrintWriter pr = new PrintWriter(new FileWriter(summaryPath));
            for (int i = 0; i < FileData.size(); i++) {

                pr.println(FileData.get(i).toString());
            }
            pr.close();
            deleteItemById(selectedId);


        } catch (Exception e) {
        }
    }


      public  void updateTotal(String id,double total){
          System.out.println("hi2");
          List<String> FileData = new ArrayList<String>();
          String ss = "";
          String compo = "";
          String name=null;
          String date=null;
          try {
              while ((ss = brSummary.readLine()) != null) {
                  String [] splite= ss.split(",");
                  if (splite[0].equals(id)) {
                      date=splite[1];
                      name=splite[2];
                  }
                  else {
                      FileData.add(ss);

                  }
                  compo+=id+","+date+","+name+","+String.valueOf(total);
                  System.out.println(compo);
              }
              brSummary.close();
//            PrintWriter pr = new PrintWriter(new FileWriter(path));
//            for (int i = 0; i < FileData.size(); i++) {
//                pr.println(FileData.get(i).toString());
//            }
//            pr.close();
//            //PrintWriter pp = new PrintWriter(new FileWriter(path,true));
//            bws.append(ss);
//            bws.close();


          } catch (Exception e) {
          }

      }
    void deleteItemById(String id) {
        List<String> FileData = new ArrayList<String>();
        String s = "";
        try {
            while ((s = biSummary.readLine()) != null) {
                String [] splite= s.split(",");
                if (!splite[0].equals(id)) {
                    FileData.add(s);
                }
            }
            biSummary.close();
            PrintWriter pr = new PrintWriter(new FileWriter(path));
            for (int i = 0; i < FileData.size(); i++) {
                pr.println(FileData.get(i).toString());
            }
            pr.close();
        } catch (Exception e) {
        }

    }
    public void saveNewItem(InvoiceLines d, String id, Double total) {
        String s = d.tostring2();
        //System.out.println(s);
        try {

            PrintWriter pr = new PrintWriter(new FileWriter(path, true));
            pr.println(s);
            //System.out.println(s);
            pr.close();
            updateTotal(id,total);

        } catch (Exception e) {
        }


    }

    public void saveNewBill(List<InvoiceLines> ind, InvoiceHeader ins){
        String s="";
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(path, true));
            PrintWriter ps = new PrintWriter(new FileWriter(summaryPath, true));
            for(int i =0;i<ind.size();i++){
                s=ind.get(i).tostring2();

            pr.println(s);


        }
            ps.println(ins.toString2());
            pr.close();
        }
            catch (Exception e) {
        }

    }
}

    
    

