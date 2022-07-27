
package model;

import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvoiceLineTableSIG extends AbstractTableModel{
       private  String[] cols = {"itemName" , "itemPrice" , "count" };
       private ArrayList <InvoiceLineSIG> InvLineDataSIG;
 

    public InvoiceLineTableSIG(ArrayList<InvoiceLineSIG> InvLineDataSIG) {
        this.InvLineDataSIG = InvLineDataSIG;
    }
 

   
    
    
    
    

   
    @Override
    public int getRowCount() {
     System.out.println("Get Row Count : " + InvLineDataSIG.size());

        return InvLineDataSIG.size();
    }

    @Override
    public int getColumnCount() {
        
         System.out.println("Get Column Count : " + cols.length);
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           System.out.println("Column : " + columnIndex + "RowIndex : " + rowIndex);
        InvoiceLineSIG  lineSIG = InvLineDataSIG.get(rowIndex);
        
         switch (columnIndex) {
            case 0:
                return lineSIG.getItemName();

            case 1:
                return lineSIG.getItemPrice();

            case 2:
                return lineSIG.getCount();
         
        }

        return null;
      
    }
    
     // we need to return cols name so we will use this method:
    @Override
    public String getColumnName(int column) {
        return cols[column]; 
    }
    
    
    
}
