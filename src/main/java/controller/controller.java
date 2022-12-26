/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.invoiceSummary;
import model.invoiceData;
/**
 *
 * @author Laptop Market
 */
public class controller {
    static String path = "./invoices.txt";
    static String summaryPath = "./invoicesSammry.txt";
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

    public List<invoiceSummary> loadSummary() {
        List<invoiceSummary> readedData = new ArrayList<invoiceSummary>();
        String s = "";
        try {

            while ((s = brSummary.readLine()) != null) {
                String[] data = s.split(",");
                invoiceSummary iss = new invoiceSummary();
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

    public List<invoiceData> loadSeletcedBills(String id) {
        List<invoiceData> loadedBills = new ArrayList<invoiceData>();

        String s = "";
        try {

            while ((s = biSummary.readLine()) != null) {
                String[] data = s.split(",");

                if (data[0].equals(id)) {
                    invoiceData iss = new invoiceData();
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

    public void deleteItemf(invoiceData bill) {
        String compat = bill.tostring2();
        List<String> FileData = new ArrayList<String>();
        String s = "";
        String id="";
        double value=0.0;
        try {
            //int i=0;

            while ((s = biSummary.readLine()) != null) {
                if (!s.equals(compat)) {
                    FileData.add(s);
                }
                else{
                    String [] splite= s.split(",");
                    id=splite[0];
                    value=Double.parseDouble(splite[2]);
                }
            }
            biSummary.close();
            PrintWriter pr = new PrintWriter(new FileWriter(path));
            for (int i = 0; i < FileData.size(); i++) {

                pr.println(FileData.get(i));
            }
            pr.close();

            List<String> FileData2 = new ArrayList<String>();
            String s2 = "";
                while ((s = brSummary.readLine()) != null) {
                    String [] splite= s.split(",");
                    if (splite[0].equals(id)) {
                        double val= Double.parseDouble(splite[3]);
                        invoiceSummary in= new invoiceSummary();
                        in.setBillNumber(splite[0]);
                        in.setDate(splite[1]);
                        in.setCustomerName(splite[2]);
                        in.setBill_Total(value-val);
                        s=in.toString2();
                        FileData.add(s);
                    }
                    else {
                        FileData.add(s);
                    }
                }
                brSummary.close();
            PrintWriter prr = new PrintWriter(new FileWriter(path));
            for (int i = 0; i < FileData.size(); i++) {
                prr.println(FileData.get(i));
            }
            prr.close();


        } catch (Exception e) {
        }

    }

    public void deleteSummaryItem(invoiceSummary sum) {
        String compat = sum.toString2();
        String selectedId = sum.getBillNumber();
        List<String> FileData = new ArrayList<String>();
        String s = "";
        try {
            BufferedReader bufferedReader= new BufferedReader(new FileReader(summaryPath));
            while ((s = bufferedReader.readLine()) != null) {
                if (s.equals(compat)) {

                }
                else{
                 FileData.add(s);
                }
            }
            bufferedReader.close();
            PrintWriter pr = new PrintWriter(new FileWriter(summaryPath));
            for (int i = 0; i < FileData.size(); i++) {

                pr.println(FileData.get(i));
            }
            pr.close();
            deleteItemById(selectedId);


        } catch (Exception e) {
        }
        System.out.println("selected id:"+selectedId);
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
                pr.println(FileData.get(i));
            }
            pr.close();
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

    public void saveNewItem(invoiceData d, String id, Double total) {
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

    public void saveNewBill(List<invoiceData> ind,invoiceSummary ins){
        String s="";
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(path, true));
            PrintWriter ps = new PrintWriter(new FileWriter(summaryPath, true));
            for(int i =0;i<ind.size();i++){
                s=ind.get(i).tostring2();
            pr.println(s);
        }
            pr.close();
            System.out.println(ins.getTotalBill());
            ps.println(ins.toString2());
            ps.close();
        }
            catch (Exception e) {
        }

    }
}

    
    

