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
import model.Car;
import model.WishList;
import mylib.DBUtils;

/**
 *
 * @author user
 */
public class WishlistDAO {
    public int createWishlist(String custid, ArrayList<Car> listcar) {
        int wishList = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "insert Wishlist values(?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, custid);
                wishList = st.executeUpdate();
                sql = "select top 1 id from Wishlist order by id desc";
                st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int wishlishID = table.getInt("id");
                    for (Car car : listcar) {
                        String carid = car.getCarID();
                        sql = "insert DetailWishlist values(?,?)";
                        st = cn.prepareStatement(sql);
                        st.setString(1, carid);
                        st.setInt(2, wishlishID);
                        wishList = st.executeUpdate();
                    }
                }
                cn.commit();
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
        return wishList;
    }

    public ArrayList<WishList> getWishlist(String custid) {
        ArrayList<WishList> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select W.id as 'id', W.custID as 'custid', DW.carid as 'carid'\n"
                        + "from dbo.Wishlist W, dbo.DetailWishlist DW\n"
                        + "where W.custID = ? and W.id = DW.wishlistid and DW.carid not in \n"
                        + "(select inv.carID \n"
                        + "from dbo.SalesInvoice inv\n"
                        + "where W.custID = inv.custID\n"
                        + ")";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, custid);
                ResultSet table = st.executeQuery();
                if(table != null) {
                    WishList w = new WishList();
                    while(table.next()) {
                        int id = table.getInt("id");
                        String carid = table.getString("carid");
                        w.setId(id);
                        w.setCustid(custid);
                        w.getListcar().add(carid);
                    }
                    list.add(w);
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
}
