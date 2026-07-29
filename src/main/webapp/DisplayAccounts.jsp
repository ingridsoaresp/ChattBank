<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.chattbank.Customer" %>
<%@ page import="com.example.chattbank.AccountList" %>
<%@ page import="com.example.chattbank.Account" %>

<%
    Customer c = (Customer) session.getAttribute("customer");
    AccountList aList = null;

    if (c != null) {
        aList = c.getAList();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>ChattBank - Display Accounts</title>
    <style>
        body { font-family: Arial, sans-serif; margin:0; background: #f4f6f8; color:#222; }
        header { background: #0b3a66; color: white; padding: 28px 18px; text-align: center; }
        main { max-width: 1000px; margin: 30px auto; padding: 0 18px; color: #0b3a66; }
        .card { background: white; border-radius: 12px; padding: 20px; box-shadow: 0 4px 14px rgba(0,0,0,.15); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #cfd6de; padding: 12px; text-align: center; }
        th { background: #0b3a66; color: white; }
        tr:nth-child(even) { background: #f8fafc; }
        .link { display:inline-block; margin-top:18px; text-decoration:none; color:#0b3a66; font-weight:bold; }
        footer { text-align: center; padding: 18px; color: #666; font-size: 14px; }
    </style>
</head>
<body>

<header>
    <h1>ChattBank Accounts</h1>
    <p>Customer Account List</p>
</header>

<main>
    <div class="card">
        <%
            if (c != null) {
        %>
        <h2>Welcome, <%= c.getCustFirstName() %> <%= c.getCustLastName() %></h2>
        <p><strong>Customer ID:</strong> <%= c.getCustId() %></p>
        <p><strong>Email:</strong> <%= c.getCustEmail() %></p>
        <p><strong>Address:</strong> <%= c.getCustAddress() %></p>
        <%
            }
        %>

        <h3>Accounts</h3>

        <table>
            <tr>
                <th>AcctNo</th>
                <th>CustID</th>
                <th>Type</th>
                <th>Balance</th>
            </tr>

            <%
                if (aList != null) {
                    for (int i = 0; i < aList.getCount(); i++) {
                        Account a = aList.get(i);
            %>
            <tr>
                <td><%= a.getAcctNo() %></td>
                <td><%= a.getCustId() %></td>
                <td><%= a.getType() %></td>
                <td><%= a.getBalance() %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>

        <a class="link" href="index.jsp">← Back to Home</a>
    </div>
</main>

<footer>
    © 2026 ChattBank
</footer>

</body>
</html>