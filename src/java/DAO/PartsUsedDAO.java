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
import model.PartsUsed;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class PartsUsedDAO {

    public ArrayList<PartsUsed> getPartsUsed(String serviceTicketId) {
        ArrayList<PartsUsed> listPu = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select partID, serviceTicketID, numberUsed, price\n"
                        + "from dbo.PartsUsed\n"
                        + "where serviceTicketID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serviceTicketId);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int partID = table.getInt("partID");
                        int serviceticketID = table.getInt("serviceTicketID");
                        int numberUsed = table.getInt("numberUsed");
                        String price = table.getString("price");
                        PartsUsed pu = new PartsUsed(serviceticketID, partID, numberUsed, price);
                        listPu.add(pu);
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

        return listPu;
    }
    
    public ArrayList<PartsUsed> getAllPartsUsed() {
        ArrayList<PartsUsed> listPu = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select partID, serviceTicketID, numberUsed, price\n"
                        + "from dbo.PartsUsed";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int partID = table.getInt("partID");
                        int serviceticketID = table.getInt("serviceTicketID");
                        int numberUsed = table.getInt("numberUsed");
                        String price = table.getString("price");
                        PartsUsed pu = new PartsUsed(serviceticketID, partID, numberUsed, price);
                        listPu.add(pu);
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
        return listPu;
    }
    
    public int createPartsUsed(String stid, String pid, String number, String price) {
        int result = 0;
        ArrayList<PartsUsed> listPu = getAllPartsUsed();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                for (PartsUsed pu : listPu) {
                    if(stid.equalsIgnoreCase("" + pu.getServiceTicketID()) && pid.equalsIgnoreCase("" + pu.getPartID())) {
                        return 0;
                    }
                }
                String sql = "insert into dbo.PartsUsed(serviceTicketID, partID, numberUsed, price) values (?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, stid);
                st.setString(2, pid);
                st.setString(3, number);
                st.setString(4, price);
                result = st.executeUpdate();
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
