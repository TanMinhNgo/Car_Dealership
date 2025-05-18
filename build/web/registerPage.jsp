<%-- 
    Document   : loginPage
    Created on : Feb 24, 2025, 4:14:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment</title>
        <link rel="stylesheet" href="style.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
    </head>
    <body>
        <div class="container" id="container">
            <div class="form-container staff-container">
                <form action="RegisterStaffServlet" accept-charset="utf-8">
                    <h1>Staff register here.</h1>
                    <div class="form-control fixed">
                        <label>
                            <input type="radio" name="role" value="mechanic" onclick="showFields('mechanic')"> Mechanic
                        </label>
                        <label>
                            <input type="radio" name="role" value="sale" onclick="showFields('sale')"> Sale
                        </label>
                    </div>
                    <div id="mechanic-fields" class="form-control hidden">
                        <div class="form-control">
                            <input type="text" name="mechaname" placeholder="Name" />
                        </div>
                    </div>
                    <div id="sale-fields" class="form-control hidden">
                        <div class="form-control">
                            <input type="text" name="salename" placeholder="Name" />
                        </div>
                        <div class="form-control">
                            <input type="text" name="salename" placeholder="Birthday" />
                        </div>
                        <div class="form-control fixed">
                            <input type="radio" name="salesex" value="F" checked=""/>Female
                            <input type="radio" name="salesex" value="M" />Male
                        </div>
                        <div class="form-control">
                            <input type="text" name="salename" placeholder="Address" />
                        </div>
                    </div>

                    <input class="input" type="submit" value="Register" style="
                           position: relative;
                           border-radius: 20px;
                           border: 1px solid #4bb6b7;
                           background-color: #4bb6b7;
                           color: #fff;
                           font-size: 15px;
                           font-weight: 700;
                           margin: 20px;
                           padding: 12px 80px;
                           letter-spacing: 1px;
                           text-transform: capitalize;
                           transition: 0.3s ease-in-out;
                           cursor: pointer;"/>
                    <a class="link" href="loginPage.jsp">Return to login</a>
                </form>
            </div>

            <div class="form-container cust-container">
                <form action="RegisterCustServlet" accept-charset="utf-8">
                    <h1>Customer register here.</h1>
                    <div class="form-control2">
                        <input type="text" name="custname" placeholder="Name" />
                    </div>
                    <div class="form-control2">
                        <input type="text" name="custphone" placeholder="Phone" pattern="^[0-9]{8-12]$"/>
                    </div>
                    <div class="form-control2 fixed">
                        <input type="radio" name="custsex" value="F" checked=""/>Female
                        <input type="radio" name="custsex" value="M" />Male
                    </div>
                    <div class="form-control2">
                        <input type="text" name="custaddress" placeholder="Address" />
                    </div>

                    <input class="input" type="submit" value="Register" style="
                           position: relative;
                           border-radius: 20px;
                           border: 1px solid #4bb6b7;
                           background-color: #4bb6b7;
                           color: #fff;
                           font-size: 15px;
                           font-weight: 700;
                           margin: 20px;
                           padding: 12px 80px;
                           letter-spacing: 1px;
                           text-transform: capitalize;
                           transition: 0.3s ease-in-out;
                           cursor: pointer;"/>
                    <a class="link" href="loginPage.jsp">Return to login</a>
                </form>
            </div>

            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1 class="title">
                            Hello <br />
                            staffs
                        </h1>
                        <p>If you are not staff, register here!</p>
                        <button class="ghost" id="customerlogin">
                            Customer register
                            <i class="fa-solid fa-arrow-left"></i>
                        </button>
                    </div>

                    <div class="overlay-panel overlay-right">
                        <h1 class="title">
                            Join with us <br />
                            to begin your journey
                        </h1>
                        <p>
                            If you are staff, register here!
                        </p>
                        <button class="ghost" id="stafflogin">
                            Staff register
                            <i class="fa-solid fa-arrow-right"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <script src="effect.js"></script>
    </body>
</html>
