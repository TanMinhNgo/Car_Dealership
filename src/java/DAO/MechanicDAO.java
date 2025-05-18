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
import model.Mechanic;
import model.SalePerson;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class MechanicDAO {
    public Mechanic checkLogin(String name) {
        Mechanic mecha = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select mechanicID,mechanicName\n"
                        + "from dbo.Mechanic\n"
                        + "where mechanicName=?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, name);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String mechenicID = table.getString("mechanicID");
                        String mechanicName = table.getString("mechanicName");
                        mecha = new Mechanic(mechenicID, mechanicName);
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
        return mecha;
    }
    
    public Mechanic getMechanic(String mechanicID) {
        Mechanic mecha = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select mechanicID,mechanicName\n"
                        + "from dbo.Mechanic\n"
                        + "where mechanicID=?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, mechanicID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String mechanicName = table.getString("mechanicName");
                        mecha = new Mechanic(mechanicID, mechanicName);
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
        return mecha;
    }
    
    public ArrayList<Mechanic> getAllMechanic() {
        ArrayList<Mechanic> listMecha = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select mechanicID,mechanicName\n"
                        + "from dbo.Mechanic";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String mechanicID = table.getString("mechanicID");
                        String mechanicName = table.getString("mechanicName");
                        Mechanic mecha = new Mechanic(mechanicID, mechanicName);
                        listMecha.add(mecha);
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
        return listMecha;
    }
}
