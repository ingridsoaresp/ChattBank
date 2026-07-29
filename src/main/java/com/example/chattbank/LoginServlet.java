package com.example.chattbank;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String custIdStr = request.getParameter("custId");
        String pwgui = request.getParameter("password");

        if (custIdStr == null || pwgui == null || custIdStr.isBlank() || pwgui.isBlank()) {
            RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
            try { rd.forward(request, response); } catch (Exception e) { throw new IOException(e); }
            return;
        }

        int custId;
        try {
            custId = Integer.parseInt(custIdStr.trim());
        } catch (NumberFormatException nfe) {
            RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
            try { rd.forward(request, response); } catch (Exception e) { throw new IOException(e); }
            return;
        }

        Customer c1 = new Customer();
        c1.selectDB(custId);

        String pwdb = c1.getCustPassword();

        boolean validLogin = pwdb != null && !pwdb.isBlank() && pwgui.equals(pwdb);

        if (!validLogin) {

            request.getSession().setAttribute("customer", c1);

            RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
            try { rd.forward(request, response); } catch (Exception e) { throw new IOException(e); }
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("customer", c1);

        RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccounts.jsp");
        try { rd.forward(request, response); } catch (Exception e) { throw new IOException(e); }
    }
}