/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class WishList implements Serializable{
   private int id;
   private String custid;
   ArrayList<String> listcar;

    public WishList() {
        listcar= new ArrayList<>();
    }

    public WishList(int id, String custid, ArrayList<String> listcar) {
        this.id = id;
        this.custid = custid;
        this.listcar = listcar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public ArrayList<String> getListcar() {
        return listcar;
    }

    public void setListcar(ArrayList<String> listcar) {
        this.listcar = listcar;
    }
   
}
