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
        <title>Car Dealership</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
    </head>
    <body>
        
        <div class="container" id="container">
            <div class="form-container staff-container">
                <form action="MainServlet" accept-charset="utf-8" method="post">
                    <h1>Staff login here.</h1>
                    <div class="form-control">
                        <input type="text" name="staffname" placeholder="Name" />
                    </div>
                    <input class="input" type="submit" value="Login" style="
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
                    <input type="hidden" name="action" value="login_Staff">
                    <h4>
                        <%
                            if (request.getAttribute("ERROR2") != null) {
                                out.print(request.getAttribute("ERROR2"));
                            }
                        %>
                    </h4>
                    <span>or use your account</span>
                    <div class="social-container">
                        <a href="#" class="social"
                           ><i class="fa-brands fa-facebook-f"></i
                            ></a>
                        <a href="#" class="social"><i class="fa-brands fa-google"></i></a>
                        <a href="#" class="social"><i class="fa-brands fa-tiktok"></i></a>
                    </div>
                </form>
            </div>

            <div class="form-container cust-container">
                <form action="MainServlet" accept-charset="utf-8">
                    
                    <h1>Customer login here.</h1>
                    <div class="form-control2">
                        <input type="text" name="custname" placeholder="Enter your name..." />
                    </div>
                    <div class="form-control2">
                        <input type="text" name="custphone" placeholder="Enter your phone..." />
                    </div>

                    <input class="input" type="submit" value="Login" style="
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
                    <input type="hidden" name="action" value="login_Customer" />
                    <h4>
                        <%
                            if (request.getAttribute("ERROR1") != null) {
                                out.print(request.getAttribute("ERROR1"));
                            }
                        %>
                    </h4>
                    <span>Or use your account</span>
                    <div class="social-container">
                        <a href="#" class="social"
                           ><i class="fa-brands fa-facebook-f"></i
                            ></a>
                        <a href="#" class="social"><i class="fa-brands fa-google"></i></a>
                        <a href="#" class="social"><i class="fa-brands fa-tiktok"></i></a>
                    </div>
                </form>
            </div>

            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1 class="title">
                            Hello <br />
                            staffs
                        </h1>
                        <p>If you are not staff, login here!</p>
                        <button class="ghost" id="customerlogin">
                            Customer login
                            <i class="fa-solid fa-arrow-left"></i>
                        </button>
                    </div>

                    <div class="overlay-panel overlay-right">
                        <h1 class="title">
                            Start your <br />
                            journey now
                        </h1>
                        <p>
                            If you are staff, login here!
                        </p>
                        <button class="ghost" id="stafflogin">
                            Staff login
                            <i class="fa-solid fa-arrow-right"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            window.addEventListener("load", function () {
                let message = localStorage.getItem("logoutMessage");
                if (message) {
                    alert(message);
                    localStorage.removeItem("logoutMessage");
                }
            });
        </script>
 
        <script src="./stylejs/effect.js"></script>
    </body>
</html>
