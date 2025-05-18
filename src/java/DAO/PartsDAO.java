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
import model.Parts;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class PartsDAO {

    public Parts getParts(String partID) {
        Parts p = new Parts();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select partID, partName, purchasePrice, retailPrice\n"
                        + "from dbo.Parts\n"
                        + "where partID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, partID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int partid = table.getInt("partID");
                        String partName = table.getString("partName");
                        String purchasePrice = table.getString("purchasePrice");
                        String retailPrice = table.getString("retailPrice");
                        p = new Parts(partid, partName, purchasePrice, retailPrice);
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
        return p;
    }

    public ArrayList<Parts> getAllParts() {
        ArrayList<Parts> listParts = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select partID, partName, purchasePrice, retailPrice, status\n"
                        + "from dbo.Parts";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int partID = table.getInt("partID");
                        String partName = table.getString("partName");
                        String purchasePrice = table.getString("purchasePrice");
                        String retailPrice = table.getString("retailPrice");
                        int status = table.getInt("status");
                        Parts p = new Parts(partID, partName, purchasePrice, retailPrice);
                        if (status != 0) {
                            listParts.add(p);
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
        return listParts;
    }

    public ArrayList<Parts> findPartsByName(String partname) {
        ArrayList<Parts> listParts = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select partID, partName, purchasePrice, retailPrice, status\n"
                        + "from dbo.Parts\n"
                        + "where partName like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + partname + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        int partID = table.getInt("partID");
                        String partName = table.getString("partName");
                        String purchasePrice = table.getString("purchasePrice");
                        String retailPrice = table.getString("retailPrice");
                        int status = table.getInt("status");
                        Parts p = new Parts(partID, partName, purchasePrice, retailPrice);
                        if (status != 0) {
                            listParts.add(p);
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
        return listParts;
    }

    public int createPart(String name, String purchaseprice, String retailprice) {
        int result = 0;
        ArrayList<Parts> listPart = getAllParts();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select top 1 partID\n"
                        + "from dbo.Parts\n"
                        + "order by partID desc";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int partID = table.getInt("partID") + 1;
                    for (Parts part : listPart) {
                        if (part.getPartName().equalsIgnoreCase(name)) {
                            return 0;
                        }
                    }
                    sql = "insert into dbo.Parts(partID, partName, purchasePrice, retailPrice, status) values (?,?,?,?,1)";
                    st = cn.prepareStatement(sql);
                    st.setInt(1, partID);
                    st.setString(2, name);
                    st.setString(3, purchaseprice);
                    st.setString(4, retailprice);
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

    public int updatePart(int id, String name, String purchaseprice, String retailprice) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.Parts\n"
                        + "set partName = ?, purchasePrice = ?, retailPrice = ?\n"
                        + "where partID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, name);
                st.setString(2, purchaseprice);
                st.setString(3, retailprice);
                st.setInt(4, id);
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

    public int deletePart(String id) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.Parts\n"
                        + "set status = 0\n"
                        + "where partID = ?";
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

    public double getPrice(String id) {
        double result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select retailPrice\n"
                        + "from dbo.Parts\n"
                        + "where partID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        result = table.getDouble("retailPrice");
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
        return result;
    }
}
