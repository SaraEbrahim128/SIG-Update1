package controller;

import SIG.JFrameView.SIGJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeaderSIG;
import model.InvoiceLineSIG;

/**
 *
 * @author MUSLIM
 */
public class Controller implements ActionListener, ListSelectionListener {

    private  SIGJFrame FrameSIG;
    // we will create constractor to know the frame for sending the file data refrence of the frame 
    private Object InvHeaderTableSIG;

    public Controller(SIGJFrame FrameSIG) {
        this.FrameSIG = FrameSIG;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand;
        actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Load File":

                // we will create func for each button to customize which button clicked ....
                LoadFile();

                break;

            case "Save File":
                SaveFile();

                break;

            case "Create New Invoice":
                CreateNewInvoice();

                break;

            case "Delete Invoice":
                DeleteInvoice();

                break;

            case "Save":
                Save();

                break;

            case "Cancel":
                Cancel();

                break;

        }

    }

    @Override
    
    //for ghandeling selection from first table to another
    public void valueChanged( ListSelectionEvent e) {
        System.out.println("here is your Selected the Row " );
        // we need to specify which row is selected
        
         
         // int selectedRowSIG = 0 ;
    // selectedRowSIG = SIGJFrame.getInvHeaderListSIG(selectedRow);
    //    ArrayList<InvoiceLineSIG> linesSIGFromSelectedRow;
    //   linesSIGFromSelectedRow = SIGJFrame.getInvHeaderListSIG(selectedRow.getgetInvLineTable();
    //   SIGJFrame.getInvoiceLineTableSIG().setModel(InvoiceLineTableSIG(linesSIGFromSelectedRow));
        
        
        
        
     
        //third trial
       //  String selectedData = null;

 //   int[] selectedRow = InvHeaderTableSIG.getSelectedRows();
 //   int[] selectedColumns = InvHeaderTableSIG.getSelectedColumns();

 //   for (int i = 0; i < selectedRow.length; i++) {
    //  for (int j = 0; j < selectedColumns.length; j++) {
    //    selectedData = (String) InvHeaderTableSIG.getValueAt(selectedRow[i], selectedColumns[j]);
    //  }
   // }
    System.out.println("Selected: " );
        
        
        
        
        
        
        
        
        //second trial
       //   String selectedCellValue = (String) InvHeaderTableSIG.getValueAt(InvHeaderTableSIG.getSelectedRow() , InvHeaderTableSIG.getSelectedColumn());
         //   System.out.println(selectedCellValue);
        
        
        
        //first trial
     // int selectedRowSIG;
    // selectedRowSIG = SIGJFrame.getInvoiceHeaderTableSIG().getselectedRowSIG();
    //    ArrayList<InvoiceLineSIG> linesSIGFromSelectedRow;
    //   linesSIGFromSelectedRow = FrameSIG.getInvHeaderListSIG().get(SelectedRowSIG).getgetInvLineTable();
    //   SIGJFrame.getInvoiceLineTableSIG().setModel(InvoiceLineTableSIG(linesSIGFromSelectedRow));
        
        
        
        System.out.println("here is your Selected the Row's Data " );
        
        
        
                
                
                
        
        
    }



    @SuppressWarnings("empty-statement")
    private void LoadFile() {
        JFileChooser fcSIG = new JFileChooser();
        int resultSIG = fcSIG.showOpenDialog(FrameSIG);

        if (JFileChooser.APPROVE_OPTION == resultSIG) {
            try {
                File headerFile; // to catch the implemented file
                headerFile = fcSIG.getSelectedFile();
                //to read the selected file
                String headerStrPath = headerFile.getAbsolutePath();

                Path headerPath;
                headerPath = Paths.get(headerStrPath);
                Files.lines((Path) headerPath).collect(Collectors.toList());
                List<String> headerLinesSIG = Files.lines((Path) headerPath).collect(Collectors.toList());
                // Array Will Be Containes data As 
                // first item  [1,22-11-2020,Ali]
                // second  item 2,13-10-2021,Saleh
                // we need to create array list of invoice headers 

                ArrayList<InvoiceHeaderSIG> InvHeaderListSIG;
                InvHeaderListSIG = new ArrayList<>();    // file not read

                for (String headerLine : headerLinesSIG) {
                    String[] PartsSIG = headerLine.split(",");
                    for(int i =0;i<PartsSIG.length;i++){
                        System.out.println("array " + i + " " + PartsSIG[i]);
                    }
                    //So That we will find that PartsSIG1= [ "1" , "22-11-2020" , "Ali"]
                    int invoiceNumber = Integer.parseInt(PartsSIG[0]);
                    InvoiceHeaderSIG headerSIG;
                    headerSIG = new InvoiceHeaderSIG(invoiceNumber, PartsSIG[2], PartsSIG[1]);
                    InvHeaderListSIG.add(headerSIG);
                }

                resultSIG = fcSIG.showOpenDialog(FrameSIG);
                if (resultSIG == JFileChooser.APPROVE_OPTION) {
                    String lineStrPath = fcSIG.getSelectedFile().getAbsolutePath();
                    Path linePathSIG = Paths.get(lineStrPath);
                    List<String> lineLinesSIG = Files.lines(linePathSIG).collect(Collectors.toList());
                    for (String lineLine : lineLinesSIG) {
                        String[] PartsSIG = lineLine.split(",");
                        int InvoiveNumber = Integer.parseInt(PartsSIG[0]);
                        double itemPrice = Integer.parseInt(PartsSIG[2]);
                        int count = Integer.parseInt(PartsSIG[3]);
                        InvoiceHeaderSIG header = getInvoiceHeaderSIGBYId(InvHeaderListSIG, InvoiveNumber);
                        InvoiceLineSIG InvLineSIG = new InvoiceLineSIG(PartsSIG[1], itemPrice, count);
                        header.getinvoiceLines().add(InvLineSIG);

                    }

                    FrameSIG.setInvHeaderListSIG(InvHeaderListSIG);

                }

            } catch (IOException ex) {
                System.out.println("controller.Controller.LoadFile()" + ex.getMessage());
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void SaveFile() {
    }

    private void CreateNewInvoice() {
    }

    private void DeleteInvoice() {
    }

    private void Save() {
    }

    private void Cancel() {
    }

    private InvoiceHeaderSIG getInvoiceHeaderSIGBYId(ArrayList<InvoiceHeaderSIG> InvHeaderListSIG, int InvoiveNumber) {
        for (InvoiceHeaderSIG invoiceSIG : InvHeaderListSIG) {
            if ((invoiceSIG.getinvoiceNumber() == InvoiveNumber)) {
                ArrayList<InvoiceLineSIG> invoiceLineSIGs = new ArrayList<>();
                InvoiceHeaderSIG headerSIG = new InvoiceHeaderSIG();
                headerSIG.setinvoiceNumber(1);
                InvoiceLineSIG invoiceLineSIG = new InvoiceLineSIG(headerSIG);
                invoiceLineSIGs.add(invoiceLineSIG);
                invoiceSIG.setGetinvoiceLines(invoiceLineSIGs);
                return invoiceSIG;
            }
        }
        return null;
    }

    private static class path {

        public path() {
        }
    }

}
