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
import model.Service;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class ServiceDAO {

    public Service getService(String serviceID) {
        Service ser = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select serviceID, serviceName, hourlyRate\n"
                        + "from dbo.Service\n"
                        + "where serviceID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serviceID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceid = table.getInt("serviceID");
                        String serviceName = table.getString("serviceName");
                        String hourlyRate = table.getString("hourlyRate");
                        ser = new Service(serviceid, serviceName, hourlyRate);
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
        return ser;
    }

    public ArrayList<Service> getAllServices() {
        ArrayList<Service> listS = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select serviceID, serviceName, hourlyRate, status\n"
                        + "from dbo.Service\n";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceID = table.getInt("serviceID");
                        String serviceName = table.getString("serviceName");
                        String hourlyRate = table.getString("hourlyRate");
                        int status = table.getInt("status");
                        Service ser = new Service(serviceID, serviceName, hourlyRate);
                        if (status != 0) {
                            listS.add(ser);
                        }
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
        return listS;
    }

    public int createNewService(String name, String rate) {
        int result = 0;
        ArrayList<Service> listS = getAllServices();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select top 1 serviceID\n"
                        + "from dbo.Service\n"
                        + "order by serviceID desc";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int serviceID = table.getInt("serviceID") + 1;
                    for (Service s : listS) {
                        if (s.getServiceName().equalsIgnoreCase(name)) {
                            return 0;
                        }
                    }
                    sql = "insert into dbo.Service(serviceID, serviceName, hourlyRate, status) values(?, ?, ?, 1)";
                    st = cn.prepareStatement(sql);
                    st.setInt(1, serviceID);
                    st.setString(2, name);
                    st.setString(3, rate);
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

    public int updateService(String id, String rate) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.Service\n"
                        + "set hourlyRate = ?\n"
                        + "where serviceID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, rate);
                st.setString(2, id);
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

    public int deleteService(String id) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.Service\n"
                        + "set status = 0\n"
                        + "where serviceID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
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
