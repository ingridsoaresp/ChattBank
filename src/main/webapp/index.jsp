<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ChattBank</title>
    <style>
        body { font-family: Arial, sans-serif; margin:0; background: #f4f6f8; color:#222;}
        header {background: #0b3a66; color: white; padding: 28px 18px; text-align: center;}
        main {max-width: 900px; margin: 30px auto; padding: 0 18px; text-align: center; color: #0b3a66;}
        .card {background: white; border-radius: 12px; padding: 18px; box-shadow: 0 4px 14px rgba(0,0,0,.15);}
        .card img{ max-width: 280px; width: 100%; height: auto; object-fit: contain; border-radius: 10px; margin: 20px auto 0; display: block; }
        footer {text-align: center; padding: 18px; color: #666; font-size: 14px; }
        .nav-links { margin-top: 18px; }
        .nav-links a { display: inline-block; margin: 6px; padding: 10px 16px; background: #0b3a66; color: white;text-decoration: none;border-radius: 8px;font-weight:bold;}
    </style>
</head>
<body>
<header>
    <h1>Welcome to ChattBank</h1>
    <p>Your trusted partner in smart banking.</p>
</header>

<main>
    <div class="card">
        <p>This is the home page of ChattBank Web Application.</p>
        <img src="images/chattbanklogo.png" alt="ChattBank logo"/>
        <div class="nav-links">
            <a href="login.jsp">Login</a>
            <a href="accountLookup.jsp">Account Lookup</a>
        </div>
    </div>
</main>

<footer>
    © 2026 ChattBank
</footer>
</body>
</html>