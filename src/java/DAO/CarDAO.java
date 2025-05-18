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
import model.Car;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class CarDAO {

    public Car getCar(String carid) {
        Car car = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [carID]\n"
                        + "      ,[serialNumber]\n"
                        + "      ,[model]\n"
                        + "      ,[colour]\n"
                        + "      ,[year]\n"
                        + "  FROM [Car_Dealership].[dbo].[Cars]\n"
                        + "  WHERE carID=?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, carid);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        carid = table.getString("carID");
                        String serialnumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        int year = table.getInt("year");
                        String colour = table.getString("colour");
                        car = new Car(carid, serialnumber, model, colour, year);
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
        return car;
    }

    public ArrayList<Car> getCarsByName(String carmodel) {
        ArrayList<Car> listCar = new ArrayList();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [carID]\n"
                        + "      ,[serialNumber]\n"
                        + "      ,[model]\n"
                        + "      ,[colour]\n"
                        + "      ,[year]\n"
                        + "      ,[status]\n"
                        + "  FROM [Car_Dealership].[dbo].[Cars]\n"
                        + "  WHERE model like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + carmodel + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carid = table.getString("carID");
                        String serialnumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        int year = table.getInt("year");
                        String colour = table.getString("colour");
                        int status = table.getInt("status");
                        Car car = new Car(carid, serialnumber, model, colour, year);
                        if (status != 0) {
                            listCar.add(car);
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
        return listCar;
    }

    public ArrayList<Car> getNewCars(String carmodel) {
        ArrayList<Car> listCar = new ArrayList();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [carID]\n"
                        + "      ,[serialNumber]\n"
                        + "      ,[model]\n"
                        + "      ,[colour]\n"
                        + "      ,[year]\n"
                        + "  FROM [Car_Dealership].[dbo].[Cars]\n"
                        + "  WHERE model like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + carmodel + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carid = table.getString("carID");
                        String serialnumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        int year = table.getInt("year");
                        String colour = table.getString("colour");
                        Car car = new Car(carid, serialnumber, model, colour, year);
                        listCar.add(car);
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
        return listCar;
    }

    public ArrayList<Car> getAllCars() {
        ArrayList<Car> listCar = new ArrayList();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [carID]\n"
                        + "      ,[serialNumber]\n"
                        + "      ,[model]\n"
                        + "      ,[colour]\n"
                        + "      ,[year]\n"
                        + "      ,[status]\n"
                        + "  FROM [Car_Dealership].[dbo].[Cars]";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carid = table.getString("carID");
                        String serialnumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        int year = table.getInt("year");
                        String colour = table.getString("colour");
                        int status = table.getInt("status");
                        Car car = new Car(carid, serialnumber, model, colour, year);
                        if (status != 0) {
                            listCar.add(car);
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
        return listCar;
    }

    public ArrayList<Car> findCars(String carmodel, String serialnumber, String yearCar) {
        ArrayList<Car> listCar = new ArrayList();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT TOP (1000) [carID]\n"
                        + "      ,[serialNumber]\n"
                        + "      ,[model]\n"
                        + "      ,[colour]\n"
                        + "      ,[year]\n"
                        + "      ,[status]\n"
                        + "      ,[price]\n"
                        + "  FROM [Car_Dealership].[dbo].[Cars]"
                        + "  WHERE model like ? and serialNumber like ? and year like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + carmodel + "%");
                st.setString(2, "%" + serialnumber + "%");
                st.setString(3, "%" + yearCar + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carid = table.getString("carID");
                        String serialNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        int year = table.getInt("year");
                        String colour = table.getString("colour");
                        int status = table.getInt("status");
                        Car car = new Car(carid, serialNumber, model, colour, year);
                        if (status != 0) {
                            listCar.add(car);
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
        return listCar;
    }

    public int createCar(String serialnumber, String model, String year, String colour) {
        int result = 0;
        ArrayList<Car> listCar = getAllCars();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select top 1 carID\n"
                        + "from dbo.Cars\n"
                        + "order by carID desc";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null && table.next()) {
                    int carID = table.getInt("carID") + 1;
                    for (Car car : listCar) {
                        if (car.getSerialNumber().equalsIgnoreCase(serialnumber)) {
                            return 0;
                        }
                    }
                    sql = "insert into dbo.Cars(carID, serialNumber, model, year, colour, status, price) values (?,?,?,?,?,1, 100000000)";
                    st = cn.prepareStatement(sql);
                    st.setInt(1, carID);
                    st.setString(2, serialnumber);
                    st.setString(3, model);
                    st.setString(4, year);
                    st.setString(5, colour);
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

    public int updateCar(String id, String serialnumber, String model, String year, String colour) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.Cars\n"
                        + "set serialNumber = ?, model = ?, year = ?, colour = ?\n"
                        + "where carID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serialnumber);
                st.setString(2, model);
                st.setString(3, year);
                st.setString(4, colour);
                st.setString(5, id);
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

    public int deleteCar(String id) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "update dbo.Cars\n"
                        + "set status = 0\n"
                        + "where carID = ?";
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
