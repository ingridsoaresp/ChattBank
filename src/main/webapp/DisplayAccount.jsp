<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.chattbank.Account" %>
<%
    Account a = (Account) session.getAttribute("account");

    int acctNo = (a != null) ? a.getAcctNo() : 0;
    int custId = (a != null) ? a.getCustId() : 0;
    String type = (a != null) ? a.getType() : "";
    double balance = (a != null) ? a.getBalance() : 0.0;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ChattBank - Account Lookup</title>
    <style>
        body { font-family: Arial, sans-serif; margin:0; background: #f4f6f8; color:#222;}
        header {background: #0b3a66; color: white; padding: 28px 18px; text-align: center;}
        main {max-width: 900px; margin: 30px auto; padding: 0 18px; text-align: center; color: #0b3a66;}
        .card {background: white; border-radius: 12px; padding: 18px; box-shadow: 0 4px 14px rgba(0,0,0,.15);}
        .grid {display: grid; grid-template-columns: 1fr 1fr; gap: 10px 12px ; max-width: 720px; margin: 20px auto 0; text-align: left; justify-items: center;}
        label {display: block; margin-bottom: 6px; font-weight: bold; color: #0b3a66;}
        input {width: 100%; max-width: 320px; padding: 12px 14px; font-size: 16px; border: 1px solid #cfd6de; border-radius: 10px; box-sizing: border-box;}
        input:focus {outline: none; border-color: #0b3a66; box-shadow: 0 0 0 3px rgba(11,58,102,.15);}
        .btns {margin-top: 18px; display: flex; gap: 10px; justify-content: center;}
        button {padding: 10px 16px; border-radius: 8px; border:none; cursor:pointer;}
        .primary {background:#0b3a66; color:white;}
        .secondary {background:#e5e7eb; color:#111;}
        .link {display:inline-block; margin-top:14px; text-decoration:none; color:#0b3a66; font-weight:bold;}
        footer {text-align: center; padding: 18px; color: #666; font-size: 14px;}
        @media (max-width: 700px) {.grid {grid-template-columns: 1fr;}}
    </style>
</head>
<body>

<header>
    <h1>Account Lookup</h1>
    <p>Look up an account by entering details.</p>
</header>

<main>
    <div class="card">
        <p><strong>Lookup</strong></p>

        <form action="AccountLookupServlet" method="post">
            <div class="grid">
                <div>
                    <label for="acctNo">AcctNo</label>
                    <input type="text" id="acctNo" name="acctNo" value="<%= acctNo %>" />
                </div>
                <div>
                    <label for="custId">CustID</label>
                    <input type="text" id="custId" name="custId" value="<%= custId %>" />
                </div>
                <div>
                    <label for="type">Type</label>
                    <input type="text" id="type" name="type" value="<%= type %>" />
                </div>
                <div>
                    <label for="balance">Balance</label>
                    <input type="text" id="balance" name="balance" value="<%= balance %>" />
                </div>
            </div>

            <div class="btns">
                <button type="submit" class="primary">Lookup</button>
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