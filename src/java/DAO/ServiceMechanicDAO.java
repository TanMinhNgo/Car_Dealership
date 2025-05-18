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
import model.ServiceMechanic;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class ServiceMechanicDAO {

    public ArrayList<ServiceMechanic> getServiceMechanic(String serviceTicketId) {
        ArrayList<ServiceMechanic> listSm = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select serviceID, serviceTicketID, mechanicID, hours, rate, comment\n"
                        + "from dbo.ServiceMehanic\n"
                        + "where serviceTicketID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serviceTicketId);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceID = table.getInt("serviceID");
                        int serviceticketID = table.getInt("serviceTicketID");
                        String mechanicID = table.getString("mechanicID");
                        int hours = table.getInt("hours");
                        String rate = table.getString("rate");
                        String comment = table.getString("comment");
                        ServiceMechanic sm = new ServiceMechanic(serviceticketID, serviceID, mechanicID, hours, comment, rate);
                        listSm.add(sm);
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

        return listSm;
    }

    public ArrayList<ServiceMechanic> getServiceMechanicByMechaID(String mechaID, String stid) {
        ArrayList<ServiceMechanic> listSm = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select serviceTicketID, serviceID, mechanicID, hours, comment, rate\n"
                        + "from dbo.ServiceMehanic\n"
                        + "where mechanicID = ? and serviceTicketID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, mechaID);
                st.setString(2, stid);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceID = table.getInt("serviceID");
                        int serviceticketID = table.getInt("serviceTicketID");
                        String mechanicID = table.getString("mechanicID");
                        int hours = table.getInt("hours");
                        String rate = table.getString("rate");
                        String comment = table.getString("comment");
                        ServiceMechanic sm = new ServiceMechanic(serviceticketID, serviceID, mechanicID, hours, comment, rate);
                        listSm.add(sm);
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
        return listSm;
    }
    
    public ArrayList<ServiceMechanic> getAllServiceMechanic() {
        ArrayList<ServiceMechanic> listSm = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select serviceTicketID, serviceID, mechanicID, hours, comment, rate\n"
                        + "from dbo.ServiceMehanic";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceID = table.getInt("serviceID");
                        int serviceticketID = table.getInt("serviceTicketID");
                        String mechanicID = table.getString("mechanicID");
                        int hours = table.getInt("hours");
                        String rate = table.getString("rate");
                        String comment = table.getString("comment");
                        ServiceMechanic sm = new ServiceMechanic(serviceticketID, serviceID, mechanicID, hours, comment, rate);
                        listSm.add(sm);
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
        return listSm;
    }

    public ServiceMechanic getServiceMechanicToUpdate(String mechaID, String stid, String serID) {
        ServiceMechanic sm = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select serviceTicketID, serviceID, mechanicID, hours, comment, rate\n"
                        + "from dbo.ServiceMehanic\n"
                        + "where mechanicID = ? and serviceTicketID = ? and serviceID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, mechaID);
                st.setString(2, stid);
                st.setString(3, serID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceID = table.getInt("serviceID");
                        int serviceticketID = table.getInt("serviceTicketID");
                        String mechanicID = table.getString("mechanicID");
                        int hours = table.getInt("hours");
                        String rate = table.getString("rate");
                        String comment = table.getString("comment");
                        sm = new ServiceMechanic(serviceticketID, serviceID, mechanicID, hours, comment, rate);
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
        return sm;
    }

    public int updateServiceMechanic(String stID, String sID, String mID, String hours, String comment, String rate) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.ServiceMehanic\n"
                        + "set hours = ?, comment = ?, rate = ?\n"
                        + "where serviceTicketID = ? and serviceID = ? and mechanicID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, hours);
                st.setString(2, comment);
                st.setString(3, rate);
                st.setString(4, stID);
                st.setString(5, sID);
                st.setString(6, mID);
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
    
    public int createServiceMechanic(String stid, String sid, String mid, String rate) {
        int result = 0;
        ArrayList<ServiceMechanic> listSm = getAllServiceMechanic();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                for (ServiceMechanic sm : listSm) {
                    if(stid.equalsIgnoreCase("" + sm.getServiceTicketID()) && sid.equalsIgnoreCase("" + sm.getServiceID())) {
                        return 0;
                    }
                }
                String sql = "insert into dbo.ServiceMehanic(serviceTicketID, serviceID, mechanicID, rate) values (?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, stid);
                st.setString(2, sid);
                st.setString(3, mid);
                st.setString(4, rate);
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
