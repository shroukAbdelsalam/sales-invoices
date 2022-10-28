package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//ArrayList<InvoiceHeader>
public class FileOperations {
//    public static void main(String[] args) {
//        FileOperations f= new FileOperations();
//        f.writeFileHeader();
//        //f.readFileHeader();
//        f.writeFileLines();
//        //f.readFileLines();
//        //f.ReadHeaderANDLines();
//    }
  String invoicHeaderPath="E:\\Software test\\java\\New Folder\\sales_invoice\\InvoiceHeader.csv";
  String invoicLinesPath ="E:\\Software test\\java\\New Folder\\sales_invoice\\InvoiceLines.csv";


  public List<InvoiceHeader> readFileHeader() {
      BufferedReader reader = null;

      List<InvoiceHeader> bills = null;
      try {
          bills = new ArrayList<InvoiceHeader>();
          String line = "";
          reader = new BufferedReader(new FileReader(invoicHeaderPath));
          reader.readLine();

          while ((line = reader.readLine()) != null) {
              String[] fields = line.split(",");

              if (fields.length > 0) {
                  InvoiceHeader in = new InvoiceHeader();
                  in.setBillNumber(fields[0]);
                  in.setDate(fields[1]);
                  in.setCustomerName(fields[2]);
                  bills.add(in);
              }
          }

//          for (InvoiceHeader u : bills) {
//              System.out.printf("[billNumber=%s, billDate=%s, customerName=%s]\n", u.getBillNumber(), u.getDate(), u.getCustomerName());
//          }

      } catch (Exception ex) {
          ex.printStackTrace();
      } finally {
          try {
              reader.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return bills;
  }

  public  List<InvoiceLines> readFileLines(){
      List<InvoiceLines> lines= new ArrayList<>();
      BufferedReader reader = null;
      try {
          String line = "";
          reader = new BufferedReader(new FileReader(invoicLinesPath));
          reader.readLine();

          while ((line = reader.readLine()) != null) {
              String[] fields = line.split(",");

              if (fields.length > 0) {
                  InvoiceLines in = new InvoiceLines();
                  in.setBill(fields[0]);
                  in.setProductName(fields[1]);
                  in.setPrice(Double.parseDouble(fields[2]));
                  in.setCount(Integer.parseInt(fields[3]));
                  lines.add(in);
              }
          }

          for (InvoiceLines u : lines) {
              System.out.printf("[billNumber=%s, Product Name=%s, Price=%s, Count=%s, Total=%s]\n",
                      u.getBill(), u.getProductName(), u.getPrice().toString(), u.getCount(),u.getTotal().toString());
          }

      } catch (Exception ex) {
          ex.printStackTrace();
      } finally {
          try {
              reader.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
    return  lines;
  }
    public  List<InvoiceLines> readFileLinesById(String id){
        List<InvoiceLines> lines= new ArrayList<>();
        BufferedReader reader = null;
        try {
            String line = "";
            reader = new BufferedReader(new FileReader(invoicLinesPath));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length > 0) {
                    if(fields[0].equals(id)) {
                        InvoiceLines in = new InvoiceLines();
                        in.setBill(fields[0]);
                        in.setProductName(fields[1]);
                        in.setPrice(Double.parseDouble(fields[2]));
                        in.setCount(Integer.parseInt(fields[3]));
                        lines.add(in);
                    }
                }
            }



        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  lines;
    }
  public  void writeFileLines(List<InvoiceLines> bills){

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(invoicLinesPath,true);

           // fileWriter.append("Bill Number, Product Name,  Price,  Count, Total \n");
            for(InvoiceLines line:bills){
                fileWriter.append(line.tostring3());
                fileWriter.append("\n");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public  void writeFileHeader(InvoiceHeader h){

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(invoicHeaderPath,true);

            //fileWriter.append("Bill Number, Bill Date, Customer Name\n");
            fileWriter.append(h.toString3());
            System.out.println(h.toString3());
            fileWriter.append("\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
public void ReadHeaderANDLines(){
    List<InvoiceHeader> header=readFileHeader();
    List<InvoiceLines> lines=readFileLines();
    for(int i=0;i<header.size();i++){
        System.out.println("Bill Number : "+header.get(i).getBillNumber()+"\n"+"{"+"\n"+
                header.get(i).getDate()+" "+header.get(i).getCustomerName());
        for(int j=0;j<lines.size();j++){
            if(lines.get(j).getBill().equals(header.get(i).getBillNumber())) {
                String print = lines.get(j).getProductName() + " ," + String.valueOf(lines.get(j).getPrice()) + "," +
                        String.valueOf(lines.get(j).getCount()) + "," + String.valueOf(lines.get(i).getTotal());
                System.out.println(print);
            }
        }
        System.out.println("}");
    }

}

public void DeleteBillByIdHead(String id){
      //remove bill head and all lines releated
    /*
    * 1- read all head file except deleted item
    * 2- write all file again without append ...takecare when write skip first line
    * 3- read all data in lines except wanted to delete
    * 4- write write all file again without append ...takecare when write skip first line
    * */
    List<InvoiceHeader> lines= new ArrayList<>();
    BufferedReader reader = null;
    try {
        String line = "";
        reader = new BufferedReader(new FileReader(invoicHeaderPath));
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");

            if (fields.length > 0) {
                if(!fields[0].equals(id)) {
                    InvoiceHeader in = new InvoiceHeader();
                    in.setBillNumber(fields[0]);
                    in.setDate(fields[1]);
                    in.setCustomerName((fields[2]));
                    lines.add(in);
                }
            }
        }



    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    WriteWithoutAppendHead(lines);
    DeleteLinesItems(id);

}
public  void WriteWithoutAppendHead(List<InvoiceHeader> in){

    FileWriter fileWriter = null;



    try {
        fileWriter = new FileWriter(invoicHeaderPath);
        fileWriter.append("Bill Number, Bill Date, Customer Name \n");
        for(int i =0;i<in.size();i++){
            fileWriter.append( in.get(i).toString3());
            fileWriter.append("\n");
        }


    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public  void DeleteLinesItems(String id){


        List<InvoiceLines> lines= new ArrayList<>();
        BufferedReader reader = null;
        try {
            String line = "";
            reader = new BufferedReader(new FileReader(invoicLinesPath));
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length > 0) {
                    if(!fields[0].equals(id)) {
                        InvoiceLines in = new InvoiceLines();
                        in.setBill(fields[0]);
                        in.setProductName(fields[1]);
                        in.setPrice(Double.parseDouble(fields[2]));
                        in.setCount(Integer.parseInt(fields[3]));
                        lines.add(in);
                    }
                }
            }



        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(invoicLinesPath);
            fileWriter.append("Bill Number, Product Name,  Price, Count \n");
            for(int i =0;i<lines.size();i++){
                fileWriter.append( lines.get(i).tostring3());
                fileWriter.append("\n");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
