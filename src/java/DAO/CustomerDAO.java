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
import model.Customer;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class CustomerDAO {

    public Customer checkLogin(String name, String phone) {
        Customer cust = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select custID,custName,phone,sex,cusAddress,status\n"
                        + "from dbo.Customer\n"
                        + "where custName = ? and phone=?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, name);
                st.setString(2, phone);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int custid = table.getInt("custID");
                        String custName = table.getString("custName");
                        String sex = table.getString("sex");
                        String custAddress = table.getString("cusAddress");
                        int status = table.getInt("status");
                        if (status != 0) {
                            cust = new Customer(custid, custName, phone, sex, custAddress);
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
        return cust;
    }

    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> listCust = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select custID,custName,phone,sex,cusAddress,status\n"
                        + "from dbo.Customer\n";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int custid = table.getInt("custID");
                        String custName = table.getString("custName");
                        String phone = table.getString("phone");
                        String sex = table.getString("sex");
                        String custAddress = table.getString("cusAddress");
                        int status = table.getInt("status");
                        Customer cust = new Customer(custid, custName, phone, sex, custAddress);
                        if (status != 0) {
                            listCust.add(cust);
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
        return listCust;
    }

    public int changeProfile(int id, String name, String phone, String sex, String address) {
        int result = 0;
        ArrayList<Customer> listCust = getCustomers();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                for (Customer cust : listCust) {
                    if (cust.getCustname().equalsIgnoreCase(name) && ("0" + cust.getPhone()).equalsIgnoreCase(phone)) {
                        return 0;
                    }
                }
                String sql = "update dbo.Customer\n"
                        + "set custName = ?, phone = ?, sex = ?, cusAddress = ?\n"
                        + "where custID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, name);
                st.setString(2, phone);
                st.setString(3, sex);
                st.setString(4, address);
                st.setInt(5, id);
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

    public ArrayList<Customer> findCustomersByName(String custname) {
        ArrayList<Customer> listCust = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select custID,custName,phone,sex,cusAddress,status\n"
                        + "from dbo.Customer\n"
                        + "where custName like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + custname + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int custid = table.getInt("custID");
                        String custName = table.getString("custName");
                        String phone = table.getString("phone");
                        String sex = table.getString("sex");
                        String custAddress = table.getString("cusAddress");
                        int status = table.getInt("status");
                        Customer cust = new Customer(custid, custName, phone, sex, custAddress);
                        if (status != 0) {
                            listCust.add(cust);
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
        return listCust;
    }

    public int createCustomer(String name, String phone, String sex, String address) {
        int result = 0;
        ArrayList<Customer> listCust = getCustomers();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select top 1 custID\n"
                        + "from dbo.Customer\n"
                        + "order by custID desc";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int custID = table.getInt("custID") + 1;
                    for (Customer cust : listCust) {
                        if (cust.getCustname().equalsIgnoreCase(name) && ("0" + cust.getPhone()).equalsIgnoreCase(phone)) {
                            return 0;
                        }
                    }
                    sql = "insert into dbo.Customer(custID, custName, phone, sex, cusAddress, status) values (?,?,?,?,?,1)";
                    st = cn.prepareStatement(sql);
                    st.setInt(1, custID);
                    st.setString(2, name);
                    st.setString(3, phone);
                    st.setString(4, sex);
                    st.setString(5, address);
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

    public Customer findCustomerByID(String id) {
        Customer cust = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select custID,custName,phone,sex,cusAddress\n"
                        + "from dbo.Customer\n"
                        + "where custID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int custid = table.getInt("custID");
                        String custName = table.getString("custName");
                        String phone = table.getString("phone");
                        String sex = table.getString("sex");
                        String custAddress = table.getString("cusAddress");
                        cust = new Customer(custid, custName, phone, sex, custAddress);
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
        return cust;
    }

    public int deleteCust(String id) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.Customer\n"
                        + "set status = 0\n"
                        + "where custID = ?";
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
