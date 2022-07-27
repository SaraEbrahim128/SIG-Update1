/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MUSLIM
 */
public class InvoiceLineSIG {
        private String itemName;
    private double itemPrice;
    private int count;
    private InvoiceHeaderSIG headerSIG; 
 
    // this is ref to header

    public InvoiceLineSIG(String itemName, double itemPrice, int count, InvoiceHeaderSIG headerSIG) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.headerSIG = headerSIG;
    }

    public InvoiceLineSIG(String string, double itemPrice, int count) {
    }

    public InvoiceLineSIG() {
    }

    public InvoiceLineSIG(InvoiceHeaderSIG headerSIG) {
    }

    public InvoiceHeaderSIG getHeaderSIG() {
        return headerSIG;
    }

    public void setHeaderSIG(InvoiceHeaderSIG headerSIG) {
        this.headerSIG = headerSIG;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getLineTotal() {
        return count * itemPrice ;
    }

        @Override
    public String toString() {
        return "InvoiceLines{" + "itemName=" + itemName + ", itemPrice=" + itemPrice + ", count=" + count + ", lineTotal=" + getLineTotal() + '}';
    }

 
    
    
}
