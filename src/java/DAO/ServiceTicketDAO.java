/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ServiceTicket;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class ServiceTicketDAO {

    public ArrayList<ServiceTicket> getServiceTicket(String custid) {
        ArrayList<ServiceTicket> listTicket = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [serviceTicketID]\n"
                        + "      ,[dateReceived]\n"
                        + "      ,[dateReturned]\n"
                        + "      ,[custID]\n"
                        + "      ,[carID]\n"
                        + "  FROM [Car_Dealership].[dbo].[ServiceTicket]\n"
                        + "  WHERE custID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, custid);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int ticketid = table.getInt("serviceTicketID");
                        Date receive = table.getDate("dateReceived");
                        Date returned = table.getDate("dateReturned");
                        String carid = table.getString("carID");
                        ServiceTicket ticket = new ServiceTicket(ticketid, receive, returned, custid, carid);
                        listTicket.add(ticket);
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
        return listTicket;
    }

    public ServiceTicket getDetailServiceTicket(String custID, String serviceTicketID) {
        ServiceTicket serviceticket = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select serviceTicketID, custID, carID, dateReceived, dateReturned\n"
                        + "from dbo.ServiceTicket\n"
                        + "where custID = ? and serviceTicketID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, custID);
                st.setString(2, serviceTicketID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceticketid = table.getInt("serviceTicketID");
                        String carid = table.getString("carID");
                        Date datereceived = table.getDate("dateReceived");
                        Date datereturned = table.getDate("dateReturned");
                        serviceticket = new ServiceTicket(serviceticketid, datereceived, datereturned, custID, carid);
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
        return serviceticket;
    }

    public String getTotalPriceServiceTicket(String serviceTicketID) {
        String totalPrice = "";
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select st.serviceTicketID, sum(p.PartU) as 'total'\n"
                        + "from dbo.ServiceTicket st join (select st1.serviceTicketID, sum(pu.price) as 'PartU'\n"
                        + "                                from dbo.ServiceTicket st1 join dbo.PartsUsed pu\n"
                        + "                                on st1.serviceTicketID = pu.serviceTicketID\n"
                        + "                                group by st1.serviceTicketID\n"
                        + "                                union\n"
                        + "                                select st1.serviceTicketID, sum(sm.rate)\n"
                        + "                                from dbo.ServiceTicket st1 join dbo.ServiceMehanic sm\n"
                        + "                                on sm.serviceTicketID = st1.serviceTicketID \n"
                        + "                                group by st1.serviceTicketID) p\n"
                        + "on st.serviceTicketID = p.serviceTicketID\n"
                        + "where st.serviceTicketID = ?\n"
                        + "group by st.serviceTicketID";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serviceTicketID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        totalPrice = table.getString("total");
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
        return totalPrice;
    }

    public ArrayList<ServiceTicket> getServiceTicketByMechaID(String mechaID) {
        ArrayList<ServiceTicket> listSt = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select st.serviceTicketID, st.custID, st.carID, st.dateReceived, st.dateReturned\n"
                        + "from dbo.ServiceTicket st join dbo.ServiceMehanic sm\n"
                        + "on st.serviceTicketID = sm.serviceTicketID\n"
                        + "where sm.mechanicID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, mechaID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceticketid = table.getInt("serviceTicketID");
                        String custid = table.getString("custID");
                        String carid = table.getString("carID");
                        Date datereceived = table.getDate("dateReceived");
                        Date datereturned = table.getDate("dateReturned");
                        ServiceTicket serTic = new ServiceTicket(serviceticketid, datereceived, datereturned, custid, carid);
                        if (listSt == null || listSt.isEmpty()) {
                            listSt.add(serTic);
                        } else {
                            for (ServiceTicket st1 : listSt) {
                                if (serTic.getServiceTicketID() != st1.getServiceTicketID()) {
                                    listSt.add(serTic);
                                }
                            }
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
        return listSt;
    }

    public ArrayList<ServiceTicket> searchTicketByID(String mechaid, String custid, String carid) {
        ArrayList<ServiceTicket> listSt = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select st.serviceTicketID, st.custID, st.carID, st.dateReceived, st.dateReturned\n"
                        + "from dbo.ServiceTicket st join dbo.ServiceMehanic sm\n"
                        + "on st.serviceTicketID = sm.serviceTicketID\n"
                        + "where sm.mechanicID = ? and st.custID like ? and st.carID like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, mechaid);
                st.setString(2, "%" + custid + "%");
                st.setString(3, "%" + carid + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceticketid = table.getInt("serviceTicketID");
                        String custID = table.getString("custID");
                        String carID = table.getString("carID");
                        Date datereceived = table.getDate("dateReceived");
                        Date datereturned = table.getDate("dateReturned");
                        ServiceTicket serTic = new ServiceTicket(serviceticketid, datereceived, datereturned, custID, carID);
                        if (listSt == null || listSt.isEmpty()) {
                            listSt.add(serTic);
                        } else {
                            for (ServiceTicket st1 : listSt) {
                                if (serTic.getServiceTicketID() != st1.getServiceTicketID()) {
                                    listSt.add(serTic);
                                }
                            }
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
        return listSt;
    }

    public ArrayList<ServiceTicket> searchTicketByDate(String mechaid, String DateReceive) {
        ArrayList<ServiceTicket> listSt = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select st.serviceTicketID, st.custID, st.carID, st.dateReceived, st.dateReturned\n"
                        + "from dbo.ServiceTicket st join dbo.ServiceMehanic sm\n"
                        + "on st.serviceTicketID = sm.serviceTicketID\n"
                        + "where sm.mechanicID = ? and st.dateReceived like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, mechaid);
                st.setString(2, "%" + DateReceive + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int serviceticketid = table.getInt("serviceTicketID");
                        String custID = table.getString("custID");
                        String carID = table.getString("carID");
                        Date datereceived = table.getDate("dateReceived");
                        Date datereturned = table.getDate("dateReturned");
                        ServiceTicket serTic = new ServiceTicket(serviceticketid, datereceived, datereturned, custID, carID);
                        if (listSt == null || listSt.isEmpty()) {
                            listSt.add(serTic);
                        } else {
                            for (ServiceTicket st1 : listSt) {
                                if (serTic.getServiceTicketID() != st1.getServiceTicketID()) {
                                    listSt.add(serTic);
                                }
                            }
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
        return listSt;
    }

    public ArrayList<ServiceTicket> getAllServiceTicket() {
        ArrayList<ServiceTicket> listTicket = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [serviceTicketID]\n"
                        + "      ,[dateReceived]\n"
                        + "      ,[dateReturned]\n"
                        + "      ,[custID]\n"
                        + "      ,[carID]\n"
                        + "  FROM [Car_Dealership].[dbo].[ServiceTicket]";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int ticketid = table.getInt("serviceTicketID");
                        Date receive = table.getDate("dateReceived");
                        Date returned = table.getDate("dateReturned");
                        String custid = table.getString("custID");
                        String carid = table.getString("carID");
                        ServiceTicket ticket = new ServiceTicket(ticketid, receive, returned, custid, carid);
                        listTicket.add(ticket);
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
        return listTicket;
    }

    public int createServiceTicket(String custid, String carid, String datereceived, String datereturned) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select top 1 serviceTicketID\n"
                        + "from dbo.ServiceTicket\n"
                        + "order by serviceTicketID desc";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int serviceTicketID = table.getInt("serviceTicketID") + 1;

                    sql = "insert into dbo.ServiceTicket(serviceTicketID, dateReceived, dateReturned, custID, carID) values (?,?,?,?,?)";
                    st = cn.prepareStatement(sql);
                    st.setInt(1, serviceTicketID);
                    st.setString(2, datereceived);
                    st.setString(3, datereturned);
                    st.setString(4, custid);
                    st.setString(5, carid);
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
    
    public ServiceTicket getNewServiceTicket() {
        ServiceTicket ser = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select top 1 serviceTicketID\n"
                        + "from dbo.ServiceTicket\n"
                        + "order by serviceTicketID desc";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int serviceTicketID = table.getInt("serviceTicketID");
                    sql = "select serviceTicketID, custID, carID, dateReceived, dateReturned\n"
                        + "from dbo.ServiceTicket\n"
                        + "where serviceTicketID = ?";
                    st = cn.prepareStatement(sql);
                    st.setInt(1, serviceTicketID);
                    table = st.executeQuery();
                    if (table != null) {
                        while (table.next()) {
                            int serviceticketid = table.getInt("serviceTicketID");
                            String custID = table.getString("custID");
                            String carid = table.getString("carID");
                            Date datereceived = table.getDate("dateReceived");
                            Date datereturned = table.getDate("dateReturned");
                            ser = new ServiceTicket(serviceticketid, datereceived, datereturned, custID, carid);
                    }
                };
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
}
