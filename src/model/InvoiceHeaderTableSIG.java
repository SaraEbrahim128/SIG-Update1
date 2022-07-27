package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import jdk.management.resource.internal.TotalResourceContext;

public class InvoiceHeaderTableSIG extends AbstractTableModel {

    private String[] Cols = {"invoiceNumber", " Date", " Customer Name " }; // here i will add total to be displayed also

    private ArrayList<InvoiceHeaderSIG> InvDataSIG;
    private Object totalSIG;

    public InvoiceHeaderTableSIG(ArrayList<InvoiceHeaderSIG> InvDataSIG) {
        this.InvDataSIG = InvDataSIG;
    }

    @Override
    public int getRowCount() {
        System.out.println("Get Row Count : " + InvDataSIG.size());

        return InvDataSIG.size();
    }

    @Override
    public int getColumnCount() {
       // System.out.println("Get Column Count : " + InvDataSIG.size());
       // return InvDataSIG.size();
        
        System.out.println("Get Colum Count : " + Cols.length);
        return  Cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        System.out.println("Column : " + columnIndex + "RowIndex : " + rowIndex);
        InvoiceHeaderSIG headerSIG = InvDataSIG.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return headerSIG.getinvoiceNumber();

            case 1:
                return headerSIG.getCustomerName();

            case 2:
                return headerSIG.getDate();
         
        }

        return " data ";
    }
      // we need to return cols name so we will use this method:
    @Override
    public String getColumnName(int column) {
        return Cols[column]; //To change body of generated methods, choose Tools | Templates.
    }
  
    
    
    

}
