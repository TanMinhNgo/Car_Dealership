/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class PartsUsed implements Serializable{
    private int serviceTicketID;
    private int partID;
    private int numberUsed;
    private String price;

    public PartsUsed() {
    }

    public PartsUsed(int serviceTicketID, int partID, int numberUsed, String price) {
        this.serviceTicketID = serviceTicketID;
        this.partID = partID;
        this.numberUsed = numberUsed;
        this.price = price;
    }

    public int getServiceTicketID() {
        return serviceTicketID;
    }

    public void setServiceTicketID(int serviceTicketID) {
        this.serviceTicketID = serviceTicketID;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getNumberUsed() {
        return numberUsed;
    }

    public void setNumberUsed(int numberUsed) {
        this.numberUsed = numberUsed;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
