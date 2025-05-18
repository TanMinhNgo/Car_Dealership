/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Invoice;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class InvoiceDAO {

    public ArrayList<Invoice> getInvoices(String custid, String date) {
        ArrayList<Invoice> listInvoice = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            String sql = "select invoiceID,invoiceDate,salesID,carID,custID\n"
                    + "from dbo.SalesInvoice\n"
                    + "where custID=? and invoiceDate like ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, custid);
            st.setString(2, "%" + date + "%");
            ResultSet table = st.executeQuery();
            if (table != null) {
                while (table.next()) {
                    String id = table.getString("invoiceID");
                    String invoiceDate = table.getString("invoiceDate");
                    String carid = table.getString("carID");
                    String saleid = table.getString("salesID");
                    Invoice inv = new Invoice(id, custid, saleid, carid, invoiceDate);
                    listInvoice.add(inv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listInvoice;
    }
}
