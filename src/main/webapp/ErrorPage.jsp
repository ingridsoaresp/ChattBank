<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.chattbank.Customer" %>
<%
    Customer c = (Customer) session.getAttribute("customer");
    int cid = (c != null) ? c.getCustId() : 0;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Login Error - ChattBank</title>

    <style>
        body { font-family: Arial, sans-serif; margin:0; background: #f4f6f8; color:#222;}
        header {background: #0b3a66; color: white; padding: 28px 18px; text-align: center;}
        main {max-width: 900px; margin: 30px auto; padding: 0 18px; text-align: center; color: #0b3a66;}
        .card {background: white; border-radius: 12px; padding: 22px; box-shadow: 0 4px 14px rgba(0,0,0,.15);}
        .error {font-size: 22px; font-weight: bold; margin-bottom: 10px; color: #c0392b;}
        .btn {display:inline-block; margin-top:18px; padding:10px 16px; background:#0b3a66; color:white; text-decoration:none; border-radius:8px; font-weight:bold;}
        footer {text-align: center; padding: 18px; color: #666; font-size: 14px; }
    </style>
</head>

<body>

<header>
    <h1>Error Logging in for UserID <%= cid %></h1>
    <p>UserID <%= cid %>, invalid password!!</p>
</header>

<main>
    <div class="card">
        <div class="error">Invalid Login</div>
        <p>Your Customer ID or Password is incorrect.</p>
        <a class="btn" href="login.jsp">Back to Login</a>
    </div>
</main>

<footer>
    © 2026 ChattBank
</footer>

</body>
</html>