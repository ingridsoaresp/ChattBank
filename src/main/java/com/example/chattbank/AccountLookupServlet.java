package com.example.chattbank;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;

@WebServlet("/AccountLookupServlet")
public class AccountLookupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("accountLookup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String acctNoStr = request.getParameter("acctNo");

        if (acctNoStr == null || acctNoStr.isBlank()) {
            System.out.println("AccountLookupServlet: acctNo is blank.");
        } else {
            try {
                int acctNo = Integer.parseInt(acctNoStr.trim());

                Account a1 = new Account();
                a1.selectDB(acctNo);

                System.out.println("AccountLookupServlet Running...");
                a1.display();

                request.getSession().setAttribute("account", a1);

                RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccount.jsp");
                rd.forward(request, response);

            } catch (NumberFormatException nfe) {
                System.out.println("AccountLookupServlet: acctNo must be a number.");
                RequestDispatcher rd = request.getRequestDispatcher("/accountLookup.jsp");
                rd.forward(request, response);
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/accountLookup.jsp");
        try { rd.forward(request, response); } catch (Exception e) { throw new IOException(e); }
    }
}