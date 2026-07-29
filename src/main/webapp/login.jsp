<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ChattBank - Login</title>

    <style>
        body { font-family: Arial, sans-serif; margin:0; background: #f4f6f8; color:#222;}
        header {background: #0b3a66; color: white; padding: 28px 18px; text-align: center;}
        main {max-width: 900px; margin: 30px auto; padding: 0 18px; text-align: center; color: #0b3a66;}
        .card {background: white; border-radius: 12px; padding: 18px; box-shadow: 0 4px 14px rgba(0,0,0,.15);}
        .field { margin: 14px 0; text-align: left; max-width: 360px; margin-left:auto; margin-right:auto; }
        label { display:block; margin-bottom:6px; font-weight: bold; color:#0b3a66; }
        input { width:100%; padding:10px; border: 1px solid #ccc; border-radius: 8px; }
        .btns { margin-top: 18px; display:flex; gap:10px; justify-content:center; }
        button { padding:10px 16px; border-radius: 8px; border:none; cursor:pointer; }
        .primary { background:#0b3a66; color:white; }
        .secondary { background:#e5e7eb; color:#111; }
        .link { display:inline-block; margin-top:14px; text-decoration:none; color:#0b3a66; font-weight:bold; }
        footer {text-align: center; padding: 18px; color: #666; font-size: 14px; }
    </style>

    <script>
        function validateLogin() {
            const custIdStr = document.getElementById("custId").value.trim();
            const password = document.getElementById("password").value.trim();

            if (custIdStr === "" || password === "") {
                alert("You must enter a valid Customer ID and Password.");
                return false;
            }

            const custIdNum = Number(custIdStr);

            if (!Number.isInteger(custIdNum)) {
                alert("Customer ID must be a number.");
                return false;
            }

            if (custIdNum < 3000 || custIdNum > 3999) {
                alert("Customer ID must be a 4-digit number between 3000 and 3999.");
                return false;
            }

            return true;
        }
    </script>
</head>

<body>
<header>
    <h1>ChattBank Login</h1>
    <p>Please enter your credentials.</p>
</header>

<main>
    <div class="card">
        <h2>Login</h2>

        <form action="LoginServlet" method="post" onsubmit="return validateLogin();">
        <div class="field">
                <label for="custId">Customer ID</label>
                <input type="text" id="custId" name="custId" placeholder="3000 - 3999" />
            </div>

            <div class="field">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter password" />
            </div>

            <div class="btns">
                <button type="submit" class="primary">Login</button>
                <button type="reset" class="secondary">Clear</button>
            </div>
        </form>

        <a class="link" href="index.jsp">← Back to Home</a>
    </div>
</main>

<footer>
    © 2026 ChattBank
</footer>
</body>
</html>