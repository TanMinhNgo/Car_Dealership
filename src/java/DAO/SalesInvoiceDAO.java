/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.SalesInvoice;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class SalesInvoiceDAO {

    public ArrayList<SalesInvoice> getAllSalesInvoice() {
        ArrayList<SalesInvoice> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select invoiceID, invoiceDate, salesID, carID, custID\n"
                        + "from dbo.SalesInvoice";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int invoiceid = table.getInt("invoiceID");
                        String date = table.getString("invoiceDate");
                        String saleid = table.getString("salesID");
                        String carid = table.getString("carID");
                        String custid = table.getString("custID");
                        SalesInvoice saleI = new SalesInvoice(invoiceid, date, saleid, carid, custid);
                        list.add(saleI);
                    }
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
        return list;
    }

    public int createInvoice(String saleid, String carid, String custid) {
        int result = 0;
        ArrayList<SalesInvoice> list = getAllSalesInvoice();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = today.format(formatter);
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select top 1 invoiceID\n"
                        + "from dbo.SalesInvoice\n"
                        + "order by invoiceID desc";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int invoiceID = table.getInt("invoiceID") + 1;
                    for (SalesInvoice si: list) {
                        if(si.getCarID().equalsIgnoreCase(carid) && si.getCustID().equalsIgnoreCase(custid) && date == null) {
                            return 0;
                        }
                    }
                    sql = "insert into dbo.SalesInvoice(invoiceID, invoiceDate, salesID, carID, custID) values (?,?,?,?,?)";
                    st = cn.prepareStatement(sql);
                    st.setInt(1, invoiceID);
                    st.setString(2, date);
                    st.setString(3, saleid);
                    st.setString(4, carid);
                    st.setString(5, custid);
                    result = st.executeUpdate();
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
        return result;
    }
}
