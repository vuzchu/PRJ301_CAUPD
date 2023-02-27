<%-- 
    Document   : signin
    Created on : Feb 27, 2023, 10:06:09 AM
    Author     : vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>/* Thiết lập các style cơ bản */
            * {
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                font-size: 14px;
                background-color: #f4f4f4;
            }

            .container {
                max-width: 400px;
                margin: 0 auto;
            }

            h2 {
                text-align: center;
                margin-top: 0;
            }

            /* Thiết lập style cho form đăng ký */
            #sign-up-form {
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.1);
            }

            .input-field {
                margin-bottom: 10px;
            }

            .input-field input[type="text"],
            .input-field input[type="email"],
            .input-field input[type="password"] {
                width: 100%;
                padding: 10px;
                border-radius: 3px;
                border: 1px solid #ddd;
                font-size: 16px;
                transition: border-color 0.3s;
            }

            .input-field input[type="text"]:focus,
            .input-field input[type="email"]:focus,
            .input-field input[type="password"]:focus {
                outline: none;
                border-color: #00bcd4;
            }

            .form-group {
                margin-top: 20px;
            }

            .btn {
                display: inline-block;
                padding: 10px 20px;
                border: none;
                background-color: #00bcd4;
                color: #fff;
                font-size: 16px;
                border-radius: 3px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .btn:hover {
                background-color: #008ba3;
            }
        </style>
    </head>
    <body>
        <!DOCTYPE html>


    <div class="container">
        <form id="sign-up-form">
            <h2>Đăng ký</h2>
            <div class="input-field">
                <input type="text" placeholder="Tên đăng nhập" name="username" required>
            </div>

            <div class="input-field">
                <input type="password" placeholder="Mật khẩu" name="password" required>
            </div>
            <div class="input-field">
                <input type="password" placeholder="Nhập lại mật khẩu" name="repass" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Đăng ký</button>
            </div>
        </form>


    </body>
</html>
